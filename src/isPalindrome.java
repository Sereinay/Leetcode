import java.util.ArrayList;
import java.util.List;

public class isPalindrome {
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public boolean isPalindrome(ListNode head) {
            List<Integer> var = new ArrayList<>();
            ListNode curr=head;
            while (curr!=null){
                var.add(curr.val);
                curr=curr.next;
            }

            int front=0;
            int rear=var.size()-1;
            while (front<rear){
                if (!var.get(front).equals(var.get(rear)))
                    return false;
                front++;
                rear--;
            }
            return true;
        }

        class Solution_1 {
            public boolean isPalindrome(ListNode head) {
                if (head==null)
                    return true;

                ListNode firstEnd=EndOfFirst(head);
                ListNode secondStart=reverseListNode(firstEnd.next);

                ListNode p1=head;
                ListNode p2=secondStart;
                boolean result=true;
                while (result&p2!=null){
                    if (p1.val!= p2.val)
                        result= false;
                    p1=p1.next;
                    p2=p2.next;
                }
                firstEnd.next=reverseListNode(secondStart);
                return result;
            }

            private ListNode reverseListNode(ListNode secondStart) {
//                这个函数对链表进行反转
                ListNode pre=null;
                ListNode curr=secondStart;
                while (curr!=null){
                    ListNode next=secondStart.next;
                    curr.next=pre;
                    pre=curr;
                    curr=next;
                }
                return pre;
            }

            private ListNode EndOfFirst(ListNode head) {
//                这个函数找前半部分链表末尾
                ListNode fast=head;
                ListNode slow=head;
                while (fast.next!=null&&fast.next.next!=null){
                    fast=fast.next.next;
                    slow=slow.next;
                }
                return slow;
            }
        }
    }
}
