class Solution {
    public boolean wordPattern(String pattern, String str) {
         int i = 0;
        Map<String, Character> c = new HashMap<>();
        Map<Character, String> d = new HashMap<>();
        for(String word: str.split(" ")) {
            if(!word.equals("")) {
                if(i >= pattern.length()) return false;
                Character q = pattern.charAt(i);
                if(c.containsKey(word) || d.containsKey(q)) {
                    if(c.get(word) != q || !d.get(q).equals(word)) {
                        return false;
                    }
                } else {
                    c.put(word, q);
                    d.put(q, word);
                }
            }
            i++;
        }
if(i != pattern.length()) return false;
        return true;
    }
}