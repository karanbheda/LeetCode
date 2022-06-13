class Solution {
    
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        
        for(int row = n - 2; row >= 0; row--) {
            for(int i = 0; i <= row; i++) {
               triangle.get(row).set(i,  triangle.get(row).get(i) + Math.min(triangle.get(row+1).get(i), triangle.get(row+1).get(i+1)));
            }
        }
        
        return triangle.get(0).get(0);
    }

}