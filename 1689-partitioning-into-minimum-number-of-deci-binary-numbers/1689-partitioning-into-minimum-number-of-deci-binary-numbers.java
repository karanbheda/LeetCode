class Solution {
    public int minPartitions(String n) {
        char c = n.charAt(0);
        for(int i=1; i<n.length(); i++){
            if(n.charAt(i) > c){
                c=n.charAt(i);
            }
        }
        
        return c-'0';
    }
}