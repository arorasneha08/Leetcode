import java.util.*;

class NumberContainers {
    private HashMap<Integer, Integer> indexMap; 
    private HashMap<Integer, PriorityQueue<Integer>> numberMap; 

    public NumberContainers() {
        indexMap = new HashMap<>(); 
        numberMap = new HashMap<>(); 
    }
    
    public void change(int index, int number) {
        if (indexMap.containsKey(index)) {
            int prevNum = indexMap.get(index); 
            if (prevNum != number) {
                numberMap.get(prevNum).remove(index); 
            }
        }

        indexMap.put(index, number); 
        
        if (!numberMap.containsKey(number)) {
            numberMap.put(number, new PriorityQueue<>()); 
        }
        numberMap.get(number).offer(index); 
    }
    
    public int find(int number) {
        if (!numberMap.containsKey(number) || numberMap.get(number).isEmpty()) {
            return -1; 
        }

        PriorityQueue<Integer> pq = numberMap.get(number);

        // Remove stale indices
        while (!pq.isEmpty() && indexMap.get(pq.peek()) != number) {
            pq.poll(); 
        }

        return pq.isEmpty() ? -1 : pq.peek();
    }
}
