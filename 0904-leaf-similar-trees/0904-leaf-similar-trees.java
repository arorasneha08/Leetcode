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
    private void dfs(TreeNode root , ArrayList<Integer> res){
        if(root == null) return ; 
        if(isLeaf(root)){
            res.add(root.val);
            return ;
        }
        dfs(root.left, res);
        dfs(root.right , res); 
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList<>(); 
        ArrayList<Integer> list2 = new ArrayList<>(); 

        dfs(root1, list1);
        dfs(root2, list2);
        if(list1.size() != list2.size()) return false; 
        int n = list1.size() ;
        int m = list2.size(); 

        int i = 0 ;
        int j = 0 ; 
        while(i < n && j < m){
            if (!list1.get(i).equals(list2.get(j))) return false; 
            i++;
            j++; 
        }
        return true; 
    }
}