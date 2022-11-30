class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> count=new HashMap<>();
        
        for(int n:arr){
            count.put(n,count.getOrDefault(n,0)+1);
        }
        
        Set<Integer> occurences=new HashSet<>();
        for(int n:count.values()){
            if(occurences.contains(n)){
                return false;
            }
            occurences.add(n);
        }
        return true;
    }
}