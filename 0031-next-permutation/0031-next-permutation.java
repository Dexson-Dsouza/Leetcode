class Solution {
    public void nextPermutation(int[] nums) {
        int count[]=new int[101];
        
        int i=nums.length-1;
        while(i>=0){
            int cur=nums[i];
            count[cur]++;
            boolean found=false;
            for(int next=cur+1;next<=100;next++){
                if(count[next]>0){
                    count[next]--;
                    nums[i]=next;
                    found=true;
                    break;
                }
            }
            if(found){
                break;
            }
            i--;
        }
        i++;
        for(int cur=0;cur<=100;cur++){
            while(count[cur]>0){
                count[cur]--;
                nums[i]=cur;
                i++;
            }
        }
        
    }
}