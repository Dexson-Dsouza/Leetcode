class Trie {
    
    TrieNode root;
    
    public Trie() {
        root=new TrieNode();
        
    }
    
    public void insert(String word) {
        TrieNode w=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(w.children[c-'a']==null){
                w.children[c-'a']=new TrieNode();
            }
            w=w.children[c-'a'];
        }
        w.isWord=true;
    }
    
    public boolean search(String word) {
        TrieNode w=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(w.children[c-'a']==null)
                return false;
            w=w.children[c-'a'];
        }
        return w.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode w=root;
        for(int i=0;i<prefix.length();i++){
            char c=prefix.charAt(i);
            if(w.children[c-'a']==null)
                return false;
            w=w.children[c-'a'];
        }
        return true;
    }
}
class TrieNode{
    public boolean isWord;
    public TrieNode[] children;
    public TrieNode(){
        children= new TrieNode[26];
        isWord = false;
    }
    
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */