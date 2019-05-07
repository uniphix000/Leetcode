// author:uniphix
// date: 2019-05-06 14:49

/*
The Hamming distance between two integers is the number of
positions at which the corresponding bits are different.
Given two integers x and y, calculate the Hamming distance.

汉明距离：两个数二进制不同的位数

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.

思考和复杂度分析:
    √ 很显然想到的是位操作，既然要找到不同的位数，则想到异或：相同则结果为0，不同则为1，然后数出1的个数
    √ 
    √ 
    √ 

边界条件及特殊样例:

法一:  // (O(n),O(1))
法二:  // (O(n),O(1))
法三:  // (O(n),O(1))
法四:  // (O(n),O(1))

 */

class Solution {
    public int hammingDistance(int x, int y)
    {
        int xor = x^y;  // 输出的是一个数，现在需要输出这个数的二进制中1的位数
        return countOnes(xor);
        // return Integer.bitCount(xor);  // java内置的函数
    }

    private int countOnes(int n)
    {
         int count = 0;
         while (n!=0)
         {
             if(n%2==1)
                 count++;
             n = (n-n%2)/2;
         }
         return count;
    }

    private int countOnes1(int num)
    {
        int count = 0;
        while(num != 0)
        {
            num = num & (num - 1);  // 每次把最后一个1变成0
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int x = 1, y = 4;
        System.out.print(new Solution().hammingDistance(x, y));
    }
}




