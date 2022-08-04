class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder str=new StringBuilder();
        
        while(a>0 || b>0){
            if(a>=b){
                if(str.length()>1 && str.charAt(str.length()-1)=='a' &&
                  str.charAt(str.length()-2)=='a' ){
                    if(b==0){
                        break;
                    }
                    b--;
                    str.append('b');
                }
                a--;
                str.append('a');
            }else{
                if(str.length()>1 && str.charAt(str.length()-1)=='b' &&
                  str.charAt(str.length()-2)=='b' ){
                    if(a==0){
                        break;
                    }
                    a--;
                    str.append('a');
                }
                b--;
                str.append('b');
            }
        }
        return str.toString();
    }
}