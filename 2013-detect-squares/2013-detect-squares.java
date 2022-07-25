class DetectSquares {
    Map<Integer,Map<Integer,Integer>> map;
    public DetectSquares() {
        map=new HashMap<>();
    }
    
    public void add(int[] point) {
        if(map.containsKey(point[0])==false){
            map.put(point[0],new HashMap<>());
        }
        Map<Integer,Integer> Ymap=map.get(point[0]);
        Ymap.put(point[1],Ymap.getOrDefault(point[1],0)+1);
    }
    
    public int count(int[] point) {
        if(map.containsKey(point[0])==false){
            return 0;
        }
        int x1=point[0];
        int y1=point[1];
        int count=0;
        
        // System.out.println(x1+" "+y1);
        for(int x2:map.keySet()){
            
            //check for point on same x
            if(x2!=x1  && map.get(x2).containsKey(y1)){
            // System.out.println(" contains x2");
                for(int y2:map.get(x2).keySet()){
                    if(y1!=y2 && map.get(x1).containsKey(y2) && Math.abs(x1-x2)==Math.abs(y1-y2)){
            // System.out.println(" contains y2");
                        count += map.get(x1).get(y2)*map.get(x2).get(y1)*map.get(x2).get(y2); 
                    }
                }
            }
        }
        return count;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */