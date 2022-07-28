class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int wordCount=sentence.length;
        
        int[] next=new int[wordCount];
        int[] lines=new int[wordCount];
        
        for(int i=0;i<wordCount;i++){
            int curLineLen=sentence[i].length();
            int curIndex=(i+1)%wordCount;
            
            int countOfLines=0;
            while(curLineLen<=cols){
                if(curIndex==0){
                    countOfLines++;
                }
                curLineLen+= sentence[curIndex].length()+1;
                if(curLineLen>cols){
                    break;
                }
                curIndex = (curIndex+1)%wordCount;
            }
            
            next[i]=curIndex;
            lines[i]=countOfLines;
            // System.out.println(next[i]+" "+lines[i]);
        }
        
        int curIndex=0;
        int fittedCount=0;
        for(int i=0;i<rows;i++){
            fittedCount+=lines[curIndex];
            curIndex=next[curIndex];
        }
        return fittedCount;
    }
}