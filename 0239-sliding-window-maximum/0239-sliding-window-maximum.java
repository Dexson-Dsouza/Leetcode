class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Map<Integer,Integer> countMap = new HashMap<>();
        PriorityQueue<Integer> maxWindowQueue = new PriorityQueue<>((a,b)->Integer.compare(b, a));
        
        // fill queue with first window

        for(int index=0;index<k-1;index++){
          int num=nums[index];
          maxWindowQueue.add(num);
          countMap.put(num,countMap.getOrDefault(num,0)+1);
        }

        int[] maxInWindow = new int[nums.length-k+1];
        int resultIndex = 0;
        for(int index=k-1;index<nums.length;index++){
          // pop old window member
          int poppedIndex = index-k;
          if(poppedIndex>=0){
            int poppedNum = nums[poppedIndex];
            countMap.put(poppedNum,countMap.get(poppedNum)-1);
          }
          //add new window member
          int num = nums[index];
          countMap.put(num,countMap.getOrDefault(num,0)+1);
          maxWindowQueue.add(num);
          // removed old element from queue
          while(maxWindowQueue.size()>0 && countMap.get(maxWindowQueue.peek())==0){
            maxWindowQueue.poll();
          }
          // System.out.println(maxWindowQueue);
          maxInWindow[resultIndex] = maxWindowQueue.peek();
          resultIndex++;
        }
      return maxInWindow;
    }
}