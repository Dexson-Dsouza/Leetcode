class Solution {
    public int[] amountPainted(int[][] paint) {
        TreeMap<Integer,Integer> paintedMap=new TreeMap<>();
        
        int count=paint.length;
        int[] painted=new int[count];
        for(int index=0;index<count;index++){
            int start=paint[index][0];
            int end=paint[index][1];
            
            if(start>=end){
                continue;
            }
            
            painted[index]= end-start;
            Integer left= paintedMap.floorKey(start);
            
            if(left==null || paintedMap.get(left)<=start){
                left= paintedMap.ceilingKey(start);
            }else{
                
                if(paintedMap.get(left)>=end){
                    painted[index]=0;
                    continue;
                }
                painted[index]-= paintedMap.get(left)-start;
                paintedMap.put(left,start);
                left= paintedMap.ceilingKey(start);
            }
            
            while(left!=null && left<end){
                int right=paintedMap.get(left);
                painted[index]-= Math.min(right,end)-left;
                if(right>end){
                    paintedMap.put(end,right);
                }
                paintedMap.remove(left);
                left=paintedMap.ceilingKey(left);
            }
            paintedMap.put(start,end);
            // System.out.println(paintedMap);
        }
        return painted;
    }
}