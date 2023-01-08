class Solution {
    public int maxPoints(int[][] points) {
        Arrays.sort(points,(a,b)->a[0]-b[0]);
        int len = points.length;
        int maxCount = 0;
        Map<Integer,Integer> xPointCount = new HashMap<>();
        Map<Integer,Integer> yPointCount = new HashMap<>();
        for(int i=0;i<len;i++){
            int x = points[i][0];
            int y = points[i][1];
            xPointCount.put(x,xPointCount.getOrDefault(x,0)+1);
            yPointCount.put(y,yPointCount.getOrDefault(y,0)+1);
            maxCount=Math.max(maxCount,yPointCount.get(y));
            maxCount=Math.max(maxCount,xPointCount.get(x));
            Map<Double,Integer> count=new HashMap<>();
            for(int j=i+1;j<len;j++){
                int yDiff = points[j][1]-points[i][1];
                int xDiff = points[j][0]-points[i][0];
                if(xDiff==0 || yDiff==0){
                    continue;
                }
                double slope = (double)(yDiff)/(xDiff);
                int curCount = 1 + count.getOrDefault(slope,0);
                count.put(slope,curCount);
                maxCount=Math.max(maxCount,curCount+1);
            }
        }
        return maxCount;
    }
}