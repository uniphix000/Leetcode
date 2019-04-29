// author:uniphix
// date: 2019-04-23 19:51

/*
Given a linked list, determine if it has a cycle in it.

To represent a cycle in the given linked list,
we use an integer pos which represents the position (0-indexed)
in the linked list where tail connects to. If pos is -1,
then there is no cycle in the linked list.
判断一个给定的链表是否成环
Input: 
Output: 
Explanation:
Note:
Can you solve it using O(1) (i.e. constant) memory?

思考:
    遍历该链表，如果该节点曾经被访问过，则成环。注意这里是节点被访问过而非节点的值
    每访问一个节点就把val置为INT_MIN
    快慢指针,让一个指针每次走一步，另一个每次走两步，如果没环则必会有一个先抵达null，反正
    如果有环则两个指针会重合。

法一:  // TC:O(n^2) SC:O(n))
法二:
法三:
法四:
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class ListNode
{
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
}

class Solution {
    //19:54-->20:22
    public boolean hasCycle(ListNode head)
    {
//        if (head==null || head.next==null) return false;
//
//        int i=0;
//        HashMap<Integer, Integer> maps = new HashMap<>();  // 需要考虑相同元素相邻问题
//        ListNode l = head;
//        int preval = l.val;
//        while (l.next!=null)
//        {
//            if (maps.containsKey(l.val) && l.val!=preval) return true;
//            else
//            {
//                maps.put(l.val, i++);
//                preval = l.val;
//                l = l.next;
//            }
//        }
//        return false;
        Set<ListNode> set = new HashSet<>();  // 6ms:7% 38.9MB:6%
        while (head!=null)
        {
            if (set.contains(head)) return true;
            else
            {
               set.add(head);
               head = head.next;
            }
        }
        return false;
    }

    //20:22-->20:35
    public boolean hasCycle1(ListNode head)  // 访问了一个节点就把其val置为min // 0ms
    {
        while (head!=null)
        {
            if (head.val==Integer.MIN_VALUE) return true;
            else
            {
                head.val = Integer.MIN_VALUE;
                head = head.next;
            }
        }
        return false;
    }

    //-->20:56
    public boolean hasCycle2(ListNode head)
    {
        if (head==null || head.next==null) return false;  // 注意这里为什么不能复制后再判断?
        ListNode slow = head;                             // fixme
        ListNode fast = head.next;
        while (slow!=fast)
        {
            //if (slow==null || fast==null) return false;  // runtime error?
            if (fast==null || fast.next==null) return false;
            else
            {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return true;
    }

}




