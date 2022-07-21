class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        Deque<Integer> behindCars=new LinkedList<>();
        
        int totalCars=cars.length;
        double[] collisionTime=new double[totalCars];
        
        for(int car=totalCars-1;car>=0;car--){
            int[] currentCar=cars[car];
            int currentSpeed=currentCar[1];
            collisionTime[car]=-1;
            while(behindCars.size()>0){
                int prevCar=behindCars.peekFirst();
                
                double speedDiff = currentSpeed-cars[prevCar][1];
                double distance= cars[prevCar][0]-cars[car][0];
                double speed= currentSpeed-cars[prevCar][1];
                double timeToCollide = distance/speed;
                
                if(speedDiff<=0 ||(timeToCollide>=collisionTime[prevCar] && collisionTime[prevCar]!=-1)){
                    behindCars.pollFirst();
                }else{
                    break;
                }
            }
            
            if(behindCars.size()>0){
                int prevCar=behindCars.peekFirst();
                double distance= cars[prevCar][0]-cars[car][0];
                double speed= currentSpeed-cars[prevCar][1];
                double timeToCollide = distance/speed;
                collisionTime[car] = distance/speed;
            }
            
            behindCars.addFirst(car);
        }
        
        return collisionTime;
        
    }
}