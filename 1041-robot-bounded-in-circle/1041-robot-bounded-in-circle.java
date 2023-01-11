class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] dir=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        //right +1
        //left -1
        int dirIndex= 0;
        int x = 0;
        int y = 0;
        
        for(char rule:instructions.toCharArray()){
            switch(rule) {
                case 'G':
                    x += dir[dirIndex][0];
                    y += dir[dirIndex][1];
                    break;
                case 'L':
                    dirIndex--;
                    if(dirIndex==-1){
                        dirIndex=3;
                    }
                    break;
                case 'R':
                    dirIndex++;
                    if(dirIndex==4){
                        dirIndex=0;
                    }
                    break;
                default:
            }
        }
        if(x==0 && y==0){
            return true;
        }
        if(dirIndex!=0){
            return true;
        }
        return false;
    }
}