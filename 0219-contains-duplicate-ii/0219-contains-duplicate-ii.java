class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> count=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(i>k){
                int prev=nums[i-k-1];
                count.put(prev,count.get(prev)-1);
                if(count.get(prev)==0){
                    count.remove(prev);
                }
            }
            if(count.containsKey(nums[i])){
                return true;
            }
            count.put(nums[i],count.getOrDefault(nums[i],0)+1);
        }
        return false;
    }
}