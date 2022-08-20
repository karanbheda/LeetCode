class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int count = 0, prev = 0;
        long tank = startFuel;
        
        for(int[] station: stations) {
            int dest = station[0];
            int refuel = station[1];
            
            tank -= dest - prev;
            
            while(!pq.isEmpty() && tank < 0) {
              tank += pq.poll(); 
              count++;
            }
            
            if(tank < 0) return -1;
            
            pq.offer(refuel);
            prev = dest;
        }
        
        tank -= target - prev;
        while(!pq.isEmpty() && tank < 0) {
          tank += pq.poll(); 
          count++;
        }

        if(tank < 0) return -1;
        
        return count;
    }
}