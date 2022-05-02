class Solution {
    public int[] sortArrayByParity(int[] A) {
        int n = A.length;
        int left = 0, right = n - 1;
        int index = 0;
        
        while(index < right) {
            int temp = left;
            if(A[index] % 2 == 0) {
                while(left < right && A[left] % 2 == 0) {
                    left++;
                }
                
                if(index <= left) {index++; continue;}
                temp = left;
            } else {
                while(left < right && A[right] % 2 == 1) {
                    right--;
                }
                
                if(index >= right) {index++; continue;}
                temp = right;
            }
            
            int a1 = A[temp];
            A[temp] = A[index];
            A[index] = a1;
            index++;
        }
        
        return A;
    }
}