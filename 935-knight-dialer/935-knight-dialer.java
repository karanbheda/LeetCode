class Solution {
    public int knightDialer(int n) {
        int[][] dp = new int[10][n+1];
        int MOD = 1_000_000_007;
        
        for(int i = 0; i <= 9; i++) {dp[i][0] = 0;dp[i][1] = 1;}
        
        int[][] moves = new int[][]{{4,6}, {6,8}, {7,9}, {4,8}, {0,3,9}, {}, {0,1,7}, {2,6}, {1,3}, {2,4}};
        
        for(int j = 2; j <= n; j++) {
            for(int i = 0; i <= 9; i++) {
                for(int move: moves[i]) {
                    dp[i][j] = (dp[i][j] + dp[move][j-1])%MOD;
                }
            }
        }
        
        int sum = 0;
        for(int j = 0; j <= 9; j++) {
            sum = (sum + dp[j][n])%MOD;
        }
        return sum;
    }
}