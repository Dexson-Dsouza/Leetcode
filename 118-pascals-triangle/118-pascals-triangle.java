class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows=new ArrayList<>();
        rows.add(new ArrayList<>());
        rows.get(0).add(1);
        
        while(numRows>1){
            List<Integer> lastRow= rows.get(rows.size()-1);
            List<Integer> nextRow=new ArrayList<>();
            nextRow.add(lastRow.get(0));
            
            for(int i=0;i<lastRow.size();i++){
                int nextTerm = lastRow.get(i) + (i+1<lastRow.size()?lastRow.get(i+1):0);
                nextRow.add(nextTerm);
            }
            rows.add(nextRow);
            numRows--;
        }
        return rows;
    }
}