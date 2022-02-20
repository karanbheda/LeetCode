class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int total = 1;
        Arrays.sort(intervals, (a,b) -> {
            int c = a[0] - b[0];
            if(c == 0)
                return b[1] - a[1];
            return c;
        });
        
        int s = intervals[0][0];
        int e = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= s && intervals[i][1] <= e) {
                continue;
            }
            
            s = intervals[i][0];
            e = intervals[i][1];
            total++;
        }
        
        return total;
    }
}