public class Solution {

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegree = new int[numCourses];

        for (int[] edge : prerequisites) {
            if (adjList.get(edge[0]) == null) {
                adjList.put(edge[0], new ArrayList<>());
            }
            adjList.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        Map<Integer, Set<Integer>> nodePrerequisites = new HashMap<>();

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int adj : adjList.getOrDefault(node, new ArrayList<>())) {
                nodePrerequisites.computeIfAbsent(adj, k -> new HashSet<>()).add(node);

                for (int prereq : nodePrerequisites.getOrDefault(node, new HashSet<>())) {
                    nodePrerequisites.get(adj).add(prereq);
                }

                indegree[adj]--;
                if (indegree[adj] == 0) {
                    q.offer(adj);
                }
            }
        }

        List<Boolean> answer = new ArrayList<>();
        for (int[] query : queries) {
            answer.add(nodePrerequisites.getOrDefault(query[1], new HashSet<>()).contains(query[0]));
        }

        return answer;
    }
}