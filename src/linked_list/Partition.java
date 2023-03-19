package linked_list;

/**
 * @author panda
 * @url https://leetcode.cn/problems/partition-list/
 */
public class Partition implements listNode{
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return head;
        }

        ListNode sh = new ListNode(0);
        ListNode st = sh;
        ListNode bh = new ListNode(0);
        ListNode bt = bh;

        while(head!=null){
            if(head.val < x){
                st = st.next = head;
            }else{
                bt = bt.next = head;
            }
            head = head.next;
        }

        st.next = bh.next;
        bt.next = null;

        return sh.next;
    }
}
