class Trie{
    Trie[] children;
    Trie(){
        children=new Trie[26];
    }
}
class Solution {
    public int countDistinct(String s) {
        Trie root=new Trie();
        int n=s.length();
        int count=0;
        for(int i=0;i<n;i++){
            Trie cur=root;
            for(int j=i;j<n;j++){
                int index =s.charAt(j)-'a';
                if(cur.children[index]==null){
                    cur.children[index]=new Trie();
                    count++;
                }
                cur=cur.children[index];
            }
        }
        return count;
    }
}