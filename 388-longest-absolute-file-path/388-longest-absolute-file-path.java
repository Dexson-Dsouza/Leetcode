class Solution {
    public int lengthLongestPath(String input) {
        String[] directories=input.split("\n");
        int longestLength=0;
        List<String> levelDirs=new ArrayList<>();
        
        for(String currentDir:directories){
            StringBuilder currentDirSb=new StringBuilder(currentDir);
            int tabCount=0;
            while(currentDirSb.substring(0,1).equals("\t")){
                tabCount++;
                currentDirSb.delete(0,1);
            }
            if(levelDirs.size()==tabCount){
                levelDirs.add(currentDirSb.toString());
            }else{
                levelDirs.add(tabCount,currentDirSb.toString());
            }
            
            if(currentDirSb.toString().contains(".")){
                int curLen=0;
                for(int i=0;i<=tabCount;i++){
                    curLen+=levelDirs.get(i).length();
                }
                curLen+=tabCount;
                longestLength=Math.max(longestLength,curLen);
            }
            
        }
        return longestLength;
        
    }
}