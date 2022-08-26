class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] digits = new int[10];
        while(n > 0) {
            digits[n%10]++;
            n /= 10;
        }
        
        for(int i = 0; i < 31; i++) {
            int two = 1<<i;
            
            int[] digit = new int[10];
    
            while(two > 0) {
                digit[two%10]++;
                two /= 10;
            }
            
            if(Arrays.equals(digit, digits)) {
                return true;
            }
        }
        
        return false;
    }
}