class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] buy = new int[n+1];
        int[] sell = new int[n+1];
        buy[0] = -prices[0];
        
        for(int i=1;i<=n;i++){
            int price = prices[i-1];
            sell[i] = Math.max(sell[i-1],buy[i-1]+price);
            buy[i] = Math.max(buy[i-1], (i>1?sell[i-2]:0) - price);
            // System.out.println(buy[i]+" "+sell[i]+" "+(i-1));
        }
        return Math.max(sell[n],buy[n]);
    }
}