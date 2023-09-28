class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triples = new ArrayList<>();
        
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length; i++){
            int j=i+1;
            int k=nums.length-1;
            
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                
                if(sum==0){
                    triples.add(new ArrayList<>(Arrays.asList(new Integer[]{nums[i],nums[j],nums[k]})));
                }
                
                
                if(sum<0){
                    j++;
                    while(j<k && nums[j]==nums[j-1]){
                        j++;
                    }
                }else{
                    k--;
                    while(j<k && nums[k]==nums[k+1]){
                        k--;
                    }
                }
            }
            
            while(i<nums.length-1 && nums[i]==nums[i+1]){
                i++;
            }
        }
        return triples;
    }
}