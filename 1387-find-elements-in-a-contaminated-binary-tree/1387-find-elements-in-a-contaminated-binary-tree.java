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
class FindElements {
    HashMap<Integer, Boolean> mpp = new HashMap<>();

    private void recoverTree(TreeNode root){
        if(root == null) return ; 
        if(root.left != null){
            root.left.val = root.val * 2 + 1 ;
            mpp.put(root.left.val ,true); 
            recoverTree(root.left); 
        }
        if(root.right != null){
            root.right.val = root.val * 2 + 2 ;  
            mpp.put(root.right.val ,true); 
            recoverTree(root.right); 
        }
    }

    public FindElements(TreeNode root) {
        root.val = 0 ; 
        mpp.put(root.val , true);
        recoverTree(root); 
    }
    
    public boolean find(int target) {
        return mpp.containsKey(target); 
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */