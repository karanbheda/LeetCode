class Solution {
    public int firstUniqChar(String s) {
        if(s.length()>0) {
        Set<Character> u = new HashSet<>();
        for(int i = 0; i < s.length() - 1; i++) {
            char a = s.charAt(i);
            if(!u.contains(a) && s.indexOf(a, i+1) == -1) {
                return i;
            }

            u.add(a);
        }

        if(!u.contains(s.charAt(s.length()-1))) {
            return s.length() - 1;
        }}

        return -1;
    }
}