class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for(char c: s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        int oddMax = -1, length = 0;
        for(Character c: count.keySet()) {
            if(count.get(c)%2 == 0) {
                length += count.get(c);
            } else {
                if(count.get(c) > oddMax) {
                    length += oddMax - 1;
                    oddMax = count.get(c);
                } else {
                    length += count.get(c) - 1;
                }
            }
        }

        if(oddMax != -1) {
            length += oddMax + 2;
        }

        return length;
    }
}