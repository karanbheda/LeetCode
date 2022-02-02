class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> count = new HashMap<>();
    for (char c : p.toCharArray()) {
      count.put(c, count.getOrDefault(c, 0) + 1);
    }

    Map<Character, Integer> temp = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    char[] c = s.toCharArray();
    int start = -1;
    for (int i = 0; i < s.length(); i++) {
      if (!count.containsKey(c[i])) {
        temp = new HashMap<>();
        start = -1;
      } else {
        if (start == -1) {
          start = i;
        }
        temp.put(c[i], temp.getOrDefault(c[i], 0) + 1);
            if (i - start + 1 == p.length()) {
          if (compare(count, temp)) {
            list.add(start);
            temp.put(c[start], temp.get(c[start]) - 1);
            start++;
          } else {
            temp.put(c[start], temp.get(c[start]) - 1);
            start += 1;
          }
        }
      }
    }

    return list;
    }
    
    private boolean compare(Map<Character, Integer> count, Map<Character, Integer> temp) {
        if(count.size() != temp.size()) {return false;}
        
        for(Character key: count.keySet()) {
            if (!count.get(key).equals(temp.get(key))) {return false;}
        }
        
        return true;
    }
}