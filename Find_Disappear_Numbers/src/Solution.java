// author:uniphix
// date: 2019-04-17 18:38

/*
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
some elements appear twice and others appear once.
Find all the elements of [1, n] inclusive that do not appear in this array.
Could you do it without extra space and in O(n) runtime? You may assume the returned
list does not count as extra space.
找出array中没有出现的元素，注意到元素个数共计为n
Input: [4,3,2,7,8,2,3,1]
Output: [5,6]
Explanation:不使用额外的空间,O(n)
Note:

思考:
    python还蛮好做的，set()，for in range完事了..
    不能直接扫描array然后删除元素，不能开辟空间
    注意到元素个数为n，那么可以求和后根据和的大小推算出缺失元素吗
    则需要：找出重复元素，并计算差值
    如何找出重复元素又不增加额外空间呢？在每次访问数组中的数时，将其nums[nums[i]-1]所在的数
    置为其相反数，如果下次访问发现为负数，则可知nums[i]本身已经被访问过了，即为重复元素。
    这时，只需要再扫描一次把取值为正的输出即可。
    如:
    [4,3,2,7,8,2,3,1]-->[4,3,2,-7,..]-->[4,3,-2,-7,..]-->[-4,-3,-2,-7,-8,2,3,-1]

    而更直观的，将数组中的数还原到应有的位置上去

法一:  赋相反数法 // TC:O(n) SC:O(1))
法二:  还原位置法
法三:
法四:
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) // 6ms 93%; 48.1MB 95%
    {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) //每次都将nums[i]-1位的数变成负数，但是并不重复操作
        {                                     //如果<0则只为重复元素
            int idx = Math.abs(nums[i])-1;
            if (nums[idx]>0)
                nums[idx] *= -1;
        }
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i]>0)
                list.add(i+1);
        }
        return list;
    }

    public List<Integer> findDisappearedNumbers1(int[] nums)
    {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length ; i++)
        {
            if (nums[i]!=nums[nums[i]-1])
            {
                swap(nums, i, nums[i]-1);
                //再次检查,如果是未出现的数，则会在下次检查的时候通过
                //通过条件是归位或者使得两个位置上的数相等
                //有解性说明: fixme
                i--;
            }
        }
        System.out.println(Arrays.toString(nums));
        return list;
//        for (int i = 0; i < nums.length; i++)
//        {
//            if (nums[i]!=)
//        }
    }

    private void swap(int[] nums, int x, int y)
    {
        int tmp = nums[y];
        nums[y] = nums[x];
        nums[x] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,3,3,1,7,6,1};
        System.out.println(new Solution().findDisappearedNumbers1(nums));
    }
}




