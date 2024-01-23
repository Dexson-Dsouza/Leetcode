class Solution {
    public int maxProfit(int[] prices) {
        // nothing : remain same
        // buy : total - price
        // sell : total + price and i+1
        
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        
        buy[0] = -prices[0];
        for(int i=1;i<prices.length;i++){
            // buy today
            
            int buying_power = i-2>=0 ? sell[i-2]:0;
            int cost = prices[i];
            
            int buy_today_cost = buying_power - cost;
            buy[i] = Math.max(buy_today_cost,buy[i-1]);
            sell[i] = Math.max(sell[i-1],buy[i-1]+cost);
        }
        
        return sell[prices.length-1];
    }
}