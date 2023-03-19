package linked_list;

/**
 * @author panda
 */
public interface listNode {
    /**
     * 链表的数据结构
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
