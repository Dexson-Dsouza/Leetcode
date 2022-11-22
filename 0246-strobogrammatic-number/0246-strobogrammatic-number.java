class Solution {
    public boolean isStrobogrammatic(String num) {
        int s=0;
        int e=num.length()-1;
        Map<Character,Character> reversedCharMap=new HashMap<>();
        reversedCharMap.put('8','8');
        reversedCharMap.put('0','0');
        reversedCharMap.put('1','1');
        reversedCharMap.put('6','9');
        reversedCharMap.put('9','6');
        while(s<=e){
            char left=num.charAt(s);
            char right=num.charAt(e);
            char leftReversed=reversedCharMap.getOrDefault(left,'*');
            if(right!=leftReversed){
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}