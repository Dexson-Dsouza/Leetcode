class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        HashMap<Integer,Integer> sourceTargetMap = new HashMap<>();
        for(int i=0;i<indices.length;i++){
            int index = indices[i];
            String source = sources[i];
            int endIndex = index+source.length();
            if(endIndex<=s.length() && s.substring(index,endIndex).equals(source)){
                sourceTargetMap.put(index,i);
            }
        }
        
        StringBuilder res= new StringBuilder();
        
        int idx=0;
        while(idx<s.length()){
            if(sourceTargetMap.containsKey(idx)){
                int targetIndex = sourceTargetMap.get(idx);
                res.append(targets[targetIndex]);
                idx+=sources[targetIndex].length();
            }
            else{
                res.append(s.charAt(idx));
                idx++;
            }
        }
        return res.toString();
    }
}