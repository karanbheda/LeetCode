class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int ptr1 = 0, ptr2 = 0;
        int n = pushed.length;
        while(ptr1 < n && ptr2 < n) {
            if(stack.isEmpty() || stack.peek() != popped[ptr2]) {
                stack.push(pushed[ptr1++]);
            } else {
                stack.pop();
                ptr2++;
            }
        }
        
        while(ptr2 < n && !stack.isEmpty() && stack.peek() == popped[ptr2]) {
            stack.pop();
            ptr2++;
        }
        
        return ptr1 == n && ptr2 == n;
    }
}