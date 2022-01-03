class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] out = new int[n];
        int[] in = new int[n];
        
        for(int[] t: trust) {
            out[t[0] - 1]++;
            in[t[1] - 1]++;
        }
        
        List<Integer> judges = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(out[i] == 0 && in[i] == n - 1) {
                judges.add(i+1);
            }
        }
        
        if(judges.size() == 1) {
            return judges.get(0);
        }
        
        return -1;
    }
}