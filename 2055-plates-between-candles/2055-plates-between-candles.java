class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n =s.length();
        int[] count=new int[n+1];
        TreeSet<Integer> candleIndexes= new TreeSet<>();
        
        for(int i=0;i<n;i++){
            count[i+1]=count[i];
            if(s.charAt(i)=='*'){
                count[i+1]++;
            }else{
                candleIndexes.add(i);
            }
        }
        
        int[] res=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int[] q=queries[i];
            int left = q[0];
            int right = q[1];
            
            Integer leftCandleIndex= candleIndexes.ceiling(left);
            Integer rightCandleIndex= candleIndexes.floor(right);
            // System.out.println(leftCandleIndex+" "+rightCandleIndex);
            if(leftCandleIndex!=null && rightCandleIndex!=null && leftCandleIndex<rightCandleIndex){
                res[i]=count[rightCandleIndex+1]-count[leftCandleIndex+1];
            }
        }
        return res;
    }
}