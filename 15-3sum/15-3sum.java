class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets=new ArrayList<>();
        Arrays.sort(nums);
        int len=nums.length;
        for(int i=0;i<len;i++){
            
            int j=i+1;
            int k=len-1;
            
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                
                if(sum==0){
                    List<Integer> triplet=new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    triplets.add(triplet);
                }
                
                if(sum<=0){
                    j++;
                    while(j>0 && j<k && nums[j]==nums[j-1]){
                        j++;
                    }
                }else{
                    k--;
                    while(k<nums.length-1 && j<k && nums[k]==nums[k+1]){
                        k--;
                    }
                }
            }
            
            while(i+1<nums.length && nums[i+1]==nums[i]){
                i++;
            }
        }
        return triplets;
    }
}