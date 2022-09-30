class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        Map<Integer,List<Integer>> lineMap=new HashMap<>();
        
        for(int[] building:buildings){
            int from=building[0];
            int to=building[1];
            int height=building[2];
            if(lineMap.containsKey(from)==false){
                lineMap.put(from,new ArrayList<>());
            }
            if(lineMap.containsKey(to)==false){
                lineMap.put(to,new ArrayList<>());
            }
            lineMap.get(from).add(height);
            lineMap.get(to).add(-height);
        }
        
        List<Integer> points=new ArrayList<>(lineMap.keySet());
        
        Collections.sort(points);
        
        PriorityQueue<Integer> highestBuilding=new PriorityQueue<>((a,b)->b-a);
        Map<Integer,Integer> countMap=new HashMap<>();
        int currentHeight=0;
        highestBuilding.add(0);
        countMap.put(0,1);
        
        List<List<Integer>> skyLineList=new ArrayList<>();
        
        for(int point:points){
            for(int height:lineMap.get(point)){
                if(height>0){
                    countMap.put(height,countMap.getOrDefault(height,0)+1);
                    highestBuilding.add(height);
                }else{
                    countMap.put(-height,countMap.getOrDefault(-height,0)-1);
                }
            }
            // System.out.println(countMap+" "+point);
            // System.out.println(highestBuilding);
            while(countMap.get(highestBuilding.peek())==0){
                highestBuilding.poll();
            }
            
            if(highestBuilding.peek()!=currentHeight){
                currentHeight=highestBuilding.peek();
                List<Integer> skyLine=new ArrayList<>();
                skyLine.add(point);
                skyLine.add(currentHeight);
                skyLineList.add(skyLine);
            }
            
        }
        return skyLineList;
    }
}