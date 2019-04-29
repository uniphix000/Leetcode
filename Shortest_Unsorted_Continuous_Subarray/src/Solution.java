// author:uniphix
// date: 2019-04-19 19:38

/*
Given an integer array, you need to find one continuous subarray
that if you only sort this subarray in ascending order, then the whole array
will be sorted in ascending order, too.
You need to find the shortest such subarray and output its length.
找到一个连续的子串，使得在排序该子串后整个序列都变得有序(正序)，输出其长度
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order
to make the whole array sorted in ascending order.
Note:

思考:
    先排序，再从两头诸位比较
    考虑待排序序列的特点：极值不在连续序列端点处(最小值不在连续序列左端，最大值不在右端),
    反之，如果左端点大于目前最小值，则可以更新序列端点；右边同理

法一:  排序法// TC:O(nlgn) SC:O(n)
法二:  维护两个端点 // TC:O(n) SC:O(1)
法三:
法四:
 */

import java.util.Arrays;

class Solution {
    public int findUnsortedSubarray(int[] nums) // 7ms:88% 41.4MB 63%
    {
        int[] sortednums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortednums);
        if (Arrays.equals(nums, sortednums))
            return 0;
        int usLen = nums.length;
        for (int i = 0; i < nums.length; i++)
        {
            if (sortednums[i]==nums[i])
                usLen--;
            else
                break;
        }
        for (int j = nums.length-1; j > 0; j--)
        {
            if (sortednums[j]==nums[j])
                usLen--;
            else
                break;
        }
        return usLen;
    }

    public int findUnsortedSubarray1(int[] nums)
    {
        int n = nums.length, beg = -1, end = -2, min = nums[n-1], max = nums[0];
        for (int i=1;i<n;i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n-1-i]);
            if (nums[i] < max) end = i;  // 从前向后扫描，寻找小于最大数的后一位,
            if (nums[n-1-i] > min) beg = n-1-i;  // 从后从前扫描，寻找大于最小值的前一位
        }
        return end - beg + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,3};
        System.out.print(new Solution().findUnsortedSubarray(nums));
    }
}




