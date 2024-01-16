class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        //https://leetcode.com/problems/circle-and-rectangle-overlapping/discuss/563463/C%2B%2B-with-simple-explanation
        
        x1-=xCenter;
        x2-=xCenter;
        y1-=yCenter;
        y2-=yCenter;
        
        int x_closest;
        if(x1*x2>=0){
            x_closest = Math.min(Math.abs(x1),Math.abs(x2));
        }else{
            x_closest = 0;
        }
        
        int y_closest;
        if(y1*y2>=0){
            y_closest = Math.min(Math.abs(y1),Math.abs(y2));
        }else{
            y_closest = 0;
        }
        
        return (x_closest*x_closest + y_closest*y_closest)<=radius*radius;
    }
}