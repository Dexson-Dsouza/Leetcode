class Solution {
    public int shortestSubarray(int[] nums, int k) {
        long[] pre_sum = new long[nums.length+1];
        
        for(int i=0;i<nums.length;i++){
            pre_sum[i+1] = pre_sum[i]+nums[i];
        }
        int min_len = Integer.MAX_VALUE;
        Deque<Integer> queue=new LinkedList<>();
        for(int i=0;i<=nums.length;i++){
            // check sub_arr
            while(queue.size()>0){
                int left_index = queue.peekFirst();
                long left_sum = pre_sum[left_index];
                long right_sum = pre_sum[i];
                long sub_arr_sum = right_sum-left_sum;
                if(sub_arr_sum>=k){
                    min_len = Math.min(min_len, i - left_index);
                    queue.pollFirst();
                }else{
                    break;
                }
            }
            // remove ineffective sums
            while(queue.size()>0){
                int right_index = queue.peekLast();
                long prev_sum = pre_sum[right_index];
                long cur_sum = pre_sum[i];
                if(cur_sum<=prev_sum){
                    queue.pollLast();
                }else{
                    break;
                }
            }
            
            queue.add(i);
        }
        return min_len==Integer.MAX_VALUE?-1:min_len;
    }
}