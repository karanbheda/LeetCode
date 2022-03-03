class Solution {
    public int numberOfArithmeticSlices(int[] a) {
        if(a.length <= 2)
            return 0;
        int count = 0;
        int d=a[1]-a[0];
        int i=2;
        int s=0;
        while(i<a.length){
            while(i<a.length && a[i]-a[i-1]==d){
                i++;
            }
            
            count+=calc(i-s);
            s=i-1;
            if(a.length>i)
                d=a[i]-a[i-1];
        }
        
        return count;
    }
    
    public int calc(int n){
        if(n <3) return 0;
        
        int i=1;
        int count=0;
        for(int k=n; k >=3;k--){
            count+=i;
            i++;
            
        }
        return count;
    }
}