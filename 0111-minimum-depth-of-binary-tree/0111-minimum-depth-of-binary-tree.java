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
    public int minDepth(TreeNode root) {
        // if(root == null ) return 0 ; 

        // // for skewed trees .. 
        // if (root.left == null) return 1 + minDepth(root.right);
        // if (root.right == null) return 1 + minDepth(root.left);

        // int left = minDepth(root.left);
        // int right = minDepth(root.right);

        // return Math.min(left, right) + 1 ; 

        int depth = 1  ;
        if(root == null) return 0 ; 
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size(); 

            for(int i = 0 ; i < size ; i++){
                TreeNode curr = q.poll();
                if(curr.left == null && curr.right == null){
                    return depth ; 
                }
                if(curr.left != null){
                    q.offer(curr.left); 
                } 
                if(curr.right != null){
                    q.offer(curr.right); 
                }
            }
            depth ++ ; 
        }
        return depth ; 
    }
}