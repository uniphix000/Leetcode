// author:uniphix
// date: 2019-04-24 15:07

/*
Given a singly linked list, determine if it is a palindrome.
判定回文链表
Input: 1->2
Output: false

Input: 1->2->2->1
Output: true

Explanation:
Note: Could you do it in O(n) time and O(1) space?

思考和复杂度分析:
    √ 反转链表后判断是否相等-->在反转链表的时候破坏了原来的链表，故不好直接比较--->可以用数组保存val比较
                                                                                (O(n),O(n))
    √ 从头到尾遍历链表，val入队，同时做逆转，第二遍反向遍历，并判断是否回文(O(n),O(n))
    √ 同样是遍历两遍，重要在于如何使用O(1)空间，我们用Sum来判断:  (O(n),O(1))
        用递增的i来对2进行移位并乘上val并累和(val*2<<i)，同时逆转，最后反向遍历再累和，如果和相等则说明回文；
        但是严格来说这是不严谨的:比较严谨的做法: hash=hash*进制+p.val(进制是一个较大素数)
    √ 寻找链表的中点：可以用快慢指针来实现，当快指针到达链表末尾时，慢指针所在位置即为中点；找到中点后，
      就地逐一反转链表与前半段比较。由于后者是in-place操作所以O(1)  (O(n),O(1))

边界条件及特殊样例:

法一: 直接反转  // TC:O(n) SC:O(n))
法二: 队列  // TC:O(n) SC:O(n))
法三: sum比较法  // TC:O(n2) SC:O(1))  不够严谨
法四: 找中点分两段比较  // TC:O(n) SC:O(1)) 比较繁琐
 */

import java.util.*;
import java.io.*;
import java.util.Queue;

//public class ListNode implements Cloneable{
//
//}
class ListNode implements Serializable
{
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
}

class Solution {
    public boolean isPalindrome(ListNode head) throws IOException, ClassNotFoundException
                // 解决深拷贝问题
    {
        //将对象转换为字节流写入流中

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(head);

        //从流里读出来
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        ListNode _head = (ListNode) ois.readObject();
        baos.close();
        oos.close();
        bais.close();
        ois.close();


        //ListNode _head = head; // 都是浅拷贝，但是令head=null不会导致_head为空
        ListNode __head = head;
        //int[] vals = new int[256];
        //int i = 0;
        while (head!=null)
        {
            //vals[i] = head.val;
            head.val = 0;
            break;
        }
        //System.out.print(Arrays.toString(vals));
        //ListNode reverse_head = reverse(__head);
        ListNode pre = null;
        ListNode curr = _head;
        while(curr!=null)
        {
            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        //return (head==reverse_head);
        return false;
    }

    private ListNode reverse(ListNode head)
    {
        ListNode pre = null;
        ListNode curr = head;
        while(curr!=null)
        {
            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        return pre;
//        if (head==null || head.next==null)
//            return head;
//        ListNode p = reverse(head.next); // 一直递归下去head是最后一个节点
//        head.next.next = head;                // 倒数第二次调用将最后一个节点指向倒数第二个节点
//        head.next = null;
//        return p;
    }

    public boolean isPalindrome1(ListNode head)  // 3ms:21%  42.7MB
    {
        ListNode pre = null;
        ListNode curr = head;
        Queue<Integer> q = new LinkedList<Integer>();
        while(curr!=null)
        {
            q.add(curr.val);
            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        head = pre;
        while (head!=null)
        {
            if (head.val != q.poll()) return false;
            head= head.next;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next!=null && fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow 在偶数时为n/2-0.5 奇数时为中点
        while (head!=slow)
        {

        }
        return true;
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException{
        ListNode head = new ListNode(1);
        ListNode node1 = head.next = new ListNode(0);
        ListNode node2 = node1.next = new ListNode(2);
        //ListNode node3 = node2.next = new ListNode(1);
        node2.next = null;

        System.out.print(new Solution().isPalindrome2(head));
    }
}




