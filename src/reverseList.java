import java.util.List;

public class reverseList {
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

    //      23.反转链表
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }
            return pre;
        }
    }
    //    上文解法是利用了迭代的思路 维护了三个指针来进行原地置逆

    public ListNode reverseList_1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList_1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
//    至于解法二则是利用了递归的思路来解答

}
