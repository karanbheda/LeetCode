class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n2 = changed.length;
        
        if(n2%2 == 1) {return new int[0];}
        int n = n2/2;
        
        int[] ans = new int[n];
        int[] count = new int[100001];
        for(int i: changed) {
            count[i]++;
        }
        
        Arrays.sort(changed);
        int index = -1;
        for(int i: changed) {
            if(count[i] == 0) {continue;}
            
            if(2*i < count.length && count[2*i] > 0) {
                count[2*i]--;
                count[i]--;
                ans[++index] = i;
            } else {
                return new int[0];
            }
        }
        
        return ans;
    }
}