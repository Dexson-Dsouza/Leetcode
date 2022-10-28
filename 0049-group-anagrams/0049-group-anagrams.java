class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> anagramMap=new HashMap<>();
        
        for(String s:strs){
            char[] strArr=s.toCharArray();
            Arrays.sort(strArr);
            String key=new String(strArr);
            if(anagramMap.containsKey(key)==false){
                anagramMap.put(key,new ArrayList<>());
            }
            anagramMap.get(key).add(s);
        }
        
        List<List<String>> anagramGroups=new ArrayList<>();
        for(List<String> group:anagramMap.values()){
            anagramGroups.add(group);
        }
        return anagramGroups;
    }
}