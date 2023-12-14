class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int curMax = 0;
        int addedCoins = 0;
        int index=0;
        while(curMax<target){
            if(index<coins.length && coins[index]<=curMax+1){
                curMax += coins[index];
                index++;
            }else{
                // System.out.println(curMax+1);
                curMax+=curMax+1;
                addedCoins++;
            }
        }
        return addedCoins;
    }
}