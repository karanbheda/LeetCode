class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCodes = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> uniqueCombinations = new HashSet<>();

        for(String word: words) {
            StringBuilder sb = new StringBuilder();
            for(char c: word.toCharArray()) {
                sb.append(morseCodes[(int)c-97]);
            }
            uniqueCombinations.add(sb.toString());
        }
        return uniqueCombinations.size();
    }
}