class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int[] output = new int[prices.length];
        for(int i = prices.length - 1; i >= 0; i--) {
            output[i] = prices[i];
            
            while(!stack.isEmpty() && prices[i] < stack.peek()) {
                stack.pop();
            }
            
            output[i] -= stack.peek();
            stack.push(prices[i]);
            
        }
        
        return output;
    }
}