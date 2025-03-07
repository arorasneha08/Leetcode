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
    private void swap(ListNode a, ListNode b){
        int temp = a.val ;
        a.val = b.val;
        b.val = temp ; 
    }
    public ListNode insertionSortList(ListNode head) {
        ListNode temp = head ; 
        ListNode curr = head; 
        while(temp != null){
            while(curr != temp){
                if(curr.val > temp.val){
                    swap(curr , temp); 
                }
                curr = curr.next ; 
            }
            curr = head; 
            temp = temp.next ; 
        }
        return head; 
    }
}