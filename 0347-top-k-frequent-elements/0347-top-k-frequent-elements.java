class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> count= new HashMap<>();
        
        for(int i: nums)
            count.put(i,count.getOrDefault(i,0)+1);
        
        PriorityQueue<Map.Entry<Integer, Integer>> minheap = 
                         new PriorityQueue<>((a,b)->(a.getValue()-b.getValue()));
        
        for(Map.Entry<Integer,Integer> entry: count.entrySet()){
            minheap.add(entry);
            while(minheap.size()>k){
                minheap.poll();
            }
        }

        int[]res=new int[k];
        
        for(int i=0;i<k;i++){
            Map.Entry<Integer,Integer> entry=minheap.poll();
            res[i]=entry.getKey();
        }
        
        return res;
    }
}