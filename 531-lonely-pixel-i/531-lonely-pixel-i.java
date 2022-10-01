class Solution {
    public int findLonelyPixel(char[][] picture) {
        int rows=picture.length;
        int cols=picture[0].length;
        
        int lonelyCount=0;
        
        for(int i=0;i<rows;i++){
            int count=0;
            int blackCol=0;
            for(int col=0;col<cols;col++){
                if(picture[i][col]=='B'){
                    count++;
                    blackCol=col;
                }
            }
            
            if(count==1){
                for(int row=0;row<rows;row++){
                    if(row!=i && picture[row][blackCol]=='B'){
                        count++;
                    }
                }
                if(count==1){
                    lonelyCount++;   
                }
            }
        }
        
        return lonelyCount;
    }
}