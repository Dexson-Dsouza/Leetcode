class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> missingRangeList = new ArrayList<>();
        if(nums.length==0){
            if(lower<=upper){
                missingRangeList.add(Arrays.asList(lower,upper));
            }
            return missingRangeList;
        }
        int inputLen = nums.length;
        
        if(lower<nums[0]){
            missingRangeList.add(Arrays.asList(lower,nums[0]-1));
        }
        
        for(int i=0;i<inputLen-1;i++){
            if(nums[i]+1!=nums[i+1]){
                missingRangeList.add(Arrays.asList(nums[i]+1,nums[i+1]-1));
            }
        }
        
        if(nums[inputLen-1]<upper){
            missingRangeList.add(Arrays.asList(nums[inputLen-1]+1,upper));
        }
        return missingRangeList;
    }
}