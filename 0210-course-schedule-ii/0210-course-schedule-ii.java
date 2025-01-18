class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length ; 
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>() ; 
        int indegree[] = new int[numCourses] ; 
        
        for(int i = 0 ; i< numCourses ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i<n ; i++){
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            adj.get(prereq).add(course);
            indegree[course]++ ; 
        }

        Queue<Integer> q = new LinkedList<>(); 
        for(int i = 0 ; i<numCourses ; i++){
            if(indegree[i] == 0){
                q.offer(i) ;
            } 
        }
        ArrayList<Integer> ans = new ArrayList<>(); 
        while(!q.isEmpty()){
            int currNode = q.poll();
            ans.add(currNode); 
            for(int adjNode : adj.get(currNode)){
                indegree[adjNode]-- ; 
                if(indegree[adjNode] == 0){
                    q.offer(adjNode); 
                }
            }
        }
        int[] res = new int[ans.size()]; 

        if(ans.size() == numCourses){
            for(int i = 0 ; i<ans.size(); i++){
                res[i] = ans.get(i); 
            }
            return res; 
        }
        return new int[]{}; 
    }
}