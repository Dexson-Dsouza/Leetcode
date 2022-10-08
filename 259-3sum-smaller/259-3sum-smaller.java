class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int len=nums.length;
        int count=0;
        Arrays.sort(nums);
        System.out.println();
        for(int i=0;i<len;i++){
            int j=i+1;
            int k=len-1;
            
            while(j<k){
                if(nums[i]+nums[j]+nums[k]<target){
                    count+= (k-j);
                    j++;
                }else{
                    k--;
                }
                
            }
        }
        return count;
    }
}