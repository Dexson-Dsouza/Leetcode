class Solution {
    public String reorganizeString(String s) {
        Map<Character,Integer> count=new HashMap<>();
        
        for(char ch:s.toCharArray()){
            count.put(ch,count.getOrDefault(ch,0)+1);
        }
        
        for(char ch:count.keySet()){
            if(count.get(ch)>(s.length()+1)/2){
                return "";
            }
        }
        
        List<Character> chars=new ArrayList<>(count.keySet());
        
        Collections.sort(chars,(a,b)-> count.get(b)-count.get(a));
        
        char[] res=new char[s.length()];
        
        
        int index=0;
        for(char ch:chars){
            int cnt=count.get(ch);
            while(cnt>0){
                res[index]=ch;
                index+=2;
                if(index>=s.length()){
                    index=1;
                }
                cnt--;
            }
        }
        
        return new String(res);
    }
}