class Solution {
    public boolean canJump(int[] nums) {
        if(nums[0] == 0 && nums.length > 1) {return false;}
        long[] dp = new long[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = 1; j <= nums[i] && i+j < nums.length; j++) {
                dp[i+j] = Math.min(dp[i+j], dp[i] + 1);
            }
        }
        //System.out.print(Arrays.toString(dp));
        return dp[nums.length - 1] < Integer.MAX_VALUE;
    }
}