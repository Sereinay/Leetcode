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
    }
}
