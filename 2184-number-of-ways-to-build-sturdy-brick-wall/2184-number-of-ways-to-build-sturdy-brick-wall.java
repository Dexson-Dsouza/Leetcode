class Solution {
    private int mod=(int)(Math.pow(10,9)+7);
    
    public int buildWall(int height, int width, int[] bricks) {
        List<Integer> waysToMakeLays= new ArrayList<>();
        waysToMakeLays(0,width,0,bricks,waysToMakeLays);
        Map<Integer,Map<Integer,Integer>> memo=new HashMap<>();
        return dp(height,waysToMakeLays,memo,0);
    }
    
    int dp(int h, List<Integer> waysToMakeLays, Map<Integer,Map<Integer,Integer>> memo, int prev){
        if(h==0){
            return 1;
        }
        
        if(memo.containsKey(h) && memo.get(h).containsKey(prev)){
            return memo.get(h).get(prev);
        }
        int count = 0;
        
        for(int mask:waysToMakeLays){
            if((mask & prev)==0){
                count = (count + dp(h-1,waysToMakeLays,memo,mask))%mod;
            }
        }
        if(!memo.containsKey(h)){
            memo.put(h,new HashMap<>());
        }
        memo.get(h).put(prev,count);
        return count;
        
    }
    
    
    public void waysToMakeLays(int curwidth, int width, int mask, int[] bricks, List<Integer> waysToMakeLays){
        if(curwidth==width){
            waysToMakeLays.add(mask);
            return;
        }
        if(curwidth>0){
            mask += 1<<curwidth;
        }
        for(int n:bricks){
            if(n+curwidth<=width){
                waysToMakeLays(curwidth+n,width,mask,bricks,waysToMakeLays);
            }
        }
        
    }
}