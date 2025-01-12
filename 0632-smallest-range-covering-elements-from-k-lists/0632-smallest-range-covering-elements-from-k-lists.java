class Solution {
    public class Node implements Comparable<Node>{
        int data ;
        int row ;
        int col ; 
        Node(int data , int row, int col){
            this.data = data ; 
            this.row = row; 
            this.col = col ;
        }
        public int compareTo(Node that){
            return this.data - that.data ; 
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size() ; 
        int max = Integer.MIN_VALUE ;
        int start = 0 ;
        int end = Integer.MAX_VALUE ;
        PriorityQueue<Node> pq = new PriorityQueue<>() ;

        for(int i = 0 ; i<k ; i++){
            if (nums.get(i).size() == 0) return new int[]{};
            int elem = nums.get(i).get(0);
            pq.offer(new Node(elem , i, 0)); 
            max = Math.max(max, elem); 
        }

        while(!pq.isEmpty()){
            Node temp = pq.poll();
            int min = temp.data;
            if(max - min < end - start){
                start = min ; 
                end = max ; 
            }
            if(temp.col + 1 < nums.get(temp.row).size()){
                int nextElem = nums.get(temp.row).get(temp.col + 1);
                pq.offer(new Node(nextElem, temp.row, temp.col + 1));
                max = Math.max(max, nextElem);
            }
            else{
                break ; 
            }
        }
        return new int[]{start, end}; 
    }
}