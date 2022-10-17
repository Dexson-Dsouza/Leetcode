class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> count= new HashMap<>();
        
        for(int i: nums)
            count.put(i,count.getOrDefault(i,0)+1);
        
        PriorityQueue<int[]> minheap = 
                         new PriorityQueue<>((a,b)->(a[1]-b[1]));
        
        for(int num:count.keySet()){
            minheap.add(new int[]{num,count.get(num)});
            while(minheap.size()>k){
                minheap.poll();
            }
        }

        int[]res=new int[k];
        
        for(int i=0;i<k;i++){
            res[i]=minheap.poll()[0];
        }
        
        return res;
    }
}