class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q= new PriorityQueue<>((a,b)->(b[1]*b[1]+b[0]*b[0])-(a[1]*a[1]+a[0]*a[0]));
        
        for(int[]point: points){
            q.offer(point);
            if(q.size()>k){
                q.poll();
            }
        }
        int[][] res=new int[k][2];
        while(k>0){
            k--;
            res[k]=q.poll();
            
        }
        return res;
    }
}