import java.util.*;

class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length; 
        List<List<Integer>> adj = new ArrayList<>();
        
        // Initialize adjacency list for the tree
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Build the tree from edges
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Array to store Bob's arrival time at each node
        int bobTime[] = new int[n];
        Arrays.fill(bobTime, Integer.MAX_VALUE);
        
        // Find the path taken by Bob to reach node 0
        findBobPath(adj, bob, 0, -1, 0, bobTime);

        // DFS to calculate the maximum profit Alice can get
        return dfsAlice(adj, 0, -1, 0, 0, bobTime, amount);
    }

    // DFS to find the path Bob takes to reach node 0 and record his arrival time
    private boolean findBobPath(List<List<Integer>> adj, int node, int target, int parent, int time, int bobTime[]) {
        if (node == target) {
            bobTime[node] = time;
            return true;
        }

        for (int neighbor : adj.get(node)) {
            if (neighbor != parent && findBobPath(adj, neighbor, target, node, time + 1, bobTime)) {
                bobTime[node] = time;
                return true;
            }
        }

        return false;
    }

    // DFS for Alice to find the most profitable path
    private int dfsAlice(List<List<Integer>> adj, int node, int parent, int time, int currentIncome, int[] bobTime, int[] amount) {
        if (bobTime[node] > time) {
            currentIncome += amount[node];  // Alice gets full amount
        } else if (bobTime[node] == time) {
            currentIncome += amount[node] / 2;  // Alice and Bob share amount
        }

        int maxProfit = Integer.MIN_VALUE;
        boolean isLeaf = true;

        for (int neighbor : adj.get(node)) {
            if (neighbor != parent) {
                isLeaf = false;
                maxProfit = Math.max(maxProfit, dfsAlice(adj, neighbor, node, time + 1, currentIncome, bobTime, amount));
            }
        }

        return isLeaf ? currentIncome : maxProfit;
    }
}
