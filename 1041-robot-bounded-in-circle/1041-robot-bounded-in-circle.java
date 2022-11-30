class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] dir=new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
        
        int startDir = 1;
        int x=0;
        int y=0;
        int curDir = 1;
        for(char ch:instructions.toCharArray()){
            if(ch=='L'){
                curDir--;
                if(curDir==-1){
                    curDir=3;
                }
            }else if(ch=='R'){
                curDir++;
                if(curDir==4){
                    curDir=0;
                }
            }else{
                x += dir[curDir][0];
                y += dir[curDir][1];
            }
        }
        return (curDir!=startDir)||(x==0 && y==0);
    }
}