class Solution {
    public int minArea(char[][] image, int x, int y) {
        int rows=image.length;
        int cols=image[0].length;
        
        int left=0;
        int right=y;
        int leftMostValid=y;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(checkColContains(image,mid)==true){
                right=mid-1;
                leftMostValid=mid;
            }else{
                left=mid+1;
            }
        }
        
        left=y;
        right=cols-1;
        int rightMostValid=y;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(checkColContains(image,mid)==true){
                left=mid+1;
                rightMostValid=mid;
            }else{
                right=mid-1;
            }
        }
        
        left=0;
        right=x;
        int topMostValid=x;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(checkRowContains(image,mid)==true){
                right=mid-1;
                topMostValid=mid;
            }else{
                left=mid+1;
            }
        }
        
        left=x;
        right=rows-1;
        int bottomMostValid=x;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(checkRowContains(image,mid)==true){
                
                left=mid+1;
                bottomMostValid=mid;
            }else{
                right=mid-1;
            }
        }
        
        return (rightMostValid-leftMostValid+1)*(bottomMostValid-topMostValid+1);
    }
    
    boolean checkColContains(char[][] image, int col){
        for(int row=0;row<image.length;row++){
            if(image[row][col]=='1'){
                return true;
            }
        }
        return false;
    }
    boolean checkRowContains(char[][] image, int row){
        for(int col=0;col<image[0].length;col++){
            if(image[row][col]=='1'){
                return true;
            }
        }
        return false;
    }
}