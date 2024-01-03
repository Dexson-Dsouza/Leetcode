class Solution {
    public int numberOfBeams(String[] bank) {
        int prevCount = 0;
        int total = 0;
        
        for(String row:bank){
            int deviceInRow = 0;
            for(char ch:row.toCharArray()){
                if(ch=='1'){
                    deviceInRow++;
                }
            }
            // System.out.println(row+" "+deviceInRow+" "+prevCount);
            if(deviceInRow>0){
                total += deviceInRow*prevCount;
                prevCount = deviceInRow;
            }
        }
        return total;
    }
}