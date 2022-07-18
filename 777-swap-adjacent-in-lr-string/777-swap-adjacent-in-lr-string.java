class Solution {
    public boolean canTransform(String start, String end) {
        int startIndex=0;
        int endIndex=0;
        int inputLength=start.length();
        
        while(startIndex<inputLength || endIndex<inputLength){
            
            while(startIndex<inputLength && start.charAt(startIndex)=='X'){
                startIndex++;
            }
            while(endIndex<inputLength && end.charAt(endIndex)=='X'){
                endIndex++;
            } 
            if(startIndex==inputLength || endIndex==inputLength){
                break;
            }
            if(start.charAt(startIndex)!=end.charAt(endIndex)){
                return false;
            }   
            if(start.charAt(startIndex)=='L' && startIndex<endIndex){
                return false;
            }
             
            if(start.charAt(startIndex)=='R' && startIndex>endIndex){
                return false;
            }
            startIndex++;
            endIndex++;
        }
        return startIndex==inputLength && endIndex==inputLength;
    }
}