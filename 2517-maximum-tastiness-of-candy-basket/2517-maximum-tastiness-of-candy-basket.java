class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        
        int l = 0;
        int r = price[price.length-1]-price[0];
        
        int maxTasty=0;
        while(l<=r){
            int mid = l + (r-l)/2;
            int candy = price[0];
            int count = k-1;
            int index = 0;
            while(index<price.length && count>0){
                if(price[index]-candy>=mid){
                    candy = price[index];
                    count--;
                }
                index++;
            }
            
            if(count==0){
                maxTasty=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return maxTasty;
    }
}