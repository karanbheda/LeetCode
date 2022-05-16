class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(n == 0) {
            return -1;
        }
        
        if(grid[n - 1][n-1] != 0 || grid[0][0] != 0) {
            return -1 ;
        }

        Queue<Point> queue = new LinkedList<>();
        Point startingPoint = new Point(n - 1, n - 1 , 1);
        queue.add(startingPoint);
        Set<Point> visitedPoints = new HashSet<>();
        int min = Integer.MAX_VALUE;
        //visitedPoints.add(startingPoint);
        while(!queue.isEmpty()) {
            Point point = queue.remove();
            if(point.x == 0 && point.y == 0) {
                min = Math.min(min, point.distanceSoFar);
            } else{
                if(visitedPoints.contains(point)) {
                    continue;
                }
                //left top
                if(point.x - 1 >= 0 && point.y - 1 >= 0 && grid[point.x - 1][point.y - 1] == 0) {
                    queue.add(new Point(point.x - 1, point.y - 1, point.distanceSoFar + 1));
                }

                //left
                if(point.y - 1 >= 0  && grid[point.x][point.y - 1] == 0) {
                    queue.add(new Point(point.x, point.y - 1, point.distanceSoFar + 1));
                }

                //top
                if(point.x - 1 >= 0  && grid[point.x - 1][point.y] == 0) {
                    queue.add(new Point(point.x - 1, point.y, point.distanceSoFar + 1));
                }

                //top right
                if(point.x - 1 >= 0 && point.y + 1 < n && grid[point.x - 1][point.y + 1] == 0) {
                    queue.add(new Point(point.x - 1, point.y + 1, point.distanceSoFar + 1));
                }

                //bottom left
                if(point.x + 1 < n && point.y - 1 >= 0  && grid[point.x + 1][point.y - 1] == 0) {
                    queue.add(new Point(point.x + 1, point.y - 1, point.distanceSoFar + 1));
                }
                
                //bottom
                if(point.x + 1 < n && point.y >= 0  && grid[point.x + 1][point.y] == 0) {
                    queue.add(new Point(point.x + 1, point.y, point.distanceSoFar + 1));
                }
                
                //bottom right
                if(point.x + 1 < n && point.y + 1 < n  && grid[point.x + 1][point.y + 1] == 0) {
                    queue.add(new Point(point.x + 1, point.y + 1, point.distanceSoFar + 1));
                }
                
                //right
                if(point.y + 1 < n  && grid[point.x][point.y + 1] == 0) {
                    queue.add(new Point(point.x, point.y + 1, point.distanceSoFar + 1));
                }

                visitedPoints.add(point);
            }

        }

        return min == Integer.MAX_VALUE?-1: min ;
    }
    
    class Point {
        int x, y, distanceSoFar;

        Point(int x, int y, int distanceSoFar) {
            this.x = x;
            this.y = y;
            this.distanceSoFar = distanceSoFar;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}