class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int n=flights.length;
        int k=days[0].length;
        
        Integer[][] vacationDay=new Integer[k][n];
        
        for(int city=0;city<n;city++){
            if(flights[0][city]==1 || city==0){
                vacationDay[0][city]=days[city][0];
            }
        }
        
        for(int week=1;week<k;week++){
            for(int i=0;i<n;i++){

                for(int j=0;j<n;j++){
                    if(vacationDay[week-1][j]!=null && (flights[j][i]==1 || j==i)){
                        if(vacationDay[week][i]==null){
                            vacationDay[week][i]=0;
                        }
                        vacationDay[week][i]=Math.max(vacationDay[week][i],
                                                     vacationDay[week-1][j]+days[i][week]); 
                    }
                }   
            }
        }
        int result=0;
        for(int i=0;i<n;i++){
            if(vacationDay[k-1][i]!=null)  
                result=Math.max(result,vacationDay[k-1][i]);
        }
        return result;
    }
}