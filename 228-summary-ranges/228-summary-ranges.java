class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if(nums.length == 0)  return result;
        
        int start = nums[0];
        int i = 1;
        for(; i < nums.length; i++) {
            if(nums[i] - nums[i-1] != 1) {
                if(start == nums[i-1]) {
                    result.add(Integer.toString(nums[i-1]));
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(start).append("->").append(nums[i-1]);
                    result.add(sb.toString());
                }
                start = nums[i];
            }
        } 
        
        if(start == nums[i-1]) {
            result.add(Integer.toString(nums[i-1]));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(start).append("->").append(nums[i-1]);
            result.add(sb.toString());
        }
    
        
        return result;
    }
}