class Solution {
    private boolean checkPrime(int n){
        if(n == 1) return false; 
        for(int i = 2; i * i <= n ; i++){
            if(n % i == 0) return false;
        }
        return true; 
    }
    public int[] closestPrimes(int left, int right) {
        int res[]= new int[2]; 
        ArrayList<Integer> primes = new ArrayList<>(); 
        for(int i = left ;  i<= right ; i++){
            if(checkPrime(i)){
                primes.add(i); 
            }
        }
        if(primes.size() < 2){
            return new int[]{-1 , -1} ;
        }
        int minGap = Integer.MAX_VALUE ; 
        for (int i = 0; i < primes.size() - 1; i++) {
            int diff = primes.get(i + 1) - primes.get(i);
            if (diff < minGap) {
                minGap = diff;
                res[0] = primes.get(i);
                res[1] = primes.get(i + 1);
            }
        }
        return res;
    }
}