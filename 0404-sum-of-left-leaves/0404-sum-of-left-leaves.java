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
    private boolean isLeaf(TreeNode root){
        return (root.left == null && root.right == null); 
    }
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return root.val ; 
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root); 
        int sum = 0; 

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0 ; i < size ; i++){
                TreeNode curr = q.poll(); 
                if(curr.left != null){
                    if(isLeaf(curr.left)){
                        sum += curr.left.val ; 
                    }
                    else{
                        q.offer(curr.left); 
                    }
                }
                if(curr.right != null){
                    q.offer(curr.right); 
                }
            }
        }
        return sum ; 
    }
}