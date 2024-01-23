class Solution {
    public int maxLength(List<String> arr) {
        int len=arr.size();
        
        int[] mask=new int[len];
        List<String> valid_words = new ArrayList<>();
        for(int i=0;i<len;i++){
            String s=arr.get(i);
            int[] count=new int[26];
            boolean is_valid = true;
            for(char ch:s.toCharArray()){
                int charIndex=ch-'a';
                if(count[charIndex]==1){
                    is_valid=false;
                    break;
                }
            }
            if(is_valid){
                valid_words.add(s);
            }
        }
        return findAllCombos(valid_words,0,new HashSet<Integer>());
    }
    
    int findAllCombos(List<String> arr, int index,Set<Integer> indexSet){
        if(index==arr.size()){
            int curLen=0;
            int[] count=new int[26];
            for(int i:indexSet){
                for(char ch:arr.get(i).toCharArray()){
                    int charIndex=ch-'a';
                    count[charIndex]++;
                    if(count[charIndex]==2){
                        return 0;
                    }
                }
                curLen+= arr.get(i).length();
            }
            return curLen;
        }
        int maxLen=0;
        maxLen=Math.max(maxLen,findAllCombos(arr,index+1,indexSet));
        indexSet.add(index);
        maxLen=Math.max(maxLen,findAllCombos(arr,index+1,indexSet));
        indexSet.remove(index);
        return maxLen;
    }
}