class Solution {
    public long minimumReplacement(int[] nums) {
        long count=0;
        
        int maxElement=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            // System.out.println(nums[i]+" "+maxElement+" "+count);
            if(nums[i]>maxElement){
                int operations = nums[i]/maxElement;
                if(nums[i]%maxElement!=0){
                    operations++;
                    maxElement= nums[i]/operations;
                }
                count+=operations-1;
            }else{
                maxElement=nums[i];
            }
        }
        return count;
    }
}