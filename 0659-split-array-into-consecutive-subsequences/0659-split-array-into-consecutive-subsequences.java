class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer,PriorityQueue<Integer>> sequenceLengthMap=new HashMap<>();
        
        for(int n:nums){
            // System.out.println(n + " " + sequenceLengthMap.keySet());
            int nextLen = 1;
            if(sequenceLengthMap.containsKey(n) ){
                int prevLen = sequenceLengthMap.get(n).poll();
                if(sequenceLengthMap.get(n).size()==0){
                    sequenceLengthMap.remove(n);
                }
                nextLen = prevLen + 1;
            }
            int nextNum = n+1;
            if(sequenceLengthMap.containsKey(nextNum)==false){
                sequenceLengthMap.put(nextNum,new PriorityQueue<>());
            }
            sequenceLengthMap.get(nextNum).add(nextLen);
        }
        
        for(int key : sequenceLengthMap.keySet()){
            if(sequenceLengthMap.get(key).peek()<3){
                return false;
            }
        }
        return true;
    }
}