// author:uniphix
// date: 2019-04-19 17:42

/*
Given an integer array nums, find the contiguous subarray
(containing at least one number) which has the largest sum and return its sum.
和最长的子串
Input: [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Note:

思考:
    蛮经典的一题,先考虑分治，求全局的最长子串可先分别求左右两边的最长子串，但是考虑到穿越边界的问题，则单独考虑
    维护两个数，Sum和preSum，preSum记录累加和，一旦小于0则断掉(影响了全局Sum的大小)
    -2  1 -3  4 -1 2 1 -5 4
    -2 -1 -4  0 -1 1 2 -3 1   记录最长前缀和s[i]，则以每一位作为结尾的最大子串和为当前位的s[i]-smin



法一: 分治 // TC:O(n^2) SC:O(n))
法二: 维护两个数
法三: 最大前缀和
法四:
 */

import java.lang.management.ManagementFactory;
import java.util.Arrays;

class Solution {
    public int maxSubArray(int[] nums) // 1ms:98% 39.5MB:65%
    {
        return maxSubArrayRec(nums, 0, nums.length-1);
    }

    private int maxSubArrayRec(int[] nums, int lo, int hi)
    {
        if (lo>=hi)
            return nums[lo];
        int mid = (hi-lo)/2+lo;
        int leftMax = maxSubArrayRec(nums, lo, mid-1); // 严格不包含中间数
        int rightMax = maxSubArrayRec(nums, mid+1, hi);
        return Math.max(Math.max(leftMax, rightMax), crossSubArray(nums, lo, mid, hi));
    }

    private int crossSubArray(int[] nums, int lo, int mid, int hi)
    {
        int leftSum=0;
        int leftMaxSum=0;
        int rightSum=0;
        int rightMaxSum=0;
        if (lo==mid)
            leftMaxSum = 0;
        else
        {
            for (int i = mid-1; i >= lo ; i--) {
                leftSum += nums[i];
                leftMaxSum = Math.max(leftMaxSum, leftSum);
            }
        }
        if (mid==hi)
            rightMaxSum = 0;
        else
        {
            for (int j = mid+1; j <= hi ; j++) {
                rightSum += nums[j];
                rightMaxSum = Math.max(rightMaxSum, rightSum);
            }
        }
        return nums[mid]+Math.max(0, leftMaxSum)+Math.max(0, rightMaxSum);
    }

    public int maxSubArray1(int[] nums) // 0ms:100% 38.9MB:87%
    {
        int maxSum=Integer.MIN_VALUE;
        int preSum=0;
        for (int i = 0; i < nums.length; i++)
        {
            preSum += nums[i];
            maxSum = Math.max(maxSum, preSum);
            if (preSum<0)
                preSum = 0;
        }
        return maxSum;
    }

    public int maxSubArray2(int[] nums)  // 1ms:97% 39MB:86%
    {
        int maxSum = Integer.MIN_VALUE;  // 记录以i为结尾的最大子串和
        int sMin = 0;  // 记录前缀和的最小值
        int sNow = 0;  // 记录当前位置的前缀和
        for (int i = 0; i < nums.length; i++)
        {
            sNow += nums[i];
            maxSum = Math.max(sNow - sMin,maxSum);
            sMin = Math.min(sMin, sNow);
        }
        return maxSum;
    }



    public static void main(String[] args) {
        //int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = {1};
        System.out.print(new Solution().maxSubArray2(nums));
    }
}




