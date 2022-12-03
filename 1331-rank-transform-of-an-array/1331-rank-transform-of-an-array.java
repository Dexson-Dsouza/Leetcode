class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer,Integer> rankMap=new HashMap<>();
        int[] nums = arr.clone();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i==0){
                rankMap.put(nums[i],1);
            }else if(nums[i-1]!=nums[i]){
                rankMap.put(nums[i],rankMap.get(nums[i-1]) + 1);
            }
        }
        
        int[] rankArr=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            
            rankArr[i] = rankMap.get(arr[i]);
            if(rankArr[i]<1){
                System.out.println(rankArr[i]);
            }
        }
        return rankArr;
    }
}