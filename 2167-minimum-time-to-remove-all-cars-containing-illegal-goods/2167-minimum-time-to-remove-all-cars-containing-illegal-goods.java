class Solution {
    public int minimumTime(String s) {
        
        if(s.length()==1){
            return s.charAt(0)=='1'?1:0;
        }
        int[] leftOperationCost=new int[s.length()];
        
        int cnt=0;
        for(int i=0;i<s.length();i++){
            int prevCost = i>0 ? leftOperationCost[i-1]:0;
            if(s.charAt(i)=='1'){
                cnt++;
                leftOperationCost[i] = Math.min(2+prevCost, i+1);
            }else{
                leftOperationCost[i]=prevCost;
            }
        }
        
        int[] rightOperationCost=new int[s.length()];
        cnt=0;
        for(int i=s.length()-1;i>=0;i--){
            int prevCost = i<s.length()-1? rightOperationCost[i+1]:0;
            if(s.charAt(i)=='1'){
                cnt++;
                rightOperationCost[i] = Math.min(2+ prevCost, s.length()-i);
            }else{
                rightOperationCost[i] = prevCost;
            }
        }
        int minCost=s.length();
        for(int i=0;i<s.length()-1;i++){
            // System.out.println(leftOperationCost[i]+" "+ rightOperationCost[i]);
            minCost = Math.min(minCost , leftOperationCost[i] + rightOperationCost[i+1]);
        }
        return minCost;
    }
}