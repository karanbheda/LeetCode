class Solution {
    public int findPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        Set<String> a = new HashSet<>();
        
        for(int num: nums) {
            if(set.contains(-k+num)) {
                a.add(Math.min(-k+num, num) + "_" + Math.max(-k+num, num));
            }
            
            if(set.contains(k+num)) {
                a.add(Math.min(k+num, num) + "_" + Math.max(k+num, num));
            }
            
            set.add(num);
        }
        
        return a.size();
    }
}