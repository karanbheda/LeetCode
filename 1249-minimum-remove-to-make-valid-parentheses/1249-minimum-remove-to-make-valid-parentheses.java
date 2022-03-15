class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int offset = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isAlphabetic(c)) {
                sb.append(c);
            } else if(c == '(') {
                stack.push(i);
            } else if(c == ')') {
                if(stack.isEmpty()) {
                    offset++;
                    continue;
                }
                //System.out.println(stack.peek() + " " + offset);
                sb.insert(stack.pop() - offset - stack.size(), '(');
                sb.append(')');
            }
        }
        
        return sb.toString();
    }
}