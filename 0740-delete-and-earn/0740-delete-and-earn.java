class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer,Integer> countMap=new HashMap<>();
        
        for(int n:nums){
            countMap.put(n,countMap.getOrDefault(n,0)+1);
        }
        
        List<Integer> uniquePoints = new ArrayList<>(countMap.keySet());
        Collections.sort(uniquePoints);
        
        TreeMap<Integer,Integer> max_point_map = new TreeMap<>();
        int res = 0;
        for(int n:uniquePoints){
            
            // max without this
            
            Integer prevBestPoint = max_point_map.lowerKey(n);
            Integer prevBestScore = 0;
            if(prevBestPoint!=null){
                prevBestScore=max_point_map.get(prevBestPoint);
            }
            
            // max with this
            
            int curPoints = n * countMap.get(n);
            
            Integer curBestPoint = max_point_map.lowerKey(n-1);
            Integer curBestScore = 0;
            if(curBestPoint!=null){
                curBestScore=max_point_map.get(curBestPoint);
            }
            
            int maxPossible = Math.max(prevBestScore,curBestScore + curPoints);
            max_point_map.put(n,maxPossible);
            res = Math.max(res,maxPossible);
            
        }
        return res;
    }
}