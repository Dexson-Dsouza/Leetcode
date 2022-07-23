class Solution {
    public int compress(char[] chars) {
        int runningIndex=0;
        int resultIndex=0;
        int length=chars.length;
        while(runningIndex<length){
            chars[resultIndex]=chars[runningIndex];
            int count=1;
            runningIndex++;
            while(runningIndex<length && chars[runningIndex]==chars[resultIndex]){
                runningIndex++;
                count++;
            }
            if(count>1){
                String countString=String.valueOf(count);
                for(char c:countString.toCharArray()){
                    resultIndex++;
                    chars[resultIndex]=c;
                }
            }
            resultIndex++;
        }
        return resultIndex;
    }
}