class Solution {
    public String longestPalindrome(String s) {
        int left = 0, right = 0;
        
        for(int i = 0; i < s.length(); i++) {
            int diff = find(s, i, i);
           // System.out.println(diff);
            if(diff > (right - left)) {
                left = i - diff/2;
                right = i + diff/2;
               // System.out.println("first");
                //System.out.println(left + " " + right);
            }
            diff = find(s, i, i + 1);
            //System.out.println(diff);
            if(diff > (right - left)) {
                left = i - diff/2;
                right = i + 1 + diff/2;
              //  System.out.println("2d");
                //System.out.println(left + " " + right);
            }
        }
        
        return s.substring(left, right+1);
    }
    
    private int find(String s, int x, int y) {
        
        while(x >= 0 && y < s.length() && s.charAt(x) == s.charAt(y)) {
            x--;
            y++;
        }
        //System.out.println("p");
      //  System.out.println(x + " " + y);
        return y - x - 2;
    }
}