class Solution {
    public int bestClosingTime(String customers) {
        int countY=0;
        for(char ch:customers.toCharArray()){
            if(ch=='Y'){
                countY++;
            }
        }
        int result = Integer.MAX_VALUE;
        int hour = -1;
        for(int i=0;i<customers.length();i++){
            char ch=customers.charAt(i);
            int loss = countY;
            
            if(loss < result){
                result = loss;
                hour = i;
            }
            
            if(ch == 'Y'){
                countY--;
            }else{
                countY++;
            }
            // System.out.println(hour+" "+result+" "+i);
        }
        int loss = countY;
        if(loss < result){
            result = loss;
            hour = customers.length();
        }
        return hour;
        
    }
}