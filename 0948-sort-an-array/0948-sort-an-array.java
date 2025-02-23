class Solution {
    public void merge(int arr[] , int start , int mid , int end){
        int i = start ;
        int j = mid+1; 
        ArrayList<Integer> temp = new ArrayList<>(); 
        while(i <= mid && j <= end){
            if(arr[i] <= arr[j]){
                temp.add(arr[i]);
                i++;
            }
            if(arr[j] <= arr[i]){
                temp.add(arr[j]);
                j++;
            }
        }
        while(i <= mid){
            temp.add(arr[i]);
            i++ ; 
        }
        while(j <= end){
            temp.add(arr[j]);
            j++; 
        }
        for(int k = 0 ; k < temp.size() ; k++){
            arr[k + start] = temp.get(k); 
        }
    }
    public void mergeSort(int arr[] , int start , int end){
        if(start >= end) return ; 
        int mid = (start + end)/2 ;
        mergeSort(arr , start , mid);
        mergeSort(arr , mid+1 , end);
        merge(arr , start , mid , end); 
    }
    public int[] sortArray(int[] nums) {
        int n = nums.length ; 
        mergeSort(nums , 0 , n-1); 
        return nums; 
    }
}