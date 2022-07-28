class Solution {
    public boolean canConvert(String str1, String str2) {
        if(str1.equals(str2)){
            return true;
        }
        Map<Character,Character> targetChars=new HashMap<>();
        
        for(int index=0;index<str1.length();index++){
            char source=str1.charAt(index);
            char target=str2.charAt(index);
            if(targetChars.getOrDefault(source,target)!=target){
                return false;
            }
            targetChars.put(source,target);
        }
        // System.out.println(targetChars.values());
        return new HashSet(targetChars.values()).size()<26;
    }
}