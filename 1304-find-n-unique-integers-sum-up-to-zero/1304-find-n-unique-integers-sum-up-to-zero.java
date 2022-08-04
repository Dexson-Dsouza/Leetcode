class Solution {
    public int[] sumZero(int n) {
        int[] nums=new int[n];
        int index=0;
        if(n%2==1){
            index++;
        }
        for(int i=1;i<=n/2;i++){
            nums[index++]=i;
            nums[index++]=-i;
        }
        return nums;
    }
}