class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3) {
            return false;
        }
        
        boolean slopeUp = true;
        int j = -1;
        for(int i = 0; i < arr.length - 1; i++) {
            if(slopeUp) {
                if(arr[i] == arr[i+1]) {
                    return false;
                }
                else if(arr[i] > arr[i+1]) {
                    slopeUp = false;
                    j = i;
                }
            } else {
                if(arr[i] == arr[i+1] || arr[i] < arr[i+1]) {
                    return false;
                }
            }
        }
        
        if(j == -1 || j == 0 || j == arr.length - 1) {
            return false;
        }
        return true;
    }
}