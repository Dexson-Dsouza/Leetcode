class Solution {
    public String reorganizeString(String s) {
        Map<Character,Integer> count_map = new HashMap<>();
        int len=s.length();
        for(char ch : s.toCharArray()){
            count_map.put(ch,count_map.getOrDefault(ch,0)+1);
        }
        
        List<Character> unique_chars = new ArrayList<>(count_map.keySet());
        Collections.sort(unique_chars,(a,b) -> count_map.get(b)-count_map.get(a));
        
        //build str
        char[] result_str= new char[len];
        int index=0;
        for(char ch:unique_chars){
            int count = count_map.get(ch);   
            while(count>0){
                result_str[index]=ch;
                index+=2;
                if(index>=len){
                    index=1;
                }
                count--;
            }
        }
        
        //check str
        String res=new String(result_str);
        for(int i=1;i<len;i++){
            if(result_str[i]==result_str[i-1]){
                res="";
                break;
            }
        }
        return res;
    }
}