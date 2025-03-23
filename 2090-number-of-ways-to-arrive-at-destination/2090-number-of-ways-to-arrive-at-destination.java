class Solution {
    public class Pair implements Comparable<Pair> {
        int node;
        long dist;

        Pair(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }

        public int compareTo(Pair other) {
            return Long.compare(this.dist, other.dist);
        }
    }

    public int countPaths(int n, int[][] roads) {
        int mod = (int) 1e9 + 7;
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            adj.get(road[0]).add(new int[]{road[1], road[2]});
            adj.get(road[1]).add(new int[]{road[0], road[2]});
        }

        long[] distance = new long[n];
        Arrays.fill(distance, Long.MAX_VALUE);
        int[] ways = new int[n];

        distance[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            long dist = curr.dist;

            if (dist > distance[node]) continue;

            for (int[] adjNode : adj.get(node)) {
                int newNode = adjNode[0];
                int edgeWeight = adjNode[1];

                if (dist + edgeWeight < distance[newNode]) {
                    distance[newNode] = dist + edgeWeight;
                    ways[newNode] = ways[node]; 
                    pq.offer(new Pair(newNode, distance[newNode]));
                } else if (dist + edgeWeight == distance[newNode]) {
                    ways[newNode] = (ways[newNode] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1] % mod;
    }
}
