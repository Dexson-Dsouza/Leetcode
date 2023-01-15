class Solution {
    char[] parent;
    
    char find(char ch){
        int charIndex = ch-'a';
        // System.out.println(ch+" "+charIndex+" "+parent[charIndex]);
        if(parent[charIndex]==ch){
            return ch;
        }
        return parent[charIndex] = find(parent[charIndex]);
    }
    
    void union(char a, char b){
        char pa = find(a);
        char pb = find(b);
        int charIndexA = pa - 'a';
        int charIndexB = pb - 'a';
        if(pa<pb){
            parent[charIndexB]=pa;
        }else if(pa>pb){
            parent[charIndexA]=pb;
        }
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        parent = new char[26];
        for(int i=0;i<26;i++){
            char ch = (char)('a'+i);
            parent[i]=ch;
        }
        
        for(int i=0;i<s1.length();i++){
            // System.out.println(s1.charAt(i)+" "+s2.charAt(i));
            union(s1.charAt(i),s2.charAt(i));
        }
        
        StringBuilder smallestStrSb = new StringBuilder();
        
        for(char ch:baseStr.toCharArray()){
            smallestStrSb.append(find(ch));
        }
        return smallestStrSb.toString();
    }
}