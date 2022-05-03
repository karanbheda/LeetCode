class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int startIdx = -1, endIdx = -2, maxSoFar = Integer.MIN_VALUE, minSoFar = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            maxSoFar = Math.max(maxSoFar, nums[i]);
            
            if(nums[i] < maxSoFar) {
                endIdx = i;
            }
        }
        
        for(int i = nums.length - 1; i >= 0; i--) {
            minSoFar = Math.min(minSoFar, nums[i]);
            
            if(nums[i] > minSoFar) {
                startIdx = i;
            }
        }
        
        return endIdx - startIdx + 1;
    }
}