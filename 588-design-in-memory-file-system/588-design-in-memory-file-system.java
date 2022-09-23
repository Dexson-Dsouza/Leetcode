class FileSystem {
    
    static class Trie{
        Map<String,Trie> dirs;
        Map<String,String> files;
        Trie(){
            dirs=new HashMap<>();
            files=new HashMap<>();
        }
    }
    
    Trie root;
    public FileSystem() {
        root=new Trie();
    }
    
    public List<String> ls(String path) {
        List<String> ls=new ArrayList<>();
        Trie cur=root;
        path=path.trim();
        String fileName="";
        if(path.equals("/")==false){
            if(path.charAt(0)=='/'){
                path=path.substring(1);
            }
            String[] dirs=path.split("/");
            
            for(int i=0;i<dirs.length-1;i++){
                String dir=dirs[i];
                cur=cur.dirs.get(dir);   
            }
            
            if(cur.files.containsKey(dirs[dirs.length-1])){
                fileName=dirs[dirs.length-1];
            }else{
                cur= cur.dirs.get(dirs[dirs.length-1]);
            }
            
        }
        
        if(fileName.length()>0){
            ls.add(fileName);
        }else{
            Map<String,String> files=cur.files;
            for(String dir:cur.dirs.keySet()){
                ls.add(dir);
            }
            for(String file:cur.files.keySet()){
                ls.add(file);
            }
        }
        Collections.sort(ls);
        return ls;
    }
    
    public void mkdir(String path) {
        Trie cur=root;
        if(path.charAt(0)=='/'){
            path=path.substring(1);
        }
        String[] dirs=path.split("/");
        for(int i=0;i<dirs.length;i++){
            String dir=dirs[i];
            if(cur.dirs.containsKey(dir)==false){
                cur.dirs.put(dir,new Trie());
            }
            cur=cur.dirs.get(dir);   
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        Trie cur=root;
        if(filePath.charAt(0)=='/'){
            filePath=filePath.substring(1);
        }
        String[] dirs=filePath.split("/");
        for(int i=0;i<dirs.length-1;i++){
            String dir=dirs[i];
            if(cur.dirs.containsKey(dir)==false){
                cur.dirs.put(dir,new Trie());
            }
            cur=cur.dirs.get(dir);   
        }
        
        String fileName=dirs[dirs.length-1];
        if(cur.files.containsKey(fileName)==false){
            cur.files.put(fileName,"");
        }
        cur.files.put(fileName,cur.files.get(fileName)+content);
    }
    
    public String readContentFromFile(String filePath) {
        Trie cur=root;
        if(filePath.charAt(0)=='/'){
            filePath=filePath.substring(1);
        }
        String[] dirs=filePath.split("/");
        for(int i=0;i<dirs.length-1;i++){
            String dir=dirs[i];
            if(cur.dirs.containsKey(dir)==false){
                cur.dirs.put(dir,new Trie());
            }
            cur=cur.dirs.get(dir);   
        }
        
        String fileName=dirs[dirs.length-1];
        return cur.files.get(fileName);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */