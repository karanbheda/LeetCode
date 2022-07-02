class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long maxX = horizontalCuts[0], maxY = verticalCuts[0];
    
        
        for(int i = 1; i < horizontalCuts.length; i++) {
            maxX = Math.max(maxX, horizontalCuts[i] - horizontalCuts[i-1]);
            
        }
        
        for(int j = 1; j < verticalCuts.length; j++) {
            maxY = Math.max(maxY, verticalCuts[j] - verticalCuts[j-1]);
        }
        
        maxX = Math.max(h - horizontalCuts[horizontalCuts.length-1], maxX);
        maxY = Math.max(w - verticalCuts[verticalCuts.length-1], maxY);
        
        
        
        return (int)((maxX*maxY)%1000000007);
    }
}