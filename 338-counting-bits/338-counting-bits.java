class Solution {
    public int[] countBits(int num) {
        int[] bit = new int[num + 1];
        
        if(num == 0) {return bit;}
        
        int count = 1;
        for(int i = 1; i <= num; i++) {
            if(i == count) {
                bit[i] = 1;
                count = count<<1;
            } else {
                int prev = count>>1;
                bit[i] = bit[prev] + bit[i - prev] ;
            }
            
        }
        
        return bit;
    }
}