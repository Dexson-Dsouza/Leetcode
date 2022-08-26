class Solution {
    public boolean reorderedPowerOf2(int n) {
        String num=String.valueOf(n);
        char[] numArr=num.toCharArray();
        Arrays.sort(numArr);
        num=new String(numArr);
        int cur=1;
        while(true){
            // System.out.println(cur);
            String curString=String.valueOf(cur);
            if(curString.length()==num.length()){
                String temp=curString;
                char[] tempArr=temp.toCharArray();
                Arrays.sort(tempArr);
                temp=new String(tempArr);            
                // System.out.println(temp+" "+num);
                if(temp.equals(num)){
                    return true;
                }
            }
            cur<<=1;
            if(curString.length()>num.length()){
                break;
            }
        }
        
        return false;
    }
}