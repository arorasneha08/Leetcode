/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode reverse(ListNode head){
        ListNode prev = null ; 
        ListNode next = null ;
        ListNode curr = head; 
        while(curr != null){
            next = curr.next ; 
            curr.next = prev; 
            prev = curr ;
            curr = next; 
        }
        return prev; 
    }
    public void reorderList(ListNode head) {
        if(head == null) return ; 
        ListNode slow = head; 
        ListNode fast = head; 
        while(fast != null && fast.next != null){
            slow = slow.next ;
            fast = fast.next.next ; 
        }
        ListNode first = head ;
        ListNode second = slow.next ; 
        slow.next = null ; 
        ListNode rev = reverse(second); 
    
        while (rev != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = rev.next;

            first.next = rev;
            rev.next = temp1;

            first = temp1; 
            rev = temp2;
        }
    }
}