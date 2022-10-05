class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int totalRows=wall.size();
        
        Map<Integer,Integer> spaceCount=new HashMap<>();
        
        for(int i=0;i<totalRows;i++){
            int curWidth=0;
            for(int j=0;j<wall.get(i).size()-1;j++){
                curWidth+=wall.get(i).get(j);
                spaceCount.put(curWidth,spaceCount.getOrDefault(curWidth,0)+1);
            }
        }
        int maxCount=0;
        for(int width:spaceCount.keySet()){
            maxCount=Math.max(maxCount,spaceCount.get(width));
        }
        
        return totalRows-maxCount;
    }
}