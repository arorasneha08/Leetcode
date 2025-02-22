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
    private int index;
    public TreeNode buildTree(String s , int depth){
        int n = s.length();
        int dashCount = 0 ; 

        while(index < n && s.charAt(index) == '-'){
            dashCount ++;
            index++;
        }
        if(dashCount != depth){
            index -= dashCount;
            return null; 
        }
        int val = 0;
        while(index < n && Character.isDigit(s.charAt(index))){
            val = val * 10 + (s.charAt(index)-'0'); 
            index++; 
        }
        TreeNode node = new TreeNode(val);
        node.left = buildTree(s, depth+1);
        node.right = buildTree(s, depth+1);

        return node; 
    }
    public TreeNode recoverFromPreorder(String traversal) {
        index = 0 ;
        return buildTree(traversal  , 0);
    }
}