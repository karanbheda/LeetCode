class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Queue<int[]> queue = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        queue.add(new int[]{0,0});
        boolean[] visited = new boolean[n];
        int[] minSteps = new int[n];
        Arrays.fill(minSteps, Integer.MAX_VALUE);
        
        Queue<int[]> queue1 = new LinkedList<>();
        queue1.add(new int[]{n-1,0});
        boolean[] visited1 = new boolean[n];
        int[] minSteps1 = new int[n];
        Arrays.fill(minSteps1, Integer.MAX_VALUE);
        
        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i], list);
        }
        
        while(!queue.isEmpty() && !queue1.isEmpty()) {
            int[] move = queue.remove();
            int[] move1 = queue1.remove();
            //System.out.println("Agent 1: current idx = " + move[0] + ", value = " + arr[move[0]] + ", steps = " + move[1] );
            //System.out.println("Agent 2: current idx = " + move1[0] + ", value = " + arr[move1[0]] + ", steps = " + move1[1] );
            
            if(move[0] == n - 1) {
                min = Math.min(min, move[1]);
                //System.out.println("agent1 " + min);
                continue;
            }
            
            if(move1[0] == 0) {
                min = Math.min(min, move1[1]);
                //System.out.println("agent2 " + min);
                continue;
            }
            
            if(visited[move1[0]]) {
                min = Math.min(minSteps[move1[0]] + move1[1], min);
                continue;
            }
            
            if(visited1[move[0]]) {
                min = Math.min(minSteps1[move[0]] + move[1], min);
                continue;
            }
            
            if(move[1] >= min || move1[1] >= min) {
                continue;
            }
            
            traverse(visited, queue, move, map, n, arr, minSteps, set);
            traverse(visited1, queue1, move1, map, n, arr, minSteps1, set1);
        }
        
        return min;
    }
    
    private void traverse(boolean[] visited, Queue<int[]> queue, int[] move, Map<Integer, List<Integer>> map, int n, int[] arr, int[] minSteps, Set<Integer> set) {
        visited[move[0]] = true;
        minSteps[move[0]] = Math.min(move[1], minSteps[move[0]]);
        
        if(move[0] - 1 >= 0 && !visited[move[0] - 1]) {
            queue.add(new int[]{move[0] - 1, move[1] + 1});
        }

        if(move[0] + 1 < n && !visited[move[0] + 1]) {
            queue.add(new int[]{move[0] + 1, move[1] + 1});
        }

        if(!set.contains(arr[move[0]]))
        for(Integer idx: map.get(arr[move[0]])) {
            if(idx != move[0] && !visited[idx]) {
                queue.add(new int[]{idx, move[1] + 1});
            } 
        }
        set.add(arr[move[0]]);
        //map.get(arr[move[0]]).clear();
    }
}