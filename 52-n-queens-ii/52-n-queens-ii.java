class Solution {

    public int totalNQueens(int n) {
        List<List<String>> uniqueSoln = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            board[0][i] = true;
            backtrack(board, 1, n, uniqueSoln);
            board[0][i] = false;
        }
        return uniqueSoln.size();
    }
   
    private void backtrack(boolean[][] board, int row, int n, List<List<String>> soln) {
        if(row >= n){
            interpret(board, n, soln);
            return;
        }
        for(int i = 0; i < n; i++) {
            board[row][i] = true;
            if(isPossible(board, row, i, n)) {
          
                
                 backtrack(board,row+1, n, soln);
            }
            board[row][i] = false;
        }
    }
   
    private boolean isPossible(boolean[][] board, int row, int col, int n) {
        for(int i = 0; i < col; i++) {
           
                if(board[row][i]) {return false;}
           
        }
        
        for(int i = 0; i< row; i++){
            if(board[i][col]) return false;
        }
       
        int i = row - 1, j = col - 1;
        while(i >= 0 && j >= 0) {
            if(board[i--][j--]) {return false;}
        }
       
        i = row - 1;
        j = col + 1;
       
        while(i >= 0 && j < n) {
            if(board[i--][j++]) {return false;}
        }
       
        return true;
    }
   
    private void interpret(boolean[][] board, int n, List<List<String>> soln){
        List<String> s = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++) {
                if(board[i][j]) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            s.add(sb.toString());
        }
       
        soln.add(s);
    }
}