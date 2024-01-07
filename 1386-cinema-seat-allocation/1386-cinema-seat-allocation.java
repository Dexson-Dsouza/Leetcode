class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer,List<Integer>> rowSeatMap= new HashMap<>();
        
        for(int[] seat:reservedSeats){
            int row=seat[0],col=seat[1];
            if(!rowSeatMap.containsKey(row)){
                rowSeatMap.put(row,new ArrayList<>());
                rowSeatMap.get(row).add(0);
            }
            rowSeatMap.get(row).add(col);
        }
        int count = (n-rowSeatMap.size())*2;
        for(int row:rowSeatMap.keySet()){
            List<Integer> cols =rowSeatMap.get(row);
            cols.add(11);
            Collections.sort(cols);
            for(int i=1;i<cols.size();i++){
                int leftSeat = cols.get(i-1);
                int rightSeat = cols.get(i);
                int seatInBetween = cols.get(i)-cols.get(i-1)-1;
                
                if(seatInBetween>=8){
                    if( leftSeat<=1 && rightSeat>=10 ){
                        count+=2;
                    }else{
                        count++;
                    }
                }else if(seatInBetween>=4){
                    if(  (leftSeat<2 && rightSeat>5)
                      || (leftSeat<4 && rightSeat>7)
                      || (leftSeat<6 && rightSeat>9)
                      ){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}