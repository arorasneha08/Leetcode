import java.util.*;

class Solution {
    class Pair {
        int node, stops, cost;

        Pair(int node, int stops, int cost) {
            this.node = node;
            this.stops = stops;
            this.cost = cost;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(src, 0, 0));

        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int node = curr.node;
            int stops = curr.stops;
            int cost = curr.cost;

            if (stops > k) continue;

            for (int[] neighbor : adj.get(node)) {
                int nextNode = neighbor[0];
                int price = neighbor[1];

                if (cost + price < minCost[nextNode]) {
                    minCost[nextNode] = cost + price;
                    q.offer(new Pair(nextNode, stops + 1, minCost[nextNode]));
                }
            }
        }

        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}
