class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxSpeed=Integer.MIN_VALUE;
        
        for(int n:piles){
            maxSpeed=Math.max(maxSpeed,n);
        }
        int left=1;
        int right=maxSpeed;
        
        int bestSpeed=-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            long hoursNeeded=0;
            
            for(int n:piles){
                hoursNeeded += n/mid;
                if(n%mid!=0){
                    hoursNeeded++;
                }
            }
            
            if(hoursNeeded<=h){
                bestSpeed=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        
        }
        return bestSpeed;
    }
}