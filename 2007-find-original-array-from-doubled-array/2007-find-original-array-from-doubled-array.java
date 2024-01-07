class Solution {
    public int[] findOriginalArray(int[] changed) {
        
        if(changed.length%2 == 1){
            return new int[]{};
        }
        
        Map<Integer,Integer> countMap = new HashMap<>();
        
        for(int n:changed){
            countMap.put(n,countMap.getOrDefault(n,0)+1);
        }
        
        int originalArrLen=changed.length/2;
        
        Arrays.sort(changed);
        List<Integer> resultList = new ArrayList<>();
        for(int n:changed){
            if(countMap.get(n)>0){
                int doubledVal = n*2;
                if((n!=0 && countMap.getOrDefault(doubledVal,0)>0) ||
                   (countMap.getOrDefault(doubledVal,0)>1)){
                    // update count and result
                    resultList.add(n);
                    countMap.put(n,countMap.get(n)-1);
                    countMap.put(doubledVal,countMap.get(doubledVal)-1);
                }
            }
        }
        
        if(changed.length/2 != resultList.size()){
            return new int[]{};
        }
        
        int[] res=new int[resultList.size()];
        for(int i=0;i<resultList.size();i++){
            res[i]=resultList.get(i);
        }
        return res;
        
    }
}