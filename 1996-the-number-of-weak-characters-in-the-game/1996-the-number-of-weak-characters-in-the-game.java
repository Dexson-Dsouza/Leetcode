class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties,(a,b)-> a[0]!=b[0]?b[0]-a[0]:a[1]-b[1]);
        
        int maxDefense=-1;
        
        int weakCharacters=0;
        
        for(int[] property : properties){
            if(property[1]<maxDefense){
                weakCharacters++;
            }else{
                maxDefense=property[1];
            }
        }
        return weakCharacters;
    }
}