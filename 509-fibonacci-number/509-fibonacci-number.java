class Solution {
    private static int[] f = new int[31];
    public int fib(int n) {
        if(f[n] != 0) {return f[n];}
        
        f[1] = 1;
        for(int i = 2; i <= 30; i++) {
            f[i] = f[i- 1] + f[i - 2];
        }
        
        return f[n];
    }
}