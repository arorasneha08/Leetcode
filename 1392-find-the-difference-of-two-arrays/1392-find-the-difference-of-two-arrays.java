class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashMap<Integer , Integer> mpp1 = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>(); 
        int n1 = nums1.length ; 
        int n2 = nums2.length ; 
        for(int i = 0 ; i < n2 ; i++){
            mpp1.put(nums2[i] , mpp1.getOrDefault(nums2[i] , 0) + 1); 
        }
        Set<Integer> list = new HashSet<>() ; 
        for(int i = 0 ; i < n1 ; i++){
            if(!mpp1.containsKey(nums1[i])){
                list.add(nums1[i]); 
            }
        }
        res.add(new ArrayList<>(list)); 
        HashMap<Integer , Integer> mpp2 = new HashMap<>();
        for(int i = 0 ; i < n1 ; i++){
            mpp2.put(nums1[i] , mpp2.getOrDefault(nums1[i] , 0) + 1); 
        }
        Set<Integer> list2 = new HashSet<>() ; 
        for(int i = 0 ; i < n2 ; i++){
            if(!mpp2.containsKey(nums2[i])){
                list2.add(nums2[i]); 
            }
        }
        res.add(new ArrayList<>(list2)); 
        return res ; 
    }
}