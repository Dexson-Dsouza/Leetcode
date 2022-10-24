class Solution {
    public int[] findErrorNums(int[] nums) {
        int len=nums.length;
        Set<Integer> numSet=new HashSet<>();
        for(int i=1;i<=len;i++){
            numSet.add(i);
        }
        int[] res=new int[2];
        int index=0;
        for(int i=0;i<len;i++){
            if(numSet.contains(nums[i])){
                numSet.remove(nums[i]);
            }else{
                res[index++]=nums[i];
            }
        }
        
        
        for(int n:numSet){
            res[index++]=n;
        }
        // Arrays.sort(res);
        return res;
    }
}