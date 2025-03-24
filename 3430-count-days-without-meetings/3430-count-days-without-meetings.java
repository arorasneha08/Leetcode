class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings , (a, b) -> Integer.compare(a[0] , b[0])); 

        List<int[]> merged = new ArrayList<>();

        for (int[] meeting : meetings) {
            if (merged.isEmpty() || meeting[0] > merged.get(merged.size() - 1)[1]) {
                merged.add(new int[]{meeting[0], meeting[1]});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], meeting[1]);
            }
        }

        int prev = 1 ; 
        int freeday = 0 ; 

        for(int meet[] : merged){
            int start = meet[0];
            int end = meet[1]; 
            if(start > prev){
                freeday += (start - prev); 
            }
            prev = end + 1 ; 
        }
        if(prev <= days){
            freeday += (days - prev + 1) ;
        }
        return freeday; 
    }
}