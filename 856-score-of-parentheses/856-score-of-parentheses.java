class Solution {
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        if(S.charAt(idx++) == '(') {
            stack.add(-1);
        } else {
            return 0;
        }

        while(idx < S.length()) {
            if(S.charAt(idx++) == '(') {
                stack.add(-1);
            } else {
                int topElement = stack.pop();
                int currentBracketScore = 0;
                int numberOfPoppedItems = 1;
                while(topElement != -1) {
                    currentBracketScore += topElement;
                    topElement = stack.pop();
                    numberOfPoppedItems++;
                }

                // case ()
                if(numberOfPoppedItems == 1) {
                    stack.push(1);
                } else  { //case (n)
                    stack.push(currentBracketScore*2);
                }
            }
        }

        int score = 0;
        while(!stack.isEmpty()) {
            score += stack.pop();
        }
        return score;
    }
}