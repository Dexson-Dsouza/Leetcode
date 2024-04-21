class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<int[]> jobList=new ArrayList<>();
        
        for(int i=0;i<difficulty.length;i++){
            jobList.add(new int[]{difficulty[i],profit[i]});
        }
        
        Collections.sort(jobList,(a,b)->a[0]-b[0]);
        
        int jobIndex=0;
        int maxProfit=0;
        int total=0;
        Arrays.sort(worker);
        for(int w:worker){
            while(jobIndex<jobList.size() && w>=jobList.get(jobIndex)[0]){
                int curProfit=jobList.get(jobIndex)[1];
                maxProfit=Math.max(maxProfit,curProfit);
                jobIndex++;
            }
            total+=maxProfit;
        }
        return total;
    }
}