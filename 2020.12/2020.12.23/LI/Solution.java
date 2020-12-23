
/*public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
} */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        ListNode next = null;
        int val;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0){
            val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            val += carry;
            carry = val / 10;
            val = val % 10;
            next = new ListNode(val);
            
            cur.next = next;
            cur = next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }// Lambda on l1.next will be 1ms slower
        }
        return res.next;
    }
}
