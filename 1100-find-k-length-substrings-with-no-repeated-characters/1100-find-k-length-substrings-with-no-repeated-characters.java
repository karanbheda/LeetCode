class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        int[] count = new int[26];
        Arrays.fill(count, -1);
        int total = 0;
        if(k > 26) {
            return total;
        }
        
        int left = 0, right = 0;
        while(right < s.length()) {
            char c = s.charAt(right);
            if(count[c-'a'] != -1) {
                for(int i = left; i < count[c-'a']; i++) {
                    count[s.charAt(i) - 'a'] = -1;
                }
                left = count[c-'a'] + 1;
            }
            
            count[c - 'a'] = right;
            
            if(right - left + 1 == k) {
                total++;
                count[s.charAt(left++) - 'a'] = -1;
            }
            
            right++;
        }
        
        return total;
    }
}