// author:uniphix
// date: 2019-04-20 10:58

/*
Given a string s and a non-empty string p,
find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only
and the length of both strings s and p will not be larger than 20,100.
The order of output does not matter.

若s中有p的某种排序则返回其开始的index

Input:
s: "cbaebabacd" p: "abc"
Output:
[0, 6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

思考:
    brute force:窗口滑动，检索s中各位，如果在p中，则判断从此位开始下n位是否是p的一个排序 // O(n*m)
    维护左右端点

法一:  // TC:O(n^2) SC:O(n))
法二:
法三:
法四:
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) // 397ms:22% 39.6MB:60%
    {
        List<Integer> anagram = new ArrayList<>(); // O(m!)不可以接受
        int pLen = p.length();
        int sLen = s.length();
        int[] hash = new int[256];

        if (pLen==0 || sLen==0 || pLen>sLen)
            return anagram;

        for (int i = 0; i < pLen ; i++)
        {
            hash[(int)p.charAt(i)]++;
        }

        for (int i = 0; i < sLen-pLen+1; i++)
        {
            int[] _hash = new int[256];
            System.arraycopy(hash,0,_hash,0,hash.length);
            int count=0;
            for (int j = 0; j < pLen; j++) // 判断窗口是否符合条件
            {
                if (_hash[(int)s.charAt(i+j)]>0)
                {
                    _hash[(int)s.charAt(i+j)]--;
                    count++;
                }
                else
                {
                    count = 0;
                    break;
                }
            }
            if (count==pLen) anagram.add(i);
        }
        return anagram;
    }

    public List<Integer> findAnagrams1(String s, String p)
    {
        int left = 0;
        int right = 0;
        int sLen = s.length();
        int pLen = p.length();
        int[] hash = new int[256]; // 一个p中各元素的hash，其实类似于python中的Counter或者经常用到的Lang()
        List<Integer> pos = new ArrayList<Integer>();

        for (int i = 0; i<pLen; i++)
        {
            hash[(int)p.charAt(i)]++;
        }
        System.out.print(Arrays.toString(hash));
        int count = 0;

        // 如果在hash中，则右端hash--,count++,right++
        // 如果不在hash中，则左端hash++,count--,left++
        // 而由于之前预置了p中的值进入hash，所以实际上hash表只是暂时存储p中不存在的元素
        while (right < sLen)  // 窗口滑动
        {
            if (hash[(int)s.charAt(right)] > 0) // 如果在p中
            {
                hash[(int)s.charAt(right)]--;
                count++;
                right++;
            }
            else
            {
                hash[(int)s.charAt(left)]++;
                count--;
                left++;
            }

            if(count == pLen)
            {
                pos.add(left);
            }
        }
        return pos;
}

    public static void main(String[] args) {
        String s = "aa";
        String p = "bb";
        System.out.print(new Solution().findAnagrams(s, p));
    }
}




