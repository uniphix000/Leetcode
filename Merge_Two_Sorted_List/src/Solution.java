// author:uniphix
// date: 2019-04-23 09:48

import java.util.List;

/*
Merge two sorted linked lists and return it as a new list.
The new list should be made by splicing together the nodes of the first two lists.
合并两个已经排好序的链表
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
Explanation:
Note:

思考:
    迭代,新建一个链表，在l1,l2之间来回切换
    递归

法一:  // TC:O(n^2) SC:O(n))
法二:
法三:
法四:
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)  // 1ms 37.1MB
    {
        ListNode merge = new ListNode(0);
        ListNode head = merge;
        while(l1!=null && l2!=null)
        {
            if (l1.val<=l2.val)
            {
                merge.next = l1;
                l1 = l1.next;
            }
            else
            {
                merge.next = l2;
                l2 = l2.next;
            }
            merge = merge.next; // merge.next不会丢失(指针)
        }
        if (l1==null)
            merge.next = l2;
        else
            merge.next = l1;
        return head.next;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2)  // 0ms 37.1MB
    {
        //考虑最后有一个null的情况
        if (l1==null)
            return l2;
        else if (l2==null)
            return l1;
        if (l1.val<l2.val)
        {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else
        {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        System.out.print(new Solution().mergeTwoLists1(l1, l2).val);
    }
}




