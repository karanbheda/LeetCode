class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> list = new ArrayList<>();
        
        for(String s: strings) {
            char[] c = s.toCharArray();
            int shift = c[0] - 'a';
            for(int i = 0; i < c.length; i++) {
                c[i] = (char)('a' - ((int)(c[i] - shift) + 26)%26);
            }
            
            String h = Arrays.toString(c);

            if(!map.containsKey(h)) {map.put(h, new ArrayList<>());}
            map.get(h).add(s);
        }
        
        map.forEach((k,v)->list.add(v));
        return list;
    }
}