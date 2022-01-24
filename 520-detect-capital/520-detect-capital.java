class Solution {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        for(char c: word.toCharArray()) {
            int d = (int)(c-'A');
            if(d >= 0 && d <= 26) {
                count++;
            }
        }
        
        if(count == 0 || count == word.length()) {return true;}
        
        if(count == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {return true;}
        
        return false;
    }
}