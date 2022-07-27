class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer,List<Integer>> rows=new HashMap<>();
        
        for(int[] seat:reservedSeats){
            int row=seat[0];
            int col=seat[1];
            if(rows.containsKey(row)==false){
                rows.put(row,new ArrayList<>());
                rows.get(row).add(0);
            }
            rows.get(row).add(col);
        }
        
        int countOfAssignedFams=0;
        
        for(int row:rows.keySet()){
            List<Integer> seats=rows.get(row);
            Collections.sort(seats);
            seats.add(11);
            int i=1;
            while(i<seats.size()){
                
                if(seats.get(i-1)<=1 && seats.get(i)>=10){
                    countOfAssignedFams+=2;
                }else if(seats.get(i-1)<=1 && seats.get(i)>=6){
                    countOfAssignedFams++;
                }else if(seats.get(i-1)<=5 && seats.get(i)>=10){
                    countOfAssignedFams++;
                }else if(seats.get(i-1)<=3 && seats.get(i)>=8){
                    countOfAssignedFams++;
                }
                i++;
            }
            // System.out.println(countOfAssignedFams+" "+row);
        }
        
        int emptyRows=n-rows.size();
        return countOfAssignedFams + emptyRows*(10/4);
    }
}