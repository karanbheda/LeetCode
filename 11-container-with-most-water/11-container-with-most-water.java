class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int n = height.length;
        int r = n - 1, l = 0;
        while(l < r) {
            max = Math.max(max, (r-l)*Math.min(height[l], height[r]));
            
            if(height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}