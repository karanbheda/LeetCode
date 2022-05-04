class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        int count = 0;
        for(Integer key: map.keySet()) {
            if(map.get(key) > 0) {
                int comp = k - key;
                
                if(comp == key) {
                    int t = map.get(key)/2;
                    map.put(key, map.get(key) - 2*t);
                    count += t;
                    continue;
                }
                
                if(map.containsKey(comp) && map.get(comp) > 0) {
                    int t = Math.min(map.get(comp), map.get(key));
                    count += t;
    
                    map.put(comp, map.get(comp) - t);
                    map.put(key, map.get(key) - t);
                }
            }
        }
        
        return count;
    }
}