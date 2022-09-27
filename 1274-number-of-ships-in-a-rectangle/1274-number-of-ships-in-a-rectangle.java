/**
 * // This is Sea's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Sea {
 *     public boolean hasShips(int[] topRight, int[] bottomLeft);
 * }
 */

class Solution {
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        return divideAndFind(sea,topRight,bottomLeft);
    }
    
    public int divideAndFind(Sea sea, int[] topRight, int[] bottomLeft){
        // System.out.println(bottomLeft[0]+" "+bottomLeft[1] +" "+ topRight[0]+" "+topRight[1] +" "+sea.hasShips(topRight,bottomLeft));
        
        
        if(topRight[0]<bottomLeft[0] || topRight[1]<bottomLeft[1]){
            return 0;
        }
        
        if(sea.hasShips(topRight,bottomLeft)==false){
            return 0;
        }
        
        
        if(bottomLeft[0]==topRight[0] && bottomLeft[1]==topRight[1]){
            return sea.hasShips(topRight,bottomLeft)==true?1:0;
        }
        
        int xMid = (topRight[0] + bottomLeft[0])/2;
        int yMid = (topRight[1] + bottomLeft[1])/2;
        
//         if(xMid==0 && yMid==0){
            
//         }
        
        int[] top1=new int[]{xMid,yMid};
        int[] bot1=bottomLeft.clone();
        int count1 = divideAndFind(sea,top1,bot1);
        
        int[] top2=new int[]{topRight[0],yMid};
        int[] bot2=new int[]{xMid+1,bottomLeft[1]};
        int count2 = divideAndFind(sea,top2,bot2);
        
        int[] top3=new int[]{xMid,topRight[1]};
        int[] bot3=new int[]{bottomLeft[0],yMid+1};
        int count3 = divideAndFind(sea,top3,bot3);
        
        int[] top4=topRight.clone();
        int[] bot4=new int[]{xMid+1,yMid+1};
        int count4 = divideAndFind(sea,top4,bot4);
        
        
        return count1+count2+count3+count4;
    }
}