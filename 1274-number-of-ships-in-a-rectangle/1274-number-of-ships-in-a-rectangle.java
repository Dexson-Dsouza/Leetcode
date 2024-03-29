/**
 * // This is Sea's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Sea {
 *     public boolean hasShips(int[] topRight, int[] bottomLeft);
 * }
 */

class Solution {
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        int x1 = bottomLeft[0];
        int y1 = bottomLeft[1];
        int x2 = topRight[0];
        int y2 = topRight[1];
        
        if(sea.hasShips(topRight,bottomLeft)==false){
            return 0;
        }
        if(x1==x2 && y1==y2){
            return 1;
        }
        
        int midX = (x1+x2)/2;
        int midY = (y1+y2)/2;
        
        int leftBottom = countShips(sea,new int[]{midX,midY},new int[]{x1,y1});
        int rightBottom = countShips(sea,new int[]{x2,midY},new int[]{midX+1,y1});
        int leftTop = countShips(sea,new int[]{midX,y2},new int[]{x1,midY+1});
        int rightTop = countShips(sea,new int[]{x2,y2},new int[]{midX+1,midY+1});
        return leftBottom+rightBottom+leftTop+rightTop;
    }
}