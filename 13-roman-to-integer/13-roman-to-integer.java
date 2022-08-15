class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> symbolValueMap=new HashMap<>();
        symbolValueMap.put('I',1);
        symbolValueMap.put('V',5);
        symbolValueMap.put('X',10);
        symbolValueMap.put('L',50);
        symbolValueMap.put('C',100);
        symbolValueMap.put('D',500);
        symbolValueMap.put('M',1000);
        
        int val=0;
        for(int i=0;i<s.length();i++){
            if(i+1<s.length() && symbolValueMap.get(s.charAt(i))<symbolValueMap.get(s.charAt(i+1))){
                val += symbolValueMap.get(s.charAt(i+1))-symbolValueMap.get(s.charAt(i));
                i++;
            }else{
                val += symbolValueMap.get(s.charAt(i));
            }
        }
        return val;
    }
}