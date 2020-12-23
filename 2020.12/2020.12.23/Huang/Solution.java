public class Solution{
	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		ListNode head = null, tail = null;
		int celui_ci, precedent = 0, n1, n2;
		
		while ((l1 != null) || (l2 != null)){
			if (l1 == null) n1 = 0; else n1 = l1.val;
			if (l2 == null) n2 = 0; else n2 = l2.val;
			if (n1 + n2 + precedent >= 10){
				celui_ci = n1 + n2 + precedent - 10;
				precedent = 1;
			}else{
				celui_ci = n1 + n2 + precedent;
				precedent = 0;
			}
			
			if (head == null){
				head = tail = new ListNode(celui_ci);
			}else{
				tail.next = new ListNode(celui_ci);
				tail = tail.next;
			}
			
			if (l1 != null) l1 = l1.next;
			if (l2 != null)	l2 = l2.next;
		}
		if (precedent > 0){
			tail.next = new ListNode(precedent);
		}
		
		return head;	
	}
}
