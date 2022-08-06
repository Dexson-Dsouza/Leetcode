class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int n=flights.length;
        int k=days[0].length;
        
        int[] vacationDay=new int[n];        
        
        for(int week=k-1;week>=0;week--){
            int[] curWeekVacationDays=new int[n];
            for(int i=0;i<n;i++){
                curWeekVacationDays[i]=vacationDay[i] + days[i][week];
                for(int j=0;j<n;j++){
                    if(flights[i][j]==1){
                        curWeekVacationDays[i]=Math.max(curWeekVacationDays[i],
                                                     vacationDay[j]+days[j][week]); 
                    }
                }   
                
            }
            vacationDay=curWeekVacationDays;
        }
        
        return vacationDay[0];
    }
}