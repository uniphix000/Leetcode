// author:uniphix
// date: 2019-04-17 09:23

/*
The Hamming distance between two integers is the number of positions at
which the corresponding bits are different.
Given two integers x and y, calculate the Hamming distance.
hamming距离就是两个数字二进制中不一样的位数
Input: x = 1, y = 4
Output: 2
Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

思考:用短除法得到二进制表示，找到两者第一个非0位，开始比较

法一:  // TC:O(n^2) SC:O(n))
法二:
法三:
法四:
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int hammingDistance(int x, int y) {
        while()

    }

    private int binaryConv(int num) {
        List<Integer> bi = new ArrayList<Integer>();
        while(num!=0)
        {
            bi.add(num%2);
            num /= 2;
        }
        System.out.println(Arrays.toString(bi));

    }

    public static void main(String[] args) {
        String s = "abbac";
        Solution sol = new Solution();
        System.out.print(sol.hammingDistance(s));
    }
}




