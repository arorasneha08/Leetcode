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
        return root.left == null && root.right == null; 
    }
    private void dfs(TreeNode root , int sum , int target , List<List<Integer>> res , List<Integer> list){
        if(root == null) return ; 
        sum += root.val ; 
        list.add(root.val);

        if(sum == target && isLeaf(root)){
            res.add(new ArrayList<>(list));
        }
        else{
            dfs(root.left , sum, target , res, list);
            dfs(root.right , sum  , target , res, list); 
        }
        list.remove(list.size()-1); 
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res; 
        List<Integer> list = new ArrayList<>(); 
        dfs(root , 0 , targetSum , res , list);
        return res; 
    }
}