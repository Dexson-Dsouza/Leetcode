class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> result=new ArrayList<>();
        List<String> curPerms=new ArrayList<>();
        curPerms.add("");
        
        generatePerms(curPerms,n,result);
        return result;
    }
    
    void generatePerms(List<String> curPerms, int n, List<String> result){
        if(n==0){
            result.addAll(curPerms);
            return;
        }
        if(n%2==1){
            List<String> nextPerms=new ArrayList<>();
            nextPerms.add("1");
            nextPerms.add("0");
            nextPerms.add("8");
            generatePerms(nextPerms,n-1,result);
            return;
        }
        int size=curPerms.size();
        List<String> nextPerms=new ArrayList<>();
        for(String s:curPerms){
            nextPerms.add("6"+s+"9");
            nextPerms.add("9"+s+"6");
            nextPerms.add("8"+s+"8");
            nextPerms.add("1"+s+"1");
            if(n>2){
                
                nextPerms.add("0"+s+"0");
            }
        }
        
        generatePerms(nextPerms,n-2,result);
    }
}