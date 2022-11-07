class Solution {
    public int maximum69Number (int num) {
        String n=String.valueOf(num);
        char[] numArr=n.toCharArray();
        for(int i=0;i<n.length();i++){
            if(numArr[i]=='6'){
                numArr[i]='9';
                break;
            }
        }
        return Integer.parseInt(new String(numArr));
    }
}