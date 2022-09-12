class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length;
        if(n == 0) {return 0;}
        
        Arrays.sort(tokens);
        
        int score = 0, start = 0, end = n - 1, max = 0;
        while(power >= 0 && start < n && end >= 0) {
            if(tokens[start] <= power) {
                power -= tokens[start++];
                score++;
                max = Math.max(max, score);
            } else if (score > 0) {
                power += tokens[end--];
                score--;
            } else {
                break;
            }
        }
        
        return max;
    }
}