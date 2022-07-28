class Solution {
    public int buildWall(int height, int width, int[] bricks) {
        Set<Integer> waysToMakeRow=new HashSet<>();
        findWaysToMakeRow(bricks,0,0,width,waysToMakeRow);
        
        Map<Integer,List<Integer>> nextPossibleWays=new HashMap<>();
        
        for(int mask1:waysToMakeRow){
            nextPossibleWays.put(mask1,new ArrayList<>());
            for(int mask2:waysToMakeRow){
                if((mask1&mask2)==0){
                    nextPossibleWays.get(mask1).add(mask2);
                }
            }
        }
        
        Map<Integer,Map<Integer,Integer>> waysToBuildMap=new HashMap<>();
        int mod=(int)(Math.pow(10,9)+7);
        long count=0;
        for(int mask:waysToMakeRow){
            // System.out.println(mask);
            count = (count + findWays(mask,height-1,nextPossibleWays,waysToBuildMap))%mod;
        }
        return (int)(count);
    }
    
    int findWays(int prevMask, int curHeight, Map<Integer,List<Integer>> nextPossibleWays, 
                 Map<Integer,Map<Integer,Integer>> waysToBuildMap){
        
        // System.out.println(curHeight+" "+prevMask);
        if(curHeight==0){
            return 1;
        }
        
        if(waysToBuildMap.containsKey(prevMask) && waysToBuildMap.get(prevMask).containsKey(curHeight)){
            return waysToBuildMap.get(prevMask).get(curHeight);
        }
        int mod=(int)(Math.pow(10,9)+7);
        long waysToBuild=0;
        
        for(int nextMask:nextPossibleWays.get(prevMask)){
            waysToBuild = (waysToBuild + findWays(nextMask,curHeight-1,nextPossibleWays,waysToBuildMap))%mod;
        }
        if(waysToBuildMap.containsKey(prevMask)==false){
            waysToBuildMap.put(prevMask,new HashMap<>());
        }
        int ways=(int)(waysToBuild);
        waysToBuildMap.get(prevMask).put(curHeight,ways);
        return ways;
    }
    
    void findWaysToMakeRow(int[] bricks, int mask, int curLen, int width, Set<Integer> waysToMakeRow){
        if(width == curLen){
            waysToMakeRow.add(mask);
            return;
        }
        
        if(curLen>0){
            mask|=(1<<curLen);
        }
        
        for(int b:bricks){
            if(curLen+b<=width){
                findWaysToMakeRow(bricks,mask,curLen+b,width,waysToMakeRow);
            }
        }
    }
}