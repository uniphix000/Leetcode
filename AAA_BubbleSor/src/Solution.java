// author:uniphix
// date: 2019-04-17 20:52

/*
Given a string s, find the longest palindromic substring in s.
 You may assume that the maximum length of s is 1000.
给定一个s，找到其中最长的回文子串
Input: 
Output: 
Explanation:
Note:

思考:

法一:  // TC:O(n^2) SC:O(n))
法二:
法三:
法四:
 */

import java.util.Arrays;

class Solution {
    public class BubbleSort implements Solution {
     public int[] sort(int[] sourceArray) throws Exception {
                    // 对 arr 进行拷贝，不改变参数内容
                    int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

                    for (int i = 1; i < arr.length; i++) {
                           // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
                           boolean flag = true;

                            for (int j = 0; j < arr.length - i; j++) {
                                   if (arr[j] > arr[j + 1]) {
                                            int tmp = arr[j];
                                            arr[j] = arr[j + 1];
                                            arr[j + 1] = tmp;

                                           flag = false;
                                        }
                                }

                            if (flag) {
                                    break;
                                }
                        }
                    return arr;
                }
}
}




