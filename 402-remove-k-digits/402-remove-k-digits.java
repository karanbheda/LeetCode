class Solution {
    public String removeKdigits(String num, int k) {
        if(k == num.length()) {return "0";}
        
        LinkedList<Character> list = new LinkedList<>();
        for(char c: num.toCharArray()) {
            list.add(c);
        }
        while(k-- > 0) {
            int index = 0;
            while(index < list.size() && list.get(index) == '0') {
                index++;
            }
            
            while(index < list.size() - 1 && list.get(index) == list.get(index + 1)) {
                index++;
            }
            
            while(index < list.size() - 1 && list.get(index+1) > list.get(index)) {
                index++;
            }
            
            if(index < list.size())
                list.remove(index);
        }
        //System.out.println(list);
        int index = 0;
        while(index < list.size() && list.get(index) == '0') {
            index++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(; index < list.size(); index++) {
            sb.append(list.get(index));
        }
        
        if(sb.length() == 0) {return "0";}
        
        return sb.toString();
    }
}