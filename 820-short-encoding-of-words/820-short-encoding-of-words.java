class Solution {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (a,b) -> b.length() - a.length());
        int[] indices = new int[words.length];

        StringBuilder sb = new StringBuilder();
        String hash="#";
        sb.append(words[0]).append(hash);
        
        for(int index = 1; index < words.length; index++) {
            int idx = sb.indexOf(words[index]+hash);
            if(idx != -1) {continue;}
            indices[index] = sb.length() - 1;
            sb.append(words[index]).append(hash);
        }

        return sb.length();
    }
}