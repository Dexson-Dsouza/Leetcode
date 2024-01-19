class Solution {
    public int minAreaRect(int[][] points) {
        Map<Integer,Map<Integer,Integer>> x_map = new HashMap<>();
        
        for(int[] point:points){
            int x=point[0];
            int y=point[1];
            if(!x_map.containsKey(x)){
                x_map.put(x,new HashMap<>());
            }
            Map<Integer,Integer> y_map = x_map.get(x);
            y_map.put(y,y_map.getOrDefault(y,0)+1);
        }
        
        int min_area = Integer.MAX_VALUE;
        
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                if(points[i][0] == points[j][0] || points[i][1] == points[j][1]){
                    continue;
                }
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                
                // check if other 2 corners are available
                
                Map<Integer,Integer> y1_map = x_map.get(x1);
                Map<Integer,Integer> y2_map = x_map.get(x2);
                
                if(y1_map.containsKey(y2) && y2_map.containsKey(y1)){
                    int cur_area = Math.abs(x1-x2)*Math.abs(y1-y2);
                    min_area = Math.min(min_area,cur_area);
                }
                
            }
        }
        return min_area==Integer.MAX_VALUE?0:min_area;
    }
}