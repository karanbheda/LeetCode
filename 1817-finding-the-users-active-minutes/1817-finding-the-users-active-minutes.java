class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] uam = new int[k];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        
        for(int[] log: logs) {
            if(!map.containsKey(log[0])) {
                map.put(log[0], new HashSet<>());
            }
            map.get(log[0]).add(log[1]);
        }
        
        for(Set<Integer> set: map.values()) {
            uam[set.size() - 1]++;
        }
        
        return uam;
    }
}