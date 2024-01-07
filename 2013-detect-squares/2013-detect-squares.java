class DetectSquares {
    Map<Integer,Map<Integer,Integer>> xMap;
    public DetectSquares() {
        xMap = new HashMap<>();
    }
    
    public void add(int[] point) {
        if(!xMap.containsKey(point[0])){
            xMap.put(point[0],new HashMap<>());
        }
        Map<Integer,Integer> yCountMap = xMap.get(point[0]);
        yCountMap.put(point[1],yCountMap.getOrDefault(point[1],0)+1);
    }
    
    public int count(int[] point) {
        int x1=point[0],y1=point[1];
        int count = 0;
        
        if(xMap.containsKey(x1)==false){
            return 0;
        }
        
        Map<Integer,Integer> source_y_count_map = xMap.get(x1);
        
        for(int x2:xMap.keySet()){
            if(x2!=x1 && xMap.get(x2).containsKey(y1)){
                Map<Integer,Integer> target_y_count_map = xMap.get(x2);
                for(int y2:target_y_count_map.keySet()){
                    if(y2!=y1 && source_y_count_map.containsKey(y2)
                       && Math.abs(x1-x2)==Math.abs(y1-y2)){
                        count +=
                            source_y_count_map.get(y2)*xMap.get(x2).get(y1)*xMap.get(x2).get(y2);
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