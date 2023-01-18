class Solution {
    public boolean rotateString(String s, String goal) {
        int len = s.length();
        for(int i=0;i<s.length();i++){
            String rotatedStr = s.substring(i) + s.substring(0,i);
            if(rotatedStr.equals(goal)){
                return true;
            }
        }
        return false;
    }
}