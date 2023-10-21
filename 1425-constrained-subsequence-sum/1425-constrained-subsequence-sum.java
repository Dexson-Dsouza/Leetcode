class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        
        int max = Integer.MIN_VALUE;
        
        for(int n:nums){
            max=Math.max(n,max);
        }
        
        for(int i=0;i<nums.length;i++){
            while(pq.size()>0 && (i-pq.peek()[1])>k){
                pq.poll();
            }
            int curMax = nums[i];
            if(pq.size()>0){
                curMax = nums[i] + pq.peek()[0];
            }
            // System.out.println(curMax);
            if(curMax>0){
                pq.add(new int[]{curMax,i});
            }
            max=Math.max(curMax,max);
        }
        return max;
    }
}