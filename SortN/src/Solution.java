// author:uniphix
// date: 2019-04-17 15:37

/*
有一个长为n的序列
    1,2,3,4,5,6,7
定义操作：每次都可以从序列中选择一个数放到最前面
现给定乱序序列：
    5,1,3,7,2,4,6
求最少操作次数

Input: 
Output: 
Explanation:
Note:

思考:
    可以考虑逆过程，即给定乱序序列，选第一个数插到序列中任意一个位置去
    那么可以发现规律:
    i.必定要放到1后去
    ii.插到从末尾往前数的有序序列中去
    最终得到：只需要计算末尾的有序序列长度l，则n-l为结果
法一:  // TC:O(n^2) SC:O(n))
法二:
法三:
法四:
 */

class Solution {
    public int sortN(int[] nums)
    {
        return 0;
    }

    public static void main(String[] args) {
        int[] ns = {5,1,3,7,2,4,6};
        System.out.print(new Solution().sortN(ns));
    }
}




