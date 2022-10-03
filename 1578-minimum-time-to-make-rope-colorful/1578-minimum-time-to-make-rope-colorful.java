class Solution {
    public int minCost(String colors, int[] neededTime) {
        int i=0;
        int j=0;
        int cost=0;
        while(j<colors.length()){
            // System.out.println(i+" "+j);
            while(j<colors.length() && colors.charAt(j)==colors.charAt(i)){
                j++;
            }
            
            if(j-i>1){
                int sum=0;
                int minCost=Integer.MIN_VALUE;
                
                while(i<j){
                    minCost=Math.max(minCost,neededTime[i]);
                    sum+=neededTime[i];
                    i++;
                }
                cost+=sum-minCost;
            }else{
                i=j;
            }
        }
        return cost;
    }
}