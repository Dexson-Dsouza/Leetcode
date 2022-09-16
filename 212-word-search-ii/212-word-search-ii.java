class Solution {
    static class Trie{
        Trie[] children;
        boolean ends;
        String word;
        Trie(){
            word="";
            ends=false;
            children=new Trie[26];
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        Trie root=new Trie();
        
        for(String word:words){
            Trie cur=root;
            for(char ch:word.toCharArray()){
                if(cur.children[ch-'a']==null){
                    cur.children[ch-'a']=new Trie();
                }
                cur=cur.children[ch-'a'];
            }
            cur.ends=true;
            cur.word=word;
        }
        
        Set<String> foundWordSet=new HashSet<>();
        
        int rows=board.length;
        int cols=board[0].length;
        
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                char cur=board[row][col];
                if(root.children[cur-'a']!=null){
                    findWords(board,row,col,root,foundWordSet);
                }
            }
        }
        return new ArrayList<>(foundWordSet);
        
    }
    
    int[] dirs=new int[]{0,-1,0,1,0};
    
    void findWords(char[][] board, int row, int col, Trie root, Set<String> foundWordSet){
        // System.out.println(board[row][col]);
        
        char temp=board[row][col];
        board[row][col]='*';
        root = root.children[temp-'a'];
        if(root.ends==true){
            root.ends=false;
            foundWordSet.add(root.word);
        }
        int rows=board.length;
        int cols=board[0].length;
        
        for(int i=0;i<4;i++){
            int nr=row+dirs[i];
            int nc=col+dirs[i+1];
            if(nr>=0 && nr<rows && nc>=0 && nc<cols && board[nr][nc]!='*' && root.children[board[nr][nc]-'a']!=null){
                findWords(board,nr,nc,root,foundWordSet);
            }
        }
        board[row][col]=temp;
    }
}