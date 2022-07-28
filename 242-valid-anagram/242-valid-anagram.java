class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> a = new HashMap<>();
        Map<Character, Integer> b = new HashMap<>();

        for(char c: s.toCharArray()) {
            if(a.containsKey(c)) {
                a.put(c, a.get(c) + 1);
            } else {
                a.put(c, 1);
            }
        }

        for(char c: t.toCharArray()) {
            if(b.containsKey(c)) {
                b.put(c, b.get(c) + 1);
            } else {
                b.put(c, 1);
            }
        }

        if(a.size() != b.size()) {
            return false;
        }

        Set<Character> d = b.keySet();

        for(Character c: a.keySet()) {
            if(!a.get(c).equals(b.get(c))) {
                return false;
            }
            d.remove(c);
        }

        if(d.size() > 0) {
            return false;
        }

        return true;
    }
}