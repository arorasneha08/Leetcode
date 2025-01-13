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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null ) return head; 
        ListNode dummy = new ListNode(-1); 
        ListNode curr = head ;
        ListNode prev = dummy ; 
        while(curr != null && curr.next != null){
            ListNode first = curr.next ;
            ListNode second = curr.next.next ;
            first.next = curr ; 
            curr.next = second ;
            prev.next = first ;
            prev = curr; 
            curr = second ;
        }
        return dummy.next ; 
    }
}