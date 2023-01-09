class Solution {
    public int countSubstrings(String s) {
        char[] strArr= s.toCharArray();
        int len = s.length();
        int[] count = new int[1];
        for(int i=0;i<len;i++){
            findPalCount(strArr,i,i,count);
            findPalCount(strArr,i,i+1,count);
        }
        return count[0];
    }
    
    void findPalCount(char[] strArr, int i, int j, int[] count){
        while(i>=0 && j<strArr.length && strArr[i]==strArr[j]){
            count[0]++;
            i--;
            j++;
        }
    }
}