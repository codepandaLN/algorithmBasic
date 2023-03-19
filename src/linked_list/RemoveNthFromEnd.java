package linked_list;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author panda
 * @uel https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthFromEnd implements listNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //p指向当前待处理元素
        ListNode p = head.next;
        //若成功，q指向倒数第k-1个元素
        ListNode q = head;
        int i = 1;

        while (i < n) {
            i++;
            p = p.next;
        }
        if (p == null) {
            return q.next;
        }
        //k ?? k-1
        while (p.next != null) {
            q = q.next;
            p = p.next;
        }

        q.next = q.next.next;

        return head;
    }

    /**
     * 两次遍历
     * @param head 链表头节点
     * @param n 倒数第n个节点
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }

    /**
     * 栈的解法：删除第n个，相当于取出第n个删掉
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    /**
     * 双指针
     * @param head
     * @param n
     * @return
     */

    public ListNode removeNthFromEnd4(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }


    public static void main(String[] args) {
        ListNode list = new ListNode();
        list.val = 1;
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        removeNthFromEnd.removeNthFromEnd(list, 1);


    }

}
