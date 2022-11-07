class Solution {
    public String orderlyQueue(String s, int k) {
        if(k>1){
            char[] arr=s.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }else{
            String res=s;
            for(int i=0;i<s.length();i++){
                String temp=s.substring(i+1)+s.substring(0,i+1);
                if(temp.compareTo(res)<0){
                    res=temp;
                }
            }
            return res;
        }
    }
}