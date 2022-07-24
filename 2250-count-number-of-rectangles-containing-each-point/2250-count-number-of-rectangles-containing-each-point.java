class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        Map<Integer,List<Integer>> rectangeHeightMap=new HashMap<>();
        
        for(int i=1;i<=100;i++){
            rectangeHeightMap.put(i,new ArrayList<>());
        }
        
        for(int[] rect:rectangles){
            rectangeHeightMap.get(rect[1]).add(rect[0]);
        }
        
        for(int i=1;i<=100;i++){
            Collections.sort(rectangeHeightMap.get(i));
        }
        
        int[] result=new int[points.length];
        
        for(int i=0;i<points.length;i++){
            for(int h=points[i][1];h<=100;h++){
                
                List<Integer> xPoints = rectangeHeightMap.get(h);
                if(xPoints.size()==0){
                    continue;
                }
                
                int left=0;
                int right=xPoints.size()-1;
                int index=xPoints.size();
                while(left<=right){
                    int mid=left+(right-left)/2;
                    if(xPoints.get(mid)<points[i][0]){
                        left=mid+1;
                    }else{
                        right=mid-1;
                        index=mid;
                    }
                }
                // System.out.println(h+" "+i+" "+index+" "+xPoints.get(0));
                result[i] += (xPoints.size()-index);
                
            }
        }
        return result;
    }
}