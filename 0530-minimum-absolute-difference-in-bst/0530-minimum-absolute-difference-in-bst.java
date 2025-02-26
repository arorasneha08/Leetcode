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
    private void inorderTraversal(TreeNode root , ArrayList<Integer> list){
        if(root == null) return ; 
        
        inorderTraversal(root.left , list);
        list.add(root.val);
        inorderTraversal(root.right , list); 
    }
    public int getMinimumDifference(TreeNode root) {
        if(root == null) return 0  ; 
        ArrayList<Integer> res = new ArrayList<>() ; 
        inorderTraversal(root , res);
        
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < res.size(); i++) {
            minDiff = Math.min(minDiff, res.get(i) - res.get(i - 1));
        }

        return minDiff;
    }
}