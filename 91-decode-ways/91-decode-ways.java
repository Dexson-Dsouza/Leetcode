class Solution {
    public int numDecodings(String s) {
        Integer[] waysToDecode=new Integer[s.length()+1];
        
        return countWays(0,s,waysToDecode);
    }
    
    public int countWays(int index, String s, Integer[] waysToDecode){
        
        if(index>=s.length()){
            return 1;
        }
        
        if(s.charAt(index)=='0'){
            return 0;
        }
        if(waysToDecode[index]!=null){
            return waysToDecode[index];
        }
        
        int countOfWays=countWays(index+1,s,waysToDecode);
        
        int twoDigitsNum = index+2<=s.length()? Integer.parseInt(s.substring(index,index+2)):27;
        if(twoDigitsNum<=26){
            countOfWays+=countWays(index+2,s,waysToDecode);
        }
        return waysToDecode[index]=countOfWays;
    }
}