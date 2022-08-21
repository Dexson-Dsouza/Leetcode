class Solution {
    public int[] movesToStamp(String stamp, String target) {
        List<Integer> indexes=new ArrayList<>();
        
        char[] targetArr=target.toCharArray();
        boolean[] visited=new boolean[target.length()];
        
        int stars=0;
        while(stars < target.length()){
            boolean inserted=false;
            for(int i=0;i<=target.length()-stamp.length();i++){
                if(visited[i]==false && canPlace(i,stamp,targetArr)){
                    inserted=true;
                    stars=insert(stamp,targetArr,i,stars);
                    visited[i]=true;
                    indexes.add(i);
                    if(stars==target.length()){
                        break;
                    }
                }
            }
            
            if(inserted==false){
                return new int[0];
            }
        }
        
        int[] result=new int[indexes.size()];
        for(int i=indexes.size()-1;i>=0;i--){
            result[indexes.size()-1-i]=indexes.get(i);
        }
        return result;
    }
    
    boolean canPlace(int i, String stamp, char[] targetArr){
        for(int index=0;index<stamp.length();index++){
            if(targetArr[index+i]!='*' && targetArr[index+i]!=stamp.charAt(index)){
                return false;
            }
        }
        return true;
    }
    
    int insert(String stamp, char[] targetArr, int index, int stars){
        for(int i=0;i<stamp.length();i++){
            if(targetArr[index+i]!='*'){
                targetArr[index+i]='*';
                stars++;
            }
        }
        return stars;
    }
}