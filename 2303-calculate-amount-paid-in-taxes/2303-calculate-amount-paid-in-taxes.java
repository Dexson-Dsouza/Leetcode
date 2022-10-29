class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double totalTax=0;
        int totalBracket=brackets.length;
        for(int i=0;i<totalBracket;i++){
            int prevAmount= i==0? 0: brackets[i-1][0];
            int currentAmount= Math.min(brackets[i][0]-prevAmount,income);
            if(i==totalBracket-1){
                currentAmount=income;
            }
            income-=currentAmount;
            int curTax = brackets[i][1];
            double taxAmount = (double)(currentAmount)*curTax/100;
            totalTax+=taxAmount;
        }
        return totalTax;
    }
}