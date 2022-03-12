class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] garden = new int[n+1];
        
        for(int i = 0; i < ranges.length; i++) {
            garden[Math.max(0, i-ranges[i])] = Math.min(n, i+ranges[i]);
        }
        
        int count = 0, maxJump = 0, max = 0;
        
        for(int i = 0; i < n; i++) {
            max = Math.max(max, garden[i]);
            
            if(maxJump <= i) {
                maxJump = max;
                count++;
            }
            if(maxJump <= i) {return -1;}
        }
        
        return count;
    }
}