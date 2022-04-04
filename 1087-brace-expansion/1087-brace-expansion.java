class Solution {
    public String[] expand(String s) {
        List<StringBuilder> list = new ArrayList<>();
        
        char[] c = s.toCharArray();
        list.add(new StringBuilder());
        
        for(int i = 0; i < s.length(); i++) {
            if(c[i] >= 'a' && c[i] <= 'z') {
                for(StringBuilder sb: list) {
                    sb.append(c[i]);
                }
            } else {
                List<StringBuilder> temp = new ArrayList<>();
                
                while(c[i] != '}') {
                    if(c[i] >= 'a' && c[i] <= 'z') {
                        for(StringBuilder sb: list) {
                            StringBuilder sb1 = new StringBuilder(sb.toString());
                            sb1.append(c[i]);
                            temp.add(sb1);
                        }
                    }
                    i++;
                }
                
                
                list = temp;
            }
        }
        Collections.sort(list);
        String[] ans = new String[list.size()];
        for(int i = 0; i < ans.length; i++) 
            ans[i] = list.get(i).toString();
        return ans;
    }
}