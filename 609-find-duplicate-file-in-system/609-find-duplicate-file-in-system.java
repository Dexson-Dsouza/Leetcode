class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String,List<String>> contentFileInfoMap=new HashMap<>();
        
        for(String path:paths){
            String[] dirs=path.split(" ");
            
            String directory=dirs[0];
            
            for(int i=1;i<dirs.length;i++){
                String fileContentStr = dirs[i];
                
                int index=fileContentStr.indexOf('(');
                String fileName=fileContentStr.substring(0,index);
                String content=fileContentStr.substring(index+1,fileContentStr.length()-1);
                if(contentFileInfoMap.containsKey(content)==false){
                    contentFileInfoMap.put(content,new ArrayList<>());
                }
                contentFileInfoMap.get(content).add(directory+"/"+fileName);
            }
        }
        
        List<List<String>> duplicateFiles=new ArrayList<>();
        
        for(String content:contentFileInfoMap.keySet()){
            List<String> files=contentFileInfoMap.get(content);
            if(files.size()>1){
                duplicateFiles.add(files);
            }
        }
        return duplicateFiles;
    }
}