class Solution {
    public int minCostII(int[][] costs) {
        int n=costs.length;
        int totalColors=costs[0].length;
        int[] prevRow=new int[totalColors];
        
        
        for(int i=n-1;i>=0;i--){
            int[] curRow = new int[totalColors];
            Arrays.fill(curRow,Integer.MAX_VALUE);
            int firstLowestColor=0;
            int secondLowestColor=1;
            for(int color=0;color<totalColors;color++){
                if(prevRow[color]<prevRow[firstLowestColor]){
                    secondLowestColor=firstLowestColor;
                    firstLowestColor=color;
                }else if(color!=firstLowestColor && prevRow[color]<prevRow[secondLowestColor]){
                    secondLowestColor=color;
                }
            }
            
//             System.out.println(firstLowestColor);
//             System.out.println(secondLowestColor);
            
            for(int color=0;color<totalColors;color++){
                if(color!=firstLowestColor){
                    curRow[color] = Math.min(curRow[color], costs[i][color] + prevRow[firstLowestColor]);
                }else{
                    curRow[color] = Math.min(curRow[color], costs[i][color] + prevRow[secondLowestColor]);
                }
                // System.out.print(curRow[color]+" ");
            }
            // System.out.println();
            prevRow=curRow;
        }
        int minCost=Integer.MAX_VALUE;
        for(int color=0;color<totalColors;color++){
            minCost=Math.min(minCost,prevRow[color]);
        }
        return minCost;
    }
}