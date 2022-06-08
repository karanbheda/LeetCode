class Solution {
    public int removePalindromeSub(String s) {
        for(int left = 0, right = s.length()-1; left <= right;) {
            if(s.charAt(left++) != s.charAt(right--)) {return 2;}
        }

        return s.length() == 0?0:1;
    }

}