// author:uniphix
// date: 2019-04-17 10:13

/*
Given an array nums, write a function to move all 0's to the end of it
while maintaining the relative order of the non-zero elements.
给定数组，将所有的0放到末尾的同时不改变非0元素顺序
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Explanation:
Note:要求in-place的操作，即对数组本身的操作，不接收array的copy

思考:
    用队列保存非0元素，先入先出，最后用0补齐
    扫描一次，冒泡的交换0与非零元素


法一:
    用队列保存非0元素，先入先出，最后用0补齐 // TC:O(n^2) SC:O(n))
法二:
    设定累加器，如果遇到0则累加并扫描下一位，如果非0则根据累加器l与前第l个0位交换  //TC:O(n) SC:O(1)
法三:
    扫描数组，记录最后一个非0数的位置，如果遇到0则不看，如果非0则放到上一个非0数后面，最后补齐
法四:
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {  // 要求in-place的操作，即对数组的操作，不接收array的copy
    public int[] moveZeroes(int[] nums)
    {
        Queue<Integer> queue = new LinkedList<Integer>();
        int countZeros = 0;
        for (int i = 0; i < nums.length ; i++)
        {
            if(nums[i]!=0)
            {
                queue.offer(nums[i]);
            }
            else
            {
                countZeros++;
            }
        }
        int[] numsReturn = new int[nums.length];
        for (int i = 0; i < nums.length ; i++)
        {
            if (i<nums.length-countZeros)
            {
                numsReturn[i] = queue.poll();
            }
            else
            {
                numsReturn[i] = 0;
            }
        }
        nums = numsReturn;
        return nums;
    }

    public void moveZeroes1(int[] nums)  // 0ms, 39.6MB
    {
        int countZeros=0;
        for (int i = 0; i < nums.length; i++)
        {
            if(nums[i]==0) countZeros++;
            else swap(nums, i, i-countZeros);
        }
        System.out.print(Arrays.toString(nums));
    }

    public void moveZeroes2(int[] nums)  // 0ms, 49=0.2MB
    {
        int lastNonZero=0;
        for (int i = 0; i < nums.length; i++)
        {
            if(nums[i]!=0) //如果非0且不是第一个
            {
                nums[lastNonZero++] = nums[i];
            }
        }
        for (int j=lastNonZero;j<nums.length;j++)
        {
            nums[j] = 0;
        }
        System.out.print(Arrays.toString(nums));
    }

    private void swap(int[] nums, int x, int y)
    {
        int tmp = nums[y];
        nums[y] = nums[x];
        nums[x] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {0,1,0,3,12,1};
        //System.out.println(Arrays.toString(new Solution().moveZeroes(a)));
        new Solution().moveZeroes2(a);
    }
}




