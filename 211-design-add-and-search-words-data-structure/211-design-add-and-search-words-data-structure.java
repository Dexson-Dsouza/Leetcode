class WordDictionary {
    static class Trie{
        boolean ends;
        Trie[] child;
        
        Trie(){
            ends=false;
            child=new Trie[26];
        }
    }
    Trie root;
    public WordDictionary() {
        root=new Trie();
    }
    
    public void addWord(String word) {
        Trie cur=root;
        for(char ch:word.toCharArray()){
            if(cur.child[ch-'a']==null){
                cur.child[ch-'a']=new Trie();
            }
            cur=cur.child[ch-'a'];
        }
        cur.ends=true;
    }
    
    public boolean search(String word) {
        return find(root,word,0);
    }
    
    public boolean find(Trie root, String word, int index){
        if(index==word.length()){
            return root.ends;
        }
        if(word.charAt(index)!='.'){
            char ch=word.charAt(index);
            if(root.child[ch-'a']!=null){
                return find(root.child[ch-'a'],word,index+1);
            }
        }else{
            for(int i=0;i<26;i++){
                if(root.child[i]!=null && find(root.child[i],word,index+1)){
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */