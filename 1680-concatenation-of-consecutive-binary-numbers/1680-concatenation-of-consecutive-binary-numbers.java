class Solution {
    public int concatenatedBinary(int n) {
        int i = 1;
        long ans = 0;
        int mod = 1_000_000_007;
        while(i <= n) {
            for(int j = 1, pow = 0; j <= 1 << pow && i <= n; j++) {
                //System.out.println("PUSH" + (1<<pow));
                ans = (ans << 1 << pow)%mod;
                //System.out.println(ans);
                ans = (ans + i)%mod;
                //System.out.println(ans);
                i++;
                
                //System.out.println(i + " " + j + " " + pow + " " + ans);
                if(j == 1 << pow) {j = 0; pow++;}
            }
        }
        
        return (int)ans;
    }
}