class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a,b)->b.getValue() - a.getValue());
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            queue.offer(entry);
        }
        
        for(int i = 0; i < k && !queue.isEmpty(); i++) {
            ans[i] = queue.poll().getKey();
        }
        
        return ans;
    }
}