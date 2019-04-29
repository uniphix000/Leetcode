// author:uniphix
// date: 2019-04-24 20:27

import java.util.ArrayList;
import java.util.Arrays;

/*
Write a program to find the node at which the intersection
of two singly linked lists begins.
找到两个链表开始相交的点(后续皆为重合)
Input: 
Output: 
Explanation:
Note:
    如果没有交点return null
    不能破坏结构-->不能逆转
    无环
    (O(n),O(1))

思考和复杂度分析:
    √ 分别遍历两个链表，并用数组存储，反向比较两个数组，确定相同的项目，再遍历一次某一个链表，找出交点(麻烦)
    √ 考虑A+B与B+A的末尾一定相同并且对齐，维护两个指针，让pA和pB进行的遍历，当pA遍历完A则继续遍历B，pB遍历完A则继续遍历B，当pA==pB则结束并返回
        如何处理不相交链表：保存A和B的最后一个位置，如果不同则返回null; (O(m+n),O(1))
    √ 
    √ 

边界条件及特殊样例:

法一:  // (O(n),O(1))
法二:  维护两个指针 // (O(m+n),O(1))
法三:  // (O(n),O(1))
法四:  // (O(n),O(1))

 */
class ListNode
{
    int val;
    ListNode next;
    ListNode(int x) {val=x;}
}

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        ArrayList<Integer> lA = getListNodeArray(headA);
        ArrayList<Integer> lB = getListNodeArray(headB);
        ArrayList<Integer> l = new ArrayList<>();
        int lenA = lA.size(),lenB = lB.size();
        int recurLength = Math.min(lenA, lenB);
        int commonLength = 0;

        for (int i = 0; i < recurLength; i++)
        {
            if (lA.get(lenA-i-1)==lB.get(lenB-i-1)) commonLength++;
            else break;
        }

        for (int i = 0; i < commonLength; i++)
        {
            l.add(lA.get(lenA-i-1));
        }

        int point=0,count = 0;
        while (headA!=null)
        {
            if (headA.val==l.get(point))
            {
                point++;
            }
            else break;
        }
        return null;
    }

    private ArrayList getListNodeArray(ListNode head)
    {
        ArrayList<Integer> l = new ArrayList<>();
        while (head!=null)
        {
            l.add(head.val);
            head = head.next;
        }
        return l;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB)
    {
        if(headA==null || headB==null) return null;
        ListNode pA = headA, pB = headB;
        ListNode lastA = null, lastB = null;
        while (true) {
            if (pA == pB) return pA;

            if (pA.next == null) {
                lastA = pA;
                pA = headB;
            }
            else pA = pA.next;
            if (pB.next == null) {
                lastB = pB;
                pB = headA;
            }
            else pB = pB.next;


            if (lastA!=null && lastB!=null && lastA != lastB) return null;
        }
    }  // 1ms:98% 38.8MB:8%

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) //上面的精简版
    {
        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        // 如果两者不相交，则a和b最后会都为null从而相等并返回

        return a;
    }


    public static void main(String[] args) {
        ListNode lA = new ListNode(1);

        System.out.print(new Solution().getIntersectionNode(lA, lA));
    }
}




