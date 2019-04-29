// author:uniphix
// date: 2019-04-18 13:58

/*
Given an array of size n, find the majority element.
The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.
找出一个数组中超过半数的数
Input: [3,2,3]
Output: 3
Explanation:
Note:

思考:
    遍历寻找看每个元素是否是主要元素
    hashmap,相当于python中的词典的感觉
    由于题设规定必定存在超过半数的值，那么每遇到一对不同的数就将其删除，则剩下的数必定为超过半数的数
    分而治之:我们将问题分成左右半边的最大元素，并递归下去直到长度为1

法一: BF+提前退出 // TC:O(n^2) SC:O(1))
法二: hashmap // O(n) O(n) hashmap构建过程时间复杂度为n，在存储时，不会超过n个值，故空间复杂度为n
法三: 排序后直接下标判定 // O(nlgn) O(1)/O(n) 快排复杂度   空间上我们可以in-place排序，这时不算做内存
法四: 分治
 */

import java.util.*;

class Solution {
    public int majorityElement(int[] nums) // brute force: 1240ms:5% 42.7MB:26.11%
    {
        int majorityCount = nums.length/2;
        for(int num: nums)
        {
            int count=0;
            for (int elem:nums)
                if (elem == num) count+=1;
            if (count > majorityCount)
                return num;
        }
        return -1;
    }

    public int majorityElement1(int[] nums) // hashmap: 11ms:40%
    {
        HashMap<Integer, Integer> maps = new HashMap<>();
        int val=0;
        for (int i = 0; i < nums.length; i++) {
            val = nums[i];
            if (!maps.containsKey(val)) //
                maps.put(val,0);
            int num = maps.get(val)+1;
            maps.replace(val,num);
            if(num>nums.length/2)
                return val;
        }
        return -1;
    }

    public int majorityElement2(int[] nums)  // 2ms:87.48% 42.6MB:26%
    {
        int count=0;
        int val=0;
        for (int i = 0; i < nums.length; i++)
        {
            if(count==0)
            {
                val = nums[i];
                count++;
            }
            else
            {
                if (nums[i]!=val)
                    count--;
                else
                    count++;
            }
            if (count>nums.length/2) // 提前退出
                return val;
        }
        return val;
    }

    public int majorityElement3(int[] nums)
    {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public int majorityElement4(int[] nums) // divide and conquer
    {
        return majorityElementRec(nums, 0, nums.length-1);
    }

    private int majorityElementRec(int[] nums, int lo, int hi)
    {
        if (lo==hi)
            return nums[lo];

        int mid = (hi-lo)/2+lo;
        int left = majorityElementRec(nums, lo, mid); //左半边得出的众数
        int right= majorityElementRec(nums, mid+1, hi);

        if (left==right) // 如果得出的众数相同则直接返回
            return left;

        int leftCount = countInRange(nums, left, lo, hi); // 否则比较个数多少
        int rightCount = countInRange(nums, right, lo, hi);
        return leftCount > rightCount ? left: right;
    }

    private int countInRange(int[] nums, int num, int lo, int hi)
    {
        int count = 0;
        for (int i = lo; i <= hi ; i++)
        {
            if (nums[i]==num)
                count++;
        }
        return count;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,1,3,1};
        System.out.print(new Solution().majorityElement4(nums));
    }
}




