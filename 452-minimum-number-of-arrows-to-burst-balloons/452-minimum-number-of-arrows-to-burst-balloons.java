class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> {
            if(a[0] == b[0]) {return a[1] - b[1];}
            return a[0] - b[0];
        });
        
        int n = points.length;
        int arrows = n;
        int left = points[0][0], right = points[0][1];
        for(int i = 1; i < n; i++) {
            if(points[i][0] >= left && points[i][0] <= right) {
                left = Math.max(left, points[i][0]);
                right = Math.min(right, points[i][1]);
                arrows--;
            } else {
                left = points[i][0];
                right = points[i][1];
            }
        }
        
        return arrows;
    }
}