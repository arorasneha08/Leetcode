class Solution {
    private int mergeSort(int arr[] , int low , int high){
        int count = 0 ; 
        if(low >= high) return count; 
        int mid = low + (high - low)/2 ;  
        count += mergeSort(arr , low , mid) ;
        count += mergeSort(arr , mid+1 , high);
        count += countPairs(arr , low , mid , high); 
        merge(arr, low , mid , high) ; 
        return count; 
    }   
    private void merge(int arr[] , int low , int mid , int high){
        int left = low ; 
        int right = mid + 1 ; 
        ArrayList<Integer> temp = new ArrayList<>();

        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]); 
                left ++ ; 
            }
            else {
                temp.add(arr[right]); 
                right ++ ; 
            }
        }
        while(left <= mid){
            temp.add(arr[left]);
            left++ ; 
        }
        while(right <= high){
            temp.add(arr[right]); 
            right ++ ; 
        }
        for(int i = 0  ; i < temp.size() ; i++){
            arr[i + low] = temp.get(i); 
        }
    }
    private int countPairs(int arr[] , int low , int mid , int high){
        int count = 0 ; 
        int right = mid +1 ; 

        for(int i = low ; i <= mid ; i++){
            while(right <= high && arr[i] > 2L * arr[right]){
                right ++ ; 
            }
            count += (right - ( mid + 1 )); 
        }
        return count; 
    }
    public int reversePairs(int[] nums) {
        int n = nums.length ; 
        return mergeSort(nums , 0 , n-1) ; 
    }
}