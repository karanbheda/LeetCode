class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] rowIdx = new int[n];
        int count = 0, prevRowIdx = -1, min = -1;;

        while(count < k) {
            int index = 0;
            while(index < n) {
                if(rowIdx[index] < n) {
                    min = matrix[index][rowIdx[index]];
                    prevRowIdx = index;
                    break;
                }
                index++;
            }

            while(index < n) {
                if(rowIdx[index] < n && matrix[index][rowIdx[index]] < min) {
                    min = matrix[index][rowIdx[index]];
                    prevRowIdx = index;
                    if(rowIdx[index] == rowIdx[n-1]) {
                        break;
                    }
                }
                index++;
            }

            count++;
            rowIdx[prevRowIdx]++;
        }

        return min;
    }
}