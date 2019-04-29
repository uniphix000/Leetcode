// author:uniphix
// date: 2019-04-22 14:03

/*
Reverse a singly linked list.
反转链表
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Explanation:
Note: A linked list can be reversed either iteratively or recursively. Could you implement both?

思考: 有迭代和递归两种写法  !!注意，在这里修改head.next时，修改了引用，则整个head的next都会发生改变
     迭代:
prev   curr    next
   -->| | |-->| | |-->
next   prev    curr
   <--| | |-->| | |-->
      如何实现翻转:
      暂存向后的指针(后续的节点地址)，改变与前一节点的指针方向，重新确定前一节点，重新确定当前节点
      tmp = curr.next
      curr.next = prev
      prev = curr;
      curr = tmp;
      说明顺序的不可变性:首先要改变curr.next的指向，必须先暂存以免丢失，随后指向前面节点，再令prev为当前
      节点(如果先令当前节点为next，则当前节点丢失)，最后在令当前节点为next，完成反转。

     递归:
     n1->n2->n3->..nk->nk+1<-..nm完成这一步的反转

法一:  迭代// TC:O(n) SC:O(1))
法二:  递归
法三:  最好理解的一个版本:递归
法四:
 */

import java.util.Arrays;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode
{
    int val;
    ListNode next;
    ListNode(int x)
    {
        val = x;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) { //
        ListNode prev = null; // 最后将成为链表的结束
        ListNode curr = head;
        while (curr != null)
        {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;  // 结束时curr==null,故返回当前head的引用
    }

    public ListNode reverseList1(ListNode head)
    {
        if (head==null || head.next==null)
            return head;
        ListNode p = reverseList1(head.next); // 一直递归下去head是最后一个节点
        head.next.next = head;                // 倒数第二次调用将最后一个节点指向倒数第二个节点
        head.next = null;
        return p;
    }

    public ListNode reverseList2(ListNode head)  // 0ms 37.8MB:16.09%
    {
        return putPreAsAfter(head, null);  //
    }

    public ListNode putPreAsAfter(ListNode node, ListNode pre)
    {
        if (node==null) return pre; // 到达链表末尾
        ListNode next = node.next;
        node.next = pre;
        return putPreAsAfter(next, node); // 移到下一个节点
    }


    public static void main(String[] args) {
        // 准备数据
        ListNode head = new ListNode(1);
        ListNode node1 = head.next = new ListNode(2);
        ListNode node2 = node1.next = new ListNode(3);
        System.out.println(new Solution().reverseList(head).val);
    }
}






