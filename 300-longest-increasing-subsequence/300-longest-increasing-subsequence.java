class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> subseq=new ArrayList<>();
        for(int n:nums){
            
            int index=subseq.size();
            int left=0;
            int right=subseq.size()-1;
            while(left<=right){
                int mid=left+(right-left)/2;
                if(subseq.get(mid)>=n){
                    index=mid;
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
            
            if(index==subseq.size()){
                subseq.add(n);
            }else{
                subseq.set(index,n);
            }
            // System.out.println(subseq+" "+index);
        }
        return subseq.size();
    }
}