class Solution {
    public int lengthLongestPath(String input) {
        String[] names=input.split("\n");
        List<String> dirs=new ArrayList<>();
        int maxLen=0;
        for(String name:names){
            StringBuilder nameSb=new StringBuilder(name);
            int level=0;
            while(nameSb.indexOf("\t")!=-1){
                level++;
                nameSb = new StringBuilder(nameSb.toString().substring(1));
            }
            
            if(level==dirs.size()){
                dirs.add(nameSb.toString());
            }else{
                dirs.add(level,nameSb.toString());
            }
            if(name.indexOf(".")!=-1){
                int len=0;
                for(int i=0;i<=level;i++){
                    System.out.println(dirs.get(i));
                    len+=dirs.get(i).length();
                }
                maxLen=Math.max(maxLen,len+ level);
            }
        }
        return maxLen;
    }
}