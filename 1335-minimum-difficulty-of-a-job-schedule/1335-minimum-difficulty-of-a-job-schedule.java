class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(d>jobDifficulty.length){
            return -1;
        }
        int maxDiff=Integer.MIN_VALUE;
        for(int n:jobDifficulty){
            maxDiff=Math.max(maxDiff,n);
        }
        if(d==1){
            return maxDiff;
        }
        int len=jobDifficulty.length;
        Integer[][] minDiff=new Integer[len][d+1];
        findDifficulty(0,d,jobDifficulty,minDiff);
        return minDiff[0][d];
    }
    
    int findDifficulty(int curJob, int daysLeft, int[] jobDifficulty, Integer[][] minDiff){
        if(curJob==jobDifficulty.length && daysLeft==0){
            return 0;
        }
        if(curJob==jobDifficulty.length || daysLeft==0){
            return Integer.MAX_VALUE;
        }
        if(minDiff[curJob][daysLeft]!=null){
            return minDiff[curJob][daysLeft];
        }
        int result=Integer.MAX_VALUE;
        int maxDiff=Integer.MIN_VALUE;
        for(int job=curJob;job<jobDifficulty.length;job++){
            maxDiff=Math.max(maxDiff,jobDifficulty[job]);
            int requiredDifficultyToComplete = findDifficulty(job+1,daysLeft-1,jobDifficulty,minDiff);
            if(requiredDifficultyToComplete!=Integer.MAX_VALUE){
                result=Math.min(result,requiredDifficultyToComplete+maxDiff);
            }
        }
        return minDiff[curJob][daysLeft]=result;
    }
}