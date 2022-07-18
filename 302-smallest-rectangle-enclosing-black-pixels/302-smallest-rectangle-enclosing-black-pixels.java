class Solution {
    public int minArea(char[][] image, int x, int y) {

        int rows=image.length;
        int cols=image[0].length;
        
        int left=cols;
        int right=-1;
        int top=rows;
        int bot=-1;
                
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(image[row][col]=='1'){
                    top=Math.min(top,row);
                    bot=Math.max(bot,row);
                    left=Math.min(left,col);
                    right=Math.max(right,col);
                }
            }
        }
        
        return (right-left+1)*(bot-top+1);
    }
}