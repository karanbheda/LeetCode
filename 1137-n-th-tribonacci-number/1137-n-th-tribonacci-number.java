class Solution {
    private static int[] fib = new int[38];
    public int tribonacci(int n) {
        
        if(n > 0 && fib[n] != 0) {return fib[n];}
        
        fib[1] = 1;
        fib[2] = 1;
        
        for(int i = 3; i <= 37; i++) {
            fib[i] = fib[i - 1] + fib[i - 2] + fib[i - 3];
        }
        
        return fib[n];
    }
}