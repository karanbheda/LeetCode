class Solution {
    private int find(int[] uf, int x) {
        return uf[x] == x? x: find(uf, uf[x]);
    }
    
    public boolean equationsPossible(String[] equations) {
        int[] uf = new int[26];
        
        for(int i = 0; i < 26; i++) {
            uf[i] = i;
        }
        
        for(String eq: equations) {
            if(eq.charAt(1) == '=') {
                uf[find(uf, eq.charAt(0) - 'a')] = find(uf, eq.charAt(3) - 'a');
            }
        }
        
        for(String eq: equations) {
            if(eq.charAt(1) != '=' && find(uf, eq.charAt(0) - 'a') == find(uf, eq.charAt(3) - 'a')) {
                return false;
            }
        }
        
        return true;
    }
}