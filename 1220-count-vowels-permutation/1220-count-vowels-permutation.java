import java.math.BigInteger;
class Solution {
    public int countVowelPermutation(int n) {
        BigInteger[][] dp = new BigInteger[n][5];
        Arrays.fill(dp[0], BigInteger.ONE);
        //System.out.println(Arrays.toString(dp[0]));
        for(int i = 1; i < n; i++) {
            BigInteger[] temp = new BigInteger[5];
            Arrays.fill(temp, new BigInteger("0"));
            //e after a
            temp[1] = temp[1].add(dp[i-1][0]);
            //a or i after e
            temp[0] = temp[0].add(dp[i-1][1]);
            temp[2] = temp[2].add(dp[i-1][1]);
            //a, e, o, u after i
            temp[0] = temp[0].add(dp[i-1][2]);
            temp[1] = temp[1].add(dp[i-1][2]);
            temp[3] = temp[3].add(dp[i-1][2]);
            temp[4] = temp[4].add(dp[i-1][2]);
            //i or u after o
            temp[2] = temp[2].add(dp[i-1][3]);
            temp[4] = temp[4].add(dp[i-1][3]);
            // a after u
            temp[0] = temp[0].add(dp[i-1][4]);
            //System.out.println(Arrays.toString(temp));
            dp[i] = temp;
        }
        
        BigInteger count = new BigInteger("0");
        BigInteger modVal = new BigInteger("1000000007");
        for(BigInteger i : dp[n-1]) {
            count = count.add(i);
        }
        return count.mod(modVal).intValue();
    }
}