class Solution {
    public boolean validUtf8(int[] data) {
        for(int i=0;i<data.length;i++){
            int countOnes=0;
            int pow=7;
            int cur=data[i];
            while(pow>=4 && (cur& (1<<pow))!=0){
                countOnes++;
                pow--;
            }
            if((cur& (1<<pow))!=0){
                return false;
            }
            if(countOnes==1 || countOnes>4 || i + countOnes >data.length){
                return false;
            }
            
            for(int j=i+1;j<i+countOnes;j++){
                int firstBit= (data[j] & (1<<7));
                int secondBit= (data[j] & (1<<6));
                if(firstBit==0 || secondBit!=0){
                    return false;
                }
            }
            
            i+=Math.max(0,countOnes-1);
        }
        return true;
    }
}