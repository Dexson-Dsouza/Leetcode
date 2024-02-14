class Solution {
    public int[] rearrangeArray(int[] nums) {
        int size = nums.length;
        int[] res=new int[size];
        int pos_index=0;
        int neg_index=1;
        
        for(int n:nums){
            if(n>0){
                res[pos_index]=n;
                pos_index+=2;
            }else{
                res[neg_index]=n;
                neg_index+=2;
            }
        }
        return res;
    }
}