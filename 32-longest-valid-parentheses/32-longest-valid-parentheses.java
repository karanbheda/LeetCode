class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        boolean[] valid = new boolean[n];
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else if(!stack.isEmpty()) {
                valid[stack.pop()] = true;
                valid[i] = true;
            }
        }
        
        int max = 0, current = 0;
        for(boolean x: valid) {
            if(x) {current++;}
            else {
                max = Math.max(max, current);
                current = 0;
            }
        }
        
        return Math.max(current, max);
    }
}