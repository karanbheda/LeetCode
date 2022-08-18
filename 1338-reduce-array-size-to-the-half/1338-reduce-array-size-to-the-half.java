class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int a: arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            pq.add(entry);
        }
        
        int count = 0, size = 0, expected = (arr.length+1)/2;
        while(size < expected) {
            size += pq.poll().getValue();
            count++;
        }
        
        return count;
    }
}