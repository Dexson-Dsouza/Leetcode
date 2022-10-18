class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder currentPerm=new StringBuilder();
        List<String> permutations=new ArrayList<>();
        createPerm(n,n,currentPerm,permutations);
        return permutations;
    }
    
    void createPerm(int left, int right, StringBuilder currentPerm, List<String> permutations){
        if(left==right && left==0){
            permutations.add(currentPerm.toString());
            return;
        }
        
        if(left>0){
            currentPerm.append("(");
            createPerm(left-1,right,currentPerm,permutations);
            currentPerm.deleteCharAt(currentPerm.length()-1);
        }
        
        
        if(left<right){
            currentPerm.append(")");
            createPerm(left,right-1,currentPerm,permutations);
            currentPerm.deleteCharAt(currentPerm.length()-1);
        }
    }
}