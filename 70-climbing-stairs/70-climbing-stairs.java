class Solution {
    private static int[] f = new int[46];
    public int climbStairs(int n) {
        if(f[n] != 0) {return f[n];}
        
        f[1] = 1;
        f[2] = 2;
        
        for(int i = 3; i <= 45; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        
        return f[n];
    }
}