class Solution {
    public int minFlipsMonoIncr(String s) {
        int len = s.length();
        
        int[] zerosOnRight = new int[len+2];
        int[] onesOnLeft = new int[len+2];
        
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='1'){
                onesOnLeft[i+1] = 1+onesOnLeft[i];
            }else{
                onesOnLeft[i+1] = onesOnLeft[i];
            }
        }
        
        
        for(int i=len-1;i>=0;i--){
            if(s.charAt(i)=='0'){
                zerosOnRight[i+1] = 1+zerosOnRight[i+2];
            }else{
                zerosOnRight[i+1] = zerosOnRight[i+2];
            }
        }
        
        int minSteps = Integer.MAX_VALUE;
        for(int i=0;i<=len;i++){
            // System.out.println(onesOnLeft[i] + " "+ zerosOnRight[i+1]);
            minSteps = Math.min(minSteps , onesOnLeft[i] + zerosOnRight[i+1]);
        }
        return minSteps;
        
    }
}