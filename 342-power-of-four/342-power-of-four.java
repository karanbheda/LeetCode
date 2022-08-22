class Solution {
    public boolean isPowerOfFour(int num) {
        int rem = 0;
        while(Math.abs(num) > 1 && rem == 0) {
            rem = num%4;
            num /= 4;
        }
        
        return num==1 && rem == 0;
    }
}