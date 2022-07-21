class Solution {
    int findDistance(int[] point1, int[] point2){
        int x=Math.abs(point1[0]-point2[0]);
        int y=Math.abs(point1[1]-point2[1]);
    return x*x + y*y;
    } 

    public int numberOfBoomerangs(int[][] points) {
    int totalPoints=points.length;

    Map<Integer,Map<Integer,Integer>> distanceCountMap=new HashMap<>();

    for(int point1=0;point1<totalPoints;point1++){
        distanceCountMap.put(point1,new HashMap<>());
        for(int point2=0;point2<totalPoints;point2++){
            if(point1==point2){
                continue;
    }
    int distance=findDistance(points[point1],points[point2]);
    Map<Integer,Integer> distanceCount=distanceCountMap.get(point1);
    distanceCount.put(distance, distanceCount.getOrDefault(distance,0)+1);
    }
    }

    int countOfBoomerangs=0;

    for(int point=0;point<totalPoints;point++){
        Map<Integer,Integer> distanceMap=distanceCountMap.get(point);
        for(int distance:distanceMap.keySet()){
        int count=distanceMap.get(distance);
        countOfBoomerangs += (count-1)*(count);
    }
    }
    return countOfBoomerangs;
    }

}