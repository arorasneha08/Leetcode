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
    private Integer prev = null; 
    int maxCount = 0 ;
    int count = 0; 
    private void inorder(TreeNode root , ArrayList<Integer> list){
        if(root == null) return ; 
        inorder(root.left , list);

        if(prev != null && root.val == prev){
            count ++ ; 
        }
        else{
            count = 1 ; 
        }
        if(count > maxCount){
            maxCount = count; 
            list.clear();
            list.add(root.val); 
        }
        else if(count == maxCount){
            list.add(root.val); 
        }
        prev = root.val;
        inorder(root.right , list); 
    }
    public int[] findMode(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>(); 
        inorder(root, list);
        int res[] = new int[list.size()];
        for(int i = 0  ; i < list.size() ; i++){
            res[i] = list.get(i);
        }
        return res; 
    }
}