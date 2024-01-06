class Solution {
    public int countTime(String time) {
        return countPermutations(time.toCharArray(),0);
    }
    
    int countPermutations(char[] time, int i){
        if(i==time.length){
            // System.out.println(time);
            return 1;
        }
        int count = 0;
        char current = time[i];
        if(current=='?'){
            for(char ch = '0';ch<='9';ch++){
                time[i]=ch;
                count+= countPermutations(time,i);
                time[i]=current;
            }
        }else{
            if(i==1){
                int hour = Integer.parseInt(""+time[0]+time[1]);
                if(hour>23){
                    return 0;
                }
            }
            
            if(i==4){
                int min = Integer.parseInt(""+time[3]+time[4]);
                if(min>=60){
                    return 0;
                }
            }
            
            count+= countPermutations(time,i+1);
        }
        
        return count;
    }
}