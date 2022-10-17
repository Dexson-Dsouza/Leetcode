class Solution {
    public boolean checkIfPangram(String sentence) {
        int charBit=0;
        for(char ch:sentence.toCharArray()){
            int charIndex=ch-'a';
            charBit |= (1<<charIndex);
        }
        return charBit ==((1<<26)-1);
    }
}