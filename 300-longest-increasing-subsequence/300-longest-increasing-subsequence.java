class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> arr=new ArrayList<>();
        
        for(int n:nums){
            int l=0;
            int r=arr.size()-1;
            int i=arr.size();
            while(l<=r){
                int mid = (l+r)/2;
                if(n<=arr.get(mid)){
                    i=mid;
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }
            if(i==arr.size()){
                arr.add(n);
            }else{
                arr.set(i,n);
            }
            // System.out.println(arr);
            
        }
        return arr.size();
    }
}