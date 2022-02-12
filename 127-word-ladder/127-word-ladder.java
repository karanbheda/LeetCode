class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.length() != endWord.length()) {
            return 0;
        }
        
        int m = beginWord.length();
        Set<String> set = new HashSet<>(wordList);
        
        if(!set.contains(endWord)) {return 0;}
        
        Map<String, Set<String>> patternToWord = new HashMap<>();
        Map<String, List<String>> wordToPattern = new HashMap<>();
        
        if(!set.contains(beginWord)) {
            set.add(beginWord);
        }
        
        for(String s: set) {
            List<String> list = wordToPattern.getOrDefault(s, new ArrayList<>());
            for(int i = 0; i < m; i++) {
                String p = String.format("%s_%s", s.substring(0,i), s.substring(i+1));
                list.add(p);
                Set<String> matching = patternToWord.getOrDefault(p, new HashSet<>());
                matching.add(s);
                patternToWord.put(p, matching);
            }
            wordToPattern.put(s, list);
        }
        
        //System.out.println(patternToWord);
        //System.out.println(wordToPattern);
        
        Queue<Pair<String,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));
        Map<String,Boolean> visited = new HashMap<>();
        while(!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.remove();
            String word = pair.getKey();
            Integer depth = pair.getValue();
            
            if(word.equals(endWord)) {
                return depth;
            }
            
            visited.put(word, true);
            
            for(String pattern: wordToPattern.get(word)) {
                for(String matchingWord: patternToWord.get(pattern)) {
                    if(!visited.getOrDefault(matchingWord, false)) {
                        queue.add(new Pair<>(matchingWord, depth+1));
                    }
                }
            }
        }
        
        return 0;
    }
}