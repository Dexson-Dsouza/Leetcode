class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pascalList = new ArrayList<>();
        pascalList.add(1);
        
        while(rowIndex>0){
            List<Integer> nextPascalList = new ArrayList<>();    
            for(int i=0;i<=pascalList.size();i++){
                int val = 0;
                
                if(i-1>=0){
                    val+=pascalList.get(i-1);
                }
                if(i<pascalList.size()){
                    val+=pascalList.get(i);
                }
                
                nextPascalList.add(val);
            }
            pascalList=nextPascalList;
            rowIndex--;
        }
        return pascalList;
    }
}