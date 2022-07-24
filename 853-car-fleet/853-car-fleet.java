class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]> speedPositionPairList=new ArrayList<>();
        
        int totalCars=position.length;
        for(int car=0;car<totalCars;car++){
            int carPos=position[car];
            int carSpeed=speed[car];
            speedPositionPairList.add(new int[]{carPos,carSpeed});
        }
        
        speedPositionPairList.sort((a,b)-> a[0]-b[0]);
        
        int countOfFleets=1;
        int prevSpeed= speedPositionPairList.get(totalCars-1)[1];
        int prevPos=speedPositionPairList.get(totalCars-1)[0];
        for(int car=totalCars-2;car>=0;car--){
            int carSpeed=speedPositionPairList.get(car)[1];
            if(carSpeed>prevSpeed){
                double time = (double)(prevPos-speedPositionPairList.get(car)[0])/(carSpeed-prevSpeed);
                
                double timeToReachTar= (double)(target-prevPos)/prevSpeed;
                
                // System.out.println(timeToReachTar+" " +time+" "+speedPositionPairList.get(car)[0]+" "+speedPositionPairList.get(car)[1]);
                if(time>timeToReachTar){
                    countOfFleets++;
                    prevSpeed=carSpeed;
                    prevPos= speedPositionPairList.get(car)[0];
                }
            }else{
                prevSpeed=carSpeed;
                prevPos= speedPositionPairList.get(car)[0];
                countOfFleets++;
            }
            
        }
        return countOfFleets;
    }
}