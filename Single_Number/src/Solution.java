// author:uniphix
// date: 2019-04-20 10:12

/*
Given a non-empty array of integers,
every element appears twice except for one. Find that single one.
找到那个只出现了一次的数,注意其余数均出现了两次
Input: [2,2,1]
Output: 1
Explanation:
Note:

思考:
    hashmap
    XOR:理解按位异或: N^0=N, N^N=0，满足交换律结合律

法一:  // TC:O(n^2) SC:O(n))
法二:
法三:
法四:
 */

import java.sql.SQLOutput;
import java.util.HashMap;

class Solution {
    public int singleNumber(int[] nums) // 0ms:100%
    {
        int n=0;
        for (int num:nums)
            n ^= num;
        return n;
    }

    public int singleNumber1(int[] nums)  // 7ms:33%
    {
        HashMap<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!maps.containsKey(nums[i]))
            {
                maps.put(nums[i], 0);
            }
            else
                maps.remove(nums[i]);
        }
        return (int)maps.keySet().toArray()[0];
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.print(new Solution().singleNumber(nums));
    }
}




