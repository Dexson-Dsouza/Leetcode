class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        
        int count = 0;
        int left = 0;
        int right = piles.length-1;
        while(left<right){
            count += piles[right-1];
            left++;
            right-=2;
        }
        
        return count;
    }
}