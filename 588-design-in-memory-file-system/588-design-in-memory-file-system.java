class Node{
    Map<String,Node> dirs;
    Map<String,String> files;
    Node(){
        dirs=new HashMap<>();
        files=new HashMap<>();
    }
}
class FileSystem {
    
    Node root;
    public FileSystem() {
        root=new Node();
    }
    
    List<String> getFileAndDirs(Node cur){
        List<String> combinedSet=new ArrayList<>();
        for(String file:cur.files.keySet()){
            combinedSet.add(file);
        }
        
        for(String file:cur.dirs.keySet()){
            combinedSet.add(file);
        }
        Collections.sort(combinedSet);
        return combinedSet;
    }
    
    public List<String> ls(String path) {
        if(path.equals("/")){
            return getFileAndDirs(root);
        }
        String[] dirs=path.substring(1).split("/");
        
        
        List<String> fileList=new ArrayList<>();
        Node cur=root;
        int len=dirs.length;
        for(int index=0;index<len-1;index++){
            if(cur.dirs.containsKey(dirs[index])==false){
                return fileList;
            }
            cur = cur.dirs.get(dirs[index]);
        }
        
        // System.out.println(path+" "+dirs[len-1]); 
        if(cur.files.containsKey(dirs[len-1])){
            fileList.add(dirs[len-1]);
            return fileList;
        }
        if(cur.dirs.containsKey(dirs[len-1])==false){
            return fileList;
        }
        cur = cur.dirs.get(dirs[len-1]);
        return getFileAndDirs(cur);
    }
    
    public void mkdir(String path) {
        String[] dirs=path.substring(1).split("/");
        Node cur=root;
        int len=dirs.length;
        for(int index=0;index<len;index++){
            // if(dirs[index].length()==0){
            //     continue;
            // }
            // System.out.println(dirs[index]);
            
            if(cur.dirs.containsKey(dirs[index])==false){
                cur.dirs.put(dirs[index],new Node());
            }
            cur = cur.dirs.get(dirs[index]);
        }
        // cur.files.put(dirs[len-1],"");
    }
    
    public void addContentToFile(String filePath, String content) {
        String[] dirs=filePath.substring(1).split("/");
        Node cur=root;
        int len=dirs.length;
        for(int index=0;index<len-1;index++){
            if(cur.dirs.containsKey(dirs[index])==false){
                cur.dirs.put(dirs[index],new Node());
            }
            cur = cur.dirs.get(dirs[index]);
        }
        if(cur.files.containsKey(dirs[len-1])==false){
            cur.files.put(dirs[len-1],"");
        }
        
        cur.files.put(dirs[len-1],cur.files.get(dirs[len-1])+ content);
    }
    
    public String readContentFromFile(String filePath) {
        String[] dirs=filePath.substring(1).split("/");
        Node cur=root;
        int len=dirs.length;
        for(int index=0;index<len-1;index++){
            cur = cur.dirs.get(dirs[index]);
        }
        return cur.files.get(dirs[len-1]);
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