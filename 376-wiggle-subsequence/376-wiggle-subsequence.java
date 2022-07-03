class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length < 2) {return nums.length;};
        
        int prevDiff = nums[1] - nums[0];
        int count = 2;
        if(prevDiff == 0) {count = 1;}
        
        for(int i = 2; i < nums.length; i++) {
            int currDiff = nums[i] - nums[i-1];
            if(currDiff != 0 && checkSign(prevDiff,currDiff)) {
                prevDiff = currDiff;
                count++;
            }
        }
        
        return count;
    }
    
    private boolean checkSign(int x, int y) {
        if(x == 0) {return true;}
        
        if(x/Math.abs(x) != y/Math.abs(y)) {return true;}
        
        return false;
    }
}