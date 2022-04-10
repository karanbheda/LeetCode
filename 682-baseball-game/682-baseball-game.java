class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for(String s: ops){
            if(s.equals("+")) {
                int top = stack.pop();
                int sum = top + stack.peek();
                stack.add(top);
                stack.add(sum);
            } else if(s.equals("C")) {
                stack.pop();
            } else if(s.equals("D")) {
                stack.add(stack.peek()*2);
            } else {
                stack.add(Integer.parseInt(s));
            }
        }
        
        int score = 0;
        while(!stack.isEmpty()) {
            score += stack.pop();
        }
        return score;
    }
}