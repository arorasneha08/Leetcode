import java.util.*;

class Solution {
    public int minDiffInBST(TreeNode root) {
        if (root == null) return 0;  

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> values = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            values.add(curr.val);

            if (curr.left != null) queue.offer(curr.left);
            if (curr.right != null) queue.offer(curr.right);
        }

        Collections.sort(values);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < values.size(); i++) {
            minDiff = Math.min(minDiff, values.get(i) - values.get(i - 1));
        }

        return minDiff;
    }
}
