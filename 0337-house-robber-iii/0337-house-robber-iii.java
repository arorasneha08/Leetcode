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
    private int dfs(TreeNode root , Map<TreeNode , Integer> dp){
        if(root == null) return 0 ; 
        if(dp.containsKey(root)) return dp.get(root); 

        int pick = root.val;
        if(root.left != null){
            pick += dfs(root.left.left , dp) + dfs(root.left.right , dp);
        }
        if(root.right != null){
            pick += dfs(root.right.left , dp)  + dfs(root.right.right , dp); 
        }
        int notpick = dfs(root.left , dp) + dfs(root.right , dp) ; 
        int result = Math.max(pick , notpick); 
        dp.put(root, result); 
        return result; 
    }
    public int rob(TreeNode root) {
        Map<TreeNode , Integer> dp = new HashMap<>(); 
        return dfs(root, dp) ; 
    }
}