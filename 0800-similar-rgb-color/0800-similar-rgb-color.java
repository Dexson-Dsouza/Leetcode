class Solution {
    public String similarRGB(String color) {
        String[] colors=new String[]{"00","11","22","33","44","55","66","77",
                                     "88","99","aa","bb","cc","dd","ee","ff"};
        
        String similarRGBgroup="";
        for(int i=1;i<color.length();i+=2){
            String colorGroup= color.substring(i,i+2);
            int curValue = Integer.parseInt(colorGroup,16);
            int minDiff=Integer.MIN_VALUE;    
            String similarColor="";
            
            for(String c:colors){
                int difference = Integer.parseInt(c,16) - curValue;
                difference*=difference;
                difference*=-1;
                // System.out.println(difference+" "+colorGroup+" "+c);
                if(difference>minDiff){
                    minDiff=difference;
                    similarColor=c;
                }
            }
            similarRGBgroup+=similarColor;
        }
        return "#"+similarRGBgroup;
    }
}