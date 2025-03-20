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
     
    ListNode head = null ; 
    public Solution(ListNode head) {
        this.head = head ; 
    }
    
    public int getRandom() {
        ListNode node = this.head ; 
        int i = 1; 
        int ans = 0 ;
        while(node != null){
            if(Math.random() * i < 1){
                ans = node.val ; 
            }
            node = node.next ; 
            i++ ; 
        }
        return ans; 
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */