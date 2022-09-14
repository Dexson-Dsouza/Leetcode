class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int totalPoints=coordinates.length;
        if(totalPoints==1){
            return true;
        }
        double slope = (double)(Math.abs(coordinates[1][1]-coordinates[0][1]))/Math.abs((coordinates[1][0]-coordinates[0][0]));
        for(int firstPoint=0;firstPoint<totalPoints;firstPoint++){
            for(int secondPoint=firstPoint+1;secondPoint<totalPoints;secondPoint++){
                
                
                double curSlope = (double)(Math.abs((coordinates[firstPoint][1]-coordinates[secondPoint][1])))/Math.abs((coordinates[firstPoint][0]-coordinates[secondPoint][0]));
                if(curSlope!=slope){
                    return false;
                }
            }
        }
        return true;                                                               
    }
}