class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length ; 

        int indegree[] = new int[numCourses] ; 
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); 

        for(int i = 0 ; i<numCourses ; i++){
            adj.add(new ArrayList<>()); 
        } 

        for(int i = 0 ; i<n ; i++){
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];
            adj.get(prerequisite).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>(); 
        for(int i = 0 ; i<numCourses ; i++){
            if(indegree[i] == 0){
                q.offer(i) ; 
            }
        }

        ArrayList<Integer> list = new ArrayList<>() ; 
        while(!q.isEmpty()){
            int currNode = q.poll();
            list.add(currNode); 
            for(int adjNode : adj.get(currNode)){
                indegree[adjNode]-- ; 

                if(indegree[adjNode] == 0){
                    q.offer(adjNode); 
                }
            }
        }
        return (list.size() == numCourses); 
    }
}