class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if(tx < sx || ty < sy){
            return false;
        }
        if(tx==sx && ty==sy){
            return true;
        }
        boolean canReach = false;
        if(tx>ty){
            int nextX = tx%ty;
            if(ty==sy){
                return (tx-sx)%ty == 0;
            }
            canReach = reachingPoints(sx,sy,nextX,ty);
        }else if(tx<ty){
            int nextY = ty%tx;
            if(tx==sx){
                return (ty-sy)%tx == 0;
            }
            canReach = reachingPoints(sx,sy,tx,nextY);
        }
        
        return canReach;
    }
}