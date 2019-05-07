// author:uniphix
// date: 2019-05-02 09:30

/*
You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed, the only constraint
stopping you from robbing each of them is that adjacent houses have
security system connected and it will automatically contact the police
if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of
money of each house, determine the maximum amount of money you can
rob tonight without alerting the police.

找到一个序列的间隔最大和

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.

Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.

思考和复杂度分析:
    √ 动态规划:
        递推条件:由于各个节点之间有约束关系，所以只考虑当前轮，选择有两种，抢或者不抢，
        如果抢，则dp[i]=nums[i]+dp[i-2]，如果不抢，则dp[i]=dp[i-1]
    √ 维护两个数
    √ 
    √ 

边界条件及特殊样例:

法一:  动态规划 // (O(n),O(n))
法二:  维护两个数 // (O(n),O(1))
法三:  // (O(n),O(1))
法四:  // (O(n),O(1))

 */

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int rob(int[] nums)  // 0ms:100% 35.5MB:92.14%
    {
        int len = nums.length;
        // 边界条件
        if(len<1)
            return 0;
        if (len==1)
            return nums[0];
        if(len==2)
            return Math.max(nums[0], nums[1]);

        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++)
        {
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
        }
        return dp[len-1];
    }

    public int rob1(int[] nums)  // 0ms:100% 35.5MB:92.14%
    {
        int preNo = 0, preYes = 0;
        for (int n:nums)
        {
            int tmp = preNo;
            preNo = Math.max(preNo, preYes);  // 如果该轮不抢，则选取之前的最大值
            preYes = n+tmp; // 如果该轮抢，则将该轮加上上一轮不抢的累加和
        }
        return Math.max(preNo, preYes);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.print(new Solution().rob(nums));
    }
}




