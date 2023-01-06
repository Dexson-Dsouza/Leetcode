class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int index=0;
        while(index<costs.length && costs[index]<=coins){
            coins -= costs[index];
            index++;
        }
        return index;
    }
}