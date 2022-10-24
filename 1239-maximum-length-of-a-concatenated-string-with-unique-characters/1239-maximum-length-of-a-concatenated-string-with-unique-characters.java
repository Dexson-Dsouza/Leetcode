class Solution {
    public int maxLength(List<String> arr) {
        int len=arr.size();
        
        int[] mask=new int[len];
        
        for(int i=0;i<len;i++){
            String s=arr.get(i);
            int curMask=0;
            for(char ch:s.toCharArray()){
                int charIndex=ch-'a';
                if((curMask & (1<<charIndex))!=0){
                    curMask = 0;
                    break;
                }
                curMask |= (1<<charIndex);
            }
            mask[i]=curMask;
        }
        return findAllCombos(arr,mask,0,new HashSet<Integer>());
    }
    
    int findAllCombos(List<String> arr, int[] mask, int index,Set<Integer> indexSet){
        if(index==mask.length){
            int curLen=0;
            int curMask=0;
            for(int i:indexSet){
                curLen+=arr.get(i).length();
                if(mask[i]==0 || (curMask&mask[i])!=0){
                    return 0;
                }
                curMask|=mask[i];
            }
            return curLen;
        }
        int maxLen=0;
        maxLen=Math.max(maxLen,findAllCombos(arr,mask,index+1,indexSet));
        indexSet.add(index);
        maxLen=Math.max(maxLen,findAllCombos(arr,mask,index+1,indexSet));
        indexSet.remove(index);
        return maxLen;
    }
}