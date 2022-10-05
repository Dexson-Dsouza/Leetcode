class Solution {
    public void nextPermutation(int[] nums) {
        int len=nums.length;
        TreeMap<Integer,Integer> count=new TreeMap<>();
        boolean found=false;
        for(int i=len-1;i>=0;i--){
            Integer higherNum= count.higherKey(nums[i]);
            count.put(nums[i],count.getOrDefault(nums[i],0)+1);
            if(higherNum!=null){
                nums[i]=higherNum;
                count.put(higherNum,count.get(higherNum)-1);
                List<Integer> remaining=new ArrayList<>();
                
                
                int j=i+1;
                for(int n:count.keySet()){
                    int countNum=count.get(n);
                    while(countNum>0){
                        countNum--;
                        nums[j++]=n;
                    }
                }
                // Collections.sort(remaining);
                found=true;
                break;
            }
            
        }
        
        if(found==false){
            Arrays.sort(nums);
        }
    }
}