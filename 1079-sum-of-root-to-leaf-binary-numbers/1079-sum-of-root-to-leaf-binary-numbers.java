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
        return root.left == null && root.right == null ; 
    }
    private void dfs(TreeNode root , List<String> res, StringBuilder str){
        if(root == null) return ; 
        str.append(root.val);
        if(isLeaf(root)){
            res.add(str.toString()); 
        }
        else{
            dfs(root.left , res , str);
            dfs(root.right , res , str); 
        }
        str.deleteCharAt(str.length()-1); 
    }
    public int sumRootToLeaf(TreeNode root) {
        if(root == null) return 0 ; 
        List<String> res = new ArrayList<>(); 
        StringBuilder str = new StringBuilder();
        dfs(root , res , str);

        int sum = 0 ; 
        for(String s : res){
            sum += Integer.parseInt(s, 2); 
        }
        return sum ; 
    }
}