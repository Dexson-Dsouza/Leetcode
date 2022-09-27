class Solution {
    public String pushDominoes(String dominoes) {
        char[] dominoArr = dominoes.toCharArray();
        int len = dominoArr.length;
        int closestRight[]=new int[len];
        int closestLeft[]=new int[len];
        
        int rightIndex=-1;
        for(int i=0;i<len;i++){
            if(dominoArr[i]=='R'){
                rightIndex=i;
            }else if(dominoArr[i]=='L'){
                rightIndex=-1;
            }else{
                closestRight[i]=rightIndex;   
            }
        }
        int leftIndex=-1;
        for(int i=len-1;i>=0;i--){
            if(dominoArr[i]=='R'){
                leftIndex=-1;
            }else if(dominoArr[i]=='L'){
                leftIndex=i;
            }else{
                closestLeft[i]=leftIndex;
            }
        }
        
        for(int i=0;i<len;i++){
            if(dominoArr[i]=='.'){
                int closestRightIndex = closestRight[i];
                int closestLeftIndex = closestLeft[i];
                
                // System.out.println(i+" "+ closestRightIndex+" "+ closestLeftIndex);
                if(closestRightIndex!=-1 && closestLeftIndex!=-1){
                    int rightPushDistance = i-closestRightIndex;
                    int leftPushDistance = closestLeftIndex-i;
                    // System.out.println(i+" "+ rightPushDistance+" "+ leftPushDistance);
                    if(rightPushDistance<leftPushDistance){
                        dominoArr[i]='R';
                    }else if(rightPushDistance>leftPushDistance){
                        dominoArr[i]='L';
                    }
                    
                }else if(closestRightIndex!=-1){
                    dominoArr[i]='R';
                }else if(closestLeftIndex!=-1){
                    dominoArr[i]='L';
                }
            }
        }
        return new String(dominoArr);
    }
}