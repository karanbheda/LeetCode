class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) {return 0;}
        
        int buy = Integer.MAX_VALUE;
        int max = 0;
        for(int price: prices) {
            buy = Math.min(price, buy);
            
            max = Math.max(max, price - buy);
        }
        
        return max;
    }
}