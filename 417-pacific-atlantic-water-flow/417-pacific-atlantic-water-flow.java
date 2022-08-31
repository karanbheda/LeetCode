class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();

        int m = matrix.length;
        if(m < 1) {
            return result;
        }

        int n = matrix[0].length;
        if(n < 1) {
            return result;
        }

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, n - 1));

        while(!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.remove();
            int x = pair.getKey();
            int y = pair.getValue();

            if(pacific[x][y] && atlantic[x][y]) {
                continue;
            }

            boolean pac = false, atl = false;
            if(x - 1 < 0 || y - 1 < 0) {
                pac = true;
            }

            if(x + 1 >= m || y + 1 >= n) {
                atl = true;
            }

            int[] dir = new int[]{1,-1};
            for(int xDir = 0; xDir < 2; xDir++) {
                for(int yDir = 0; yDir < 2; yDir++) {
                    //right (+1) or left (-1)
                    if(y + dir[xDir] < n && y + dir[xDir] >= 0 && matrix[x][y] >= matrix[x][y + dir[xDir]]) {
                        pac |= pacific[x][y + dir[xDir]];
                        atl |= atlantic[x][y + dir[xDir]];
                    }

                    //top (+1) or bottom (-1)
                    if(x - dir[yDir] < m && x - dir[yDir] >= 0 && matrix[x][y] >= matrix[x - dir[yDir]][y]) {
                        pac |= pacific[x - dir[yDir]][y];
                        atl |= atlantic[x - dir[yDir]][y];
                    }
                }
            }

            if(pac != pacific[x][y] || atl != atlantic[x][y]) {
                if(x - 1 >= 0) {
                    queue.add(new Pair<>(x - 1, y));
                }

                if(x + 1 < m) {
                    queue.add(new Pair<>(x + 1, y));
                }

                if(y - 1 >= 0) {
                    queue.add(new Pair<>(x, y - 1));
                }

                if(y + 1  < n) {
                    queue.add(new Pair<>(x, y + 1));
                }

                pacific[x][y] |= pac;
                atlantic[x][y] |= atl;
            }

        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }
            }
        }

        return result;
    }
}