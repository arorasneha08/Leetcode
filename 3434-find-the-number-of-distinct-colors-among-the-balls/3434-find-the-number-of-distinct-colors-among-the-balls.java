class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length; 
        int res[] = new int[n]; 
        HashMap<Integer , Integer> ballmap = new HashMap<>(); 
        HashMap<Integer , Integer> colormap = new HashMap<>(); 

        for(int i = 0 ; i < n ; i++){
            int ball = queries[i][0] ; 
            int color = queries[i][1]; 

            if(ballmap.containsKey(ball)){
                int prevColor = ballmap.get(ball); 
                colormap.put(prevColor , colormap.get(prevColor) - 1) ; 

                if(colormap.get(prevColor) == 0){
                    colormap.remove(prevColor); 
                }
            }
            ballmap.put(ball, color);
            colormap.put(color , colormap.getOrDefault(color , 0) + 1) ; 

            res[i] = colormap.size() ; 
        }
        return res  ;
    }
}