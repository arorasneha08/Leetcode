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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>(); 
        if(root == null) return res; 
        Queue<TreeNode> q = new LinkedList<>();
        int val = Integer.MIN_VALUE ; 

        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            int max = Integer.MIN_VALUE ; 
            for(int i = 0 ; i < size ; i++){
                TreeNode curr = q.poll();
                max = Math.max(max , curr.val); 

                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right); 
                }
            }
            res.add(max); 
        }
        return res ; 
    }
}