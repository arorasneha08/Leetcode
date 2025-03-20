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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head; 

        ListNode d = new ListNode(-1);
        ListNode prev = d ;
        ListNode curr = head; 
        prev.next = head; 
        while(curr != null && curr.next != null){
            ListNode nextNode = curr.next ;
            if(curr.val == nextNode.val){
                while(nextNode != null && curr.val == nextNode.val){
                    curr = curr.next;
                    nextNode = nextNode.next; 
                }
                prev.next = nextNode; 
            }
            else{
                prev = prev.next ; 
            }
            curr = curr.next; 
        }
        return d.next ; 
    }
}