class Solution {
    public int maxProfit(int[] prices) {
        int minSoFar=prices[0];
        int maxProfit=0;
        
        for(int i=1;i<prices.length;i++){
            int price=prices[i];
            if(price>minSoFar){
                maxProfit=Math.max(maxProfit,price-minSoFar);
            }else{
                minSoFar=Math.min(minSoFar,price); 
            }
        }
        return maxProfit;
    }
}