// author:uniphix
// date: 2019-04-27 18:51

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.
判断括号的合理性
Input: "([)]"   不能使用多个计数器
Output: false
Explanation:
Note:

括号匹配问题，用栈

思考和复杂度分析:
    √ 用栈来判断，遇到右括号出栈时栈顶必须是匹配的左括号，并且不能为空
    √ 用hashmap来存储括号，稍微干净一点的做法
    √ 
    √ 

边界条件及特殊样例:

法一:  // (O(n),O(1))
法二:  // (O(n),O(1))
法三:  // (O(n),O(1))
法四:  // (O(n),O(1))

 */

import java.util.HashMap;
import java.util.Stack;

class Solution {

    private HashMap<Character, Character> maps;

    public Solution()
    {
        this.maps = new HashMap<Character, Character>();
        this.maps.put('}','{');
        this.maps.put(']','p');
        this.maps.put(')','(');
    }

    public boolean isValid(String s)  // 2ms
    {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++)
        {
            String p = String.valueOf(s.charAt(i));
            if (p.equals("[")) stack.push(p);
            else if (p.equals("]"))
            {
                if (stack.empty()) return false;
                if (stack.peek().equals("[")) stack.pop();
                else return false;
            }
            if (p.equals("(")) stack.push(p);
            else if (p.equals(")"))
            {
                if (stack.empty()) return false;
                if (stack.peek().equals("(")) stack.pop();
                else return false;
            }
            if (p.equals("{")) stack.push(p);
            else if (p.equals("}"))
            {
                if (stack.empty()) return false;
                if (stack.peek().equals("{")) stack.pop();
                else return false;
            }
        }

        if(stack.empty())
            return true;
        else return false;
    }

    public boolean isValid1(String s) //
    {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++)
        {
            char p = s.charAt(i);

            if(this.maps.containsKey(p))
            {
                char topElement = stack.empty() ? '#' : stack.pop();

                if (topElement!=this.maps.get(p))
                    return false;
            }
            else stack.push(p);
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "[]}]]";
        System.out.print(new Solution().isValid1(s));
    }
}




