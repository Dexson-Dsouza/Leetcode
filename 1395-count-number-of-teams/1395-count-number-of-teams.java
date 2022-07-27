class Solution {
    public int numTeams(int[] rating) {
        int len=rating.length;
        int count=0;
        for(int i=1;i<len-1;i++){
            int leftlessCount=0;
            int leftMoreCount=0;
            for(int j=0;j<i;j++){
                if(rating[j]<rating[i]){
                    leftlessCount++;
                }
                if(rating[j]>rating[i]){
                    leftMoreCount++;
                }
            }
            
            int rightlessCount=0;
            int rightMoreCount=0;
            for(int j=i+1;j<len;j++){
                if(rating[j]<rating[i]){
                    rightlessCount++;
                }
                if(rating[j]>rating[i]){
                    rightMoreCount++;
                }
            }
            count += leftlessCount*rightMoreCount + leftMoreCount*rightlessCount;
        }
        return count;
    }
}