// author:uniphix
// date: 2019-04-18 20:34

/*
买卖股票

思考:


法一: Brute Force+大小判断 // TC:O(n^2) SC:O(1))
法二: 维护两个数 // O(n)
法三:
法四:
 */

import java.util.HashMap;

class Solution {
    public int maxProfit(int[] prices) // 163ms:9% 40MB:5%
    {
        int oaMax=0;
        for (int i = 0; i < prices.length; i++)
        {
            int curMax=0;
            for (int j = i+1; j < prices.length; j++)
            {
                if (prices[i]>prices[j])
                    continue;
                else
                    curMax = Math.max(curMax, prices[j]-prices[i]);
            }
            oaMax = Math.max(oaMax, curMax);
        }
        return oaMax;
    }

    public int maxProfit1(int[] prices)
    {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.print(new Solution().maxProfit1(prices));
    }
}




