// author:uniphix
// date: 2019-05-02 10:23

/*
Design a stack that supports push, pop, top, and retrieving the minimum element
in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.  需要常数时间

实现一个minStack

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.

思考和复杂度分析:
    √ 考虑用自定义的链表来实现
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
    public String longestPalindrome(String s) {
        return "";
    }

    public static void main(String[] args) {
        String s = "abbac";
        System.out.print(new Solution().longestPalindrome(s));
    }
}

class MinStack {

    /** initialize your data structure here. */
    class Node
    {
        int value;
        int min;
        Node next;
        Node(int x, int min)  // 构造方法，可以在初始化的同时完成赋值
        {
            this.value = x;
            this.min = min;
            next = null;
        }
    }

    Node head;
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    public MinStack() {

    }  // 空的构造方法

    public void push(int x)
    {
        if(head==null)
            head = new Node(x, x);  // 用value,min来初始化
        else
        {
            Node n = new Node(x, Math.min(x, head.min));
            n.next = head;
            head = n;
        }
    }

    public void pop()
    {
        if (head!=null)
            head = head.next;
    }

    public int top()
    {
        if(head!=null)
            return head.value;
        return -1;
    }

    public int getMin()
    {
        if(head!=null)
            return head.min;
        return -1;
    }
}




