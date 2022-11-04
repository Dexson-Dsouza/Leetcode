class Solution {
    public String reverseVowels(String s) {
        int i=0;
        int j=s.length()-1;
        char[] reverseArr=s.toCharArray();
        Set<Character> vowels=new HashSet<>(Arrays.asList(new Character[]{'a','e','i','o','u','A','E','I','O','U'}));
        while(i<j){
            while(i<j && vowels.contains(reverseArr[i])==false){
                i++;
            }
            while(i<j && vowels.contains(reverseArr[j])==false){
                j--;
            }
            if(i<j){
                char t=reverseArr[i];
                reverseArr[i]=reverseArr[j];
                reverseArr[j]=t;
                i++;
                j--;
            }
        }
        return new String(reverseArr);
    }
}