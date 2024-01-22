class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[0],b[0]));
        int res=1;
        int curEnd=points[0][1];
        for(int i=1;i<points.length;i++){
            int nextStart=points[i][0];
            if(curEnd>=nextStart){
                curEnd = Math.min(curEnd,points[i][1]);
                continue;
            }
            res++;
            curEnd=points[i][1];
        }
        return res;
    }
}


    