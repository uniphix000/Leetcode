// author:uniphix
// date: 2019-04-23 15:51

/*
Given two sorted integer arrays nums1 and nums2,
merge nums2 into nums1 as one sorted array.
合并两个数组
Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
Explanation:
Note:
The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space
(size that is greater or equal to m + n) to hold additional elements from nums2.

思考:
    重新定义一个数组,遍历m+n次,O(m+n)。过程较为繁琐且不是in-place操作
    合并数组再排序
    直接对nums1从尾部进行操作

法一:     // TC:O(n^2) SC:O(n))
法二:
法三:
法四:
 */

import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n)  // 繁琐,不是in-place操作
    {
        int[] nums = new int[m+n];
        int i=0,j=0,k=0;
        while(i!=m && j!=n)
        {
            if(nums1[i] <= nums2[j])
            {
                nums[k] = nums1[i++];
            }
            else
            {
                nums[k] = nums2[j++];
            }
            k++;
        }
        if (i==m)
        {
            for (int l = i+j; l < m+n; l++)
            {
                nums[l] = nums2[j++];
            }
            nums1 = nums;
        }
        else if (j==n)
        {
            for (int l = i+j; l < m+n; l++)
            {
                nums[l] = nums1[i++];
            }
            nums1 = nums;
        }
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n)
    {
        //首先将两个数组合并
        for (int i = m; i < m+n; i++) {
            nums1[i] = nums2[i-m];
        }
        //Arrays.sort(nums1); just kidding for fun

        System.out.print(Arrays.toString(nums1));
    }

    //19:35-->19:50
    public void merge2(int[] nums1, int m, int[] nums2, int n)  // 0ms 37.4MB
    {
        int i=m-1,j=n-1,k=m+n-1;
        while (i>=0 && j>=0)
            nums1[k--] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
        while (j>=0) // 如果nums2先被消耗完,即i>0，则无需操作，如果nums1先被消耗完
                     // 则还需要继续填入nums1前
            nums1[k--] = nums2[j--];
    }

    public static void main(String[] args) {
//        int[] nums1 = {1,2,3,4,9,222,0,0,0,0,0};
//        int[] nums2 = {2,5,6,7,111};
//        int m=6,n=5;
        int[] nums1 = {0};
        int[] nums2 = {1};
        int m=0,n=1;
        new Solution().merge2(nums1,m,nums2,n);
    }
}




