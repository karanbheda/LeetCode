class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 1; i <= s.length(); i++) {
            count += isPalindrome(s.substring(0,i));
        }

        if(s.length() > 1) {
            count += countSubstrings(s.substring(1));
        }

        return count;
    }

    private int isPalindrome(String substring) {
        for(int l = -1, r = substring.length(); ++l <= --r; ) {
            if(substring.charAt(l) != substring.charAt(r)) {return 0;}
        }
        return 1;
    }
}