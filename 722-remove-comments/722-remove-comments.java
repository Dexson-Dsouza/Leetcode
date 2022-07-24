class Solution {
    public List<String> removeComments(String[] source) {
        List<String> result= new ArrayList<>();
        
        int i=0;
        int j=0;
        int len=source.length;
        StringBuilder curCode=new StringBuilder();
        while(i<len){
            // System.out.println(i+" "+j+" "+curCode);
            if(j==source[i].length()){
                if(curCode.length()>0){
                    result.add(curCode.toString());
                    curCode=new StringBuilder();
                }
                i++;
                j=0;
            }else if(j+1<source[i].length() && source[i].charAt(j)=='/' && source[i].charAt(j+1)=='/'){
                j=source[i].length();
            }else if(j+1<source[i].length() && source[i].charAt(j)=='/' && source[i].charAt(j+1)=='*'){
                j+=2;
                while(i<len){
                    if(j+1<source[i].length() && source[i].charAt(j)=='*' && source[i].charAt(j+1)=='/'){
                        break;
                    }
                    j++;
                    if(j>=source[i].length()){
                        i++;
                        j=0;
                    }
                    
                }
                j+=2;
            }else{
                curCode.append(source[i].charAt(j));
                j++;
            }
            // System.out.println(i+" "+j+" "+curCode);
        }
        if(curCode.length()>0){
            result.add(curCode.toString());
        }
        return result;
    }
}