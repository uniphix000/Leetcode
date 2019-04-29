// author:uniphix
// date: 2019-04-29 08:51

/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps.
In how many distinct ways can you climb to the top?
爬梯子，每次可以爬1或2格，多少种路径
Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

思考和复杂度分析:
    √ 递归：复杂度很高，注意到并没有省去重复的算例
            5-(3,4)-((1,2),(2,3))--...(可以写成一个二叉树)
            事实上，时间复杂度为O(2^n)，而空间复杂度？为O(n) # fixme

   œ√ 迭代(斐波拉契)  // (O(n),O(1))
    √ 动态规划：令dp[i]为到达i点的路径数，则dp[i]=dp[i-1]+dp[i-2]  //(O(n),O(n))
    √ 递推矩阵：[[Fn+1 Fn], [Fn Fn-1]] = [[1 1], [1 0]]^n

边界条件及特殊样例:

法一:  递归 // (O(2^n),O(n))
法二:  迭代 // (O(n),O(1))
法三:  动态规划 // (O(n),O(n))
法四:  递推矩阵 // (O(lgn),O(1))

 */

class Solution {
    public int climbStairs(int n)
    {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        return climbStairs(n-2)+climbStairs(n-1);
    }

    public int climbStairs1(int n)
    {
        if(n==1) return 1;
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++)
        {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    public int climbStairs2(int n)  // 100% 100%
    {
        if(n==1)
            return 1;
        int[] dp = new int[n+1];
        dp[0]=0; dp[1]=1; dp[2]=2;
        for (int i = 1; i < n-1; i++) {
            dp[i+2] = dp[i]+dp[i+1];
        }
        return dp[n];
    }

    public int climbStairs3(int n)
    {
        int[][] q = {{1,1}, {1,0}};
        int[][] res = pow(q, n);  // 憨比java矩阵运算，真的吐了
        return res[0][0];
    }

    private int[][] pow(int[][] a, int n)
    {
        int[][] ret = {{1,1}, {1,0}};
        while (n>0)
        {
            if((n&1)==1) ret = multiply(ret, a);
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    private int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }

    public int climbStairs5(int n)
    {
        return 7&1;
    }


    public static void main(String[] args) {
        int n=5;
        System.out.print(new Solution().climbStairs5(n));
    }
}




