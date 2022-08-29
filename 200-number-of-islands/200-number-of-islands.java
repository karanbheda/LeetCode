class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] isVisited = new boolean[m][n];

        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && !isVisited[i][j]) {
                    spanIsland(grid, i, j, m, n, isVisited);
                    count++;
                }
            }
        }

        return count;
    }

    private void spanIsland(char[][] grid, int i, int j, int m, int n, boolean[][] isVisited) {
        Queue<Pair<Integer, Integer>> islandQueue = new LinkedList<>();
        islandQueue.add(new Pair<>(i,j));
        while(!islandQueue.isEmpty()) {
            Pair<Integer, Integer> cell = islandQueue.poll();
            int x = cell.getKey();
            int y = cell.getValue();

            if(isVisited[x][y]) {
                continue;
            }

            isVisited[x][y] = true;

            //top
            if(x - 1 >= 0 && grid[x-1][y] == '1' && !isVisited[x-1][y]) {
                islandQueue.add(new Pair<>(x - 1, y));
            }
            //bottom
            if(x + 1 < m && grid[x+1][y] == '1' && !isVisited[x+1][y]) {
                islandQueue.add(new Pair<>(x + 1, y));
            }
            //left
            if(y - 1 >= 0 && grid[x][y-1] == '1' && !isVisited[x][y-1]) {
                islandQueue.add(new Pair<>(x, y-1));
            }
            //right
            if(y + 1 < n && grid[x][y+1] == '1' && !isVisited[x][y+1]) {
                islandQueue.add(new Pair<>(x, y + 1));
            }

        }
    }
}