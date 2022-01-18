class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        //int[] -> 0 val, 1 index in original queue
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i = 0; i < tickets.length; i++) {
            queue.add(new int[]{tickets[i], i});
        }
        
        int time = 0;
        while(true) {
            //removing 1 ticket, pushing element behind
            // doing this till index k has 0 tickets left
            
            int[] element = queue.poll();
            //buy tickets, update ticket count, update time
            if(element[0] > 0) {
                time++;
                element[0]--;  
            }
            
           //if the guy has more tickets to buy, push to end of queue
           if(element[0] > 0) {
                queue.add(element);
            }

            if(element[0] == 0 && element[1] == k) {
                break;
            }
        }
        
        return time;
    }
}