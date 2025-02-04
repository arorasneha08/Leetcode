class Solution {
    public class Pair implements Comparable<Pair> {
        int node;
        int time;
        Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
        public int compareTo(Pair that) {
            return this.time - that.time;  
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) { 
            adj.add(new ArrayList<>());
        }
        for (int[] t : times) {
            adj.get(t[0]).add(new int[]{t[1], t[2]});
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(k, 0));

        int[] minTime = new int[n + 1];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        minTime[k] = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int time = curr.time;
            int node = curr.node;

            for (int[] adjNode : adj.get(node)) {
                int newNode = adjNode[0];
                int newTime = adjNode[1];

                if (time + newTime < minTime[newNode]) {
                    minTime[newNode] = time + newTime;
                    pq.offer(new Pair(newNode, minTime[newNode]));
                }
            }
        }
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (minTime[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, minTime[i]);
        }

        return maxTime;
    }
}
