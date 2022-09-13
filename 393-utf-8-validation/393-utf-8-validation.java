class Solution {
    public boolean validUtf8(int[] data) {
        int n = data.length;
        
        for(int i = 0; i < n; i++) {
            int cons1s = getCons1(data[i]);
            if(cons1s > 4 || cons1s == 1) {return false;}
           // System.out.println(cons1s);
            if(cons1s == 0) {continue;}
            
            for(; cons1s > 1; cons1s--) {
                ++i;
                if(i >= n) {return false;}
                int c = getCons1(data[i]);
                //System.out.println(c);
                if(c != 1) {return false;}
            }
        }
        
        return true;
    }
    
    private int getCons1(int n) {
        boolean[] bits = getBits(n);
        for(int i = 0; i < 8; i++) {
            if(!bits[i]) {return i;}
        }
        
        return 8;
    }
    
    private boolean[] getBits(int n) {
        boolean[] bits = new boolean[8];
        int i = 7;
        
        while(n > 0) {
            bits[i] = n%2 == 1;
            n = n >> 1;
            i--;
        }
        
        return bits;
    }
}