/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if(root.left == null) return -1; 
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int secondMin = Integer.MAX_VALUE; 
        int min = root.val; 
        boolean found = false; 

        while(!q.isEmpty()){
            TreeNode curr = q.poll(); 
            if(curr.left != null){
                q.offer(curr.left);
                q.offer(curr.right); 

                if(curr.left.val > min){
                    secondMin = Math.min(secondMin , curr.left.val); 
                    found = true; 
                }
                if(curr.right.val > min){
                    secondMin = Math.min(secondMin , curr.right.val); 
                    found = true; 
                }
            }
        }
        return found ? secondMin : -1 ; 
    }
}