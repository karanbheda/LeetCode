class Solution {
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        boolean flag = false;
        for(int i = n - 2; i >=0 ; i--) {
            if(nums[i] > nums[i+1]) {
                if(flag){return false;}
                flag = true;
                if(nums[i] > nums[i+1] && i + 2 < n && nums[i] <= nums[i+2]) {
                    nums[i+1] = nums[i];
                } else if (nums[i] > nums[i+1] && i+2 >= n) {
                    nums[i+1] = nums[i];
                } else {
                    nums[i] = nums[i+1];
                }
            }
        }
        return true;
    }
}