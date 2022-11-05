class Solution {
    class Trie{
        boolean isEnd;
        Trie[]children;
        String word;
        Trie(){
            isEnd=false;
            children=new Trie[26];
            word=null;
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        HashSet<String> res= new HashSet<>();
        Trie root=buildTree(words);
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(board,root,res,i,j);
            }
        }
        
        return new ArrayList<>(res);
    }
    int[][]dirs={{0,1},{1,0},{0,-1},{-1,0}};
    public void dfs(char[][] board,Trie root,HashSet<String> res, int i,int j){
        char c=board[i][j];
        if(board[i][j]=='*' || root.children[c-'a']==null)
            return;
        root=root.children[c-'a'];
        
        if(root.word!=null)
            res.add(root.word);
        root.word=null;
        
        board[i][j]='*';
        for(int[]dir:dirs){
            int x=i+dir[0];
            int y=j+dir[1];
            
            if(x>=0 && y>=0 && x<board.length && y<board[0].length)
                dfs(board,root,res,x,y); 
        }
        board[i][j]=c;
    }
    
    public Trie buildTree(String[]words){
        Trie root=new Trie();
        for(String w:words){
            Trie cur= root;
            for(char c:w.toCharArray()){
                if(cur.children[c-'a']==null)
                    cur.children[c-'a']=new Trie();
                cur=cur.children[c-'a'];
            }
            cur.word=w;
            cur.isEnd=true;
            
        }
        return root;
    }
    
}