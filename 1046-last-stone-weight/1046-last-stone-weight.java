class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        
        for(int stone: stones) {
            queue.offer(stone);
        }
        
        while(queue.size() > 1) {
            int y = queue.poll();
            int x = queue.poll();
            
            int z = y - x;
            if(z > 0) {
                queue.offer(z);
            }
        }
        
        if(queue.isEmpty())return 0;
        return queue.peek();
    }
}