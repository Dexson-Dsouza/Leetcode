class Solution {
    public boolean canReorderDoubled(int[] arr) {
    
        // Arrays.sort(arr);
        Map<Integer,Integer> count=new HashMap<>();
        for(int n:arr){
            count.put(n,count.getOrDefault(n,0)+1);
        }
        List<Integer> keys=new ArrayList<>(count.keySet());
        Collections.sort(keys);
        for(int key:keys){
            int cur=key;
            int pair=cur*2;
            if(count.containsKey(cur)==false || count.containsKey(pair)==false){
                continue;
            }
            if(count.get(cur)<=0 || count.get(pair)<=0){
                continue;
            }
            int minimumCnt=Math.min(count.get(cur),count.get(pair));
            count.put(cur,count.get(cur)-minimumCnt);
            
            count.put(pair,count.get(pair)-minimumCnt);
        }
        
        for(int key:count.keySet()){
            if(count.get(key)>0){
                return false;
            }
        }
        
        return true;
    }
}