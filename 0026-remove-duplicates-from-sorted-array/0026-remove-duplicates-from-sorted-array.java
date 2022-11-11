class Solution {
    public int removeDuplicates(int[] nums) {
        int k=0;
        int index=1;
        while(index<nums.length){
            if(nums[index]!=nums[k]){
                k++;
                nums[k]=nums[index];
            }
            index++;
        }
        return k+1;
    }
}