class Solution {
    class Node {
        int val;
        List<Node> neighbors;
        List<Integer> weights;
        
        Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
            this.weights = new ArrayList<>();
        }
        
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[1]-b[1]);
        queue.offer(new int[]{k, 0});
        
        int[] time = new int[n+1];
        Arrays.fill(time, Integer.MAX_VALUE);
        
        Node[] nodes = new Node[n + 1];
        for(int[] t: times) {
            if(nodes[t[0]] == null) {
                nodes[t[0]] = new Node(t[0]);
            }
            
            if(nodes[t[1]] == null) {
                nodes[t[1]] = new Node(t[1]);
            }
            
            nodes[t[0]].neighbors.add(nodes[t[1]]);
            nodes[t[0]].weights.add(t[2]);
        }
        
        while(!queue.isEmpty()) {
            int[] ptr = queue.poll();
            Node currNode = nodes[ptr[0]];
            
            if(ptr[1] >= time[ptr[0]]) {
                continue;
            }
            
            time[ptr[0]] = ptr[1];
            
            for(int i = 0; i < currNode.neighbors.size(); i++) {
                queue.offer(new int[]{currNode.neighbors.get(i).val, ptr[1] + currNode.weights.get(i)});
            }
        }
        
        //System.out.println(Arrays.toString(time));
        int max = -1;
        for(int i = 1; i < time.length; i++) {
            if(time[i] == Integer.MAX_VALUE) {
                return -1;
            }
            
            max = Math.max(max, time[i]);
        }
        
        return max;
    }
}