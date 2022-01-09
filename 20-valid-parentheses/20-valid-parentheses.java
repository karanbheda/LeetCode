class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put('(',')');
        brackets.put('{','}');
        brackets.put('[',']');
        for(char c: s.toCharArray()) {
            if(c != '}' && c != ']' && c != ')') {
                stack.push(brackets.get(c));
            } else {
                if(stack.isEmpty()) {
                    return false;
                }

                if(stack.pop() != c) {
                    return false;
                }
            }
        }

        if(stack.isEmpty()) {
            return true;
        }

        return false;
    }
}