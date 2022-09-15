class Solution {
    public int[] findOriginalArray(int[] changed) {
        Map<Integer,Integer> count=new HashMap<>();
        for(int n:changed){
            count.put(n,count.getOrDefault(n,0)+1);
        }
        
        Arrays.sort(changed);
        
        
        int[] originalArr= new int [changed.length/2];
        int index=0;
        
        for(int n:changed){
            if(count.get(n)==0){
                continue;
            }
            int next=2*n;
            if(next==n && count.get(n)<2){
                return new int[0];
            }
            if(count.getOrDefault(next,0)==0){
                return new int[0];
            }
            originalArr[index++]=n;
            count.put(n,count.getOrDefault(n,0)-1);
            count.put(next,count.getOrDefault(next,0)-1);
        }
        
        for(int n:count.keySet()){
            if(count.get(n)!=0){
                return new int[0];
            }
        }
        return originalArr;
    }
}