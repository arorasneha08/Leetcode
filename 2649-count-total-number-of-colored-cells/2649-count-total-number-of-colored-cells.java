class Solution {
    public long coloredCells(int n) {
        long blueCells = 1 ; 
        int add = 4 ;

        while(n > 1){
            blueCells += add ;
            add += 4 ; 
            n--;
        }
        return blueCells ; 
    }
}