class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i=0;
        int j=0;
        int l1=firstList.length;
        int l2=secondList.length;
        List<int[]> commonList=new ArrayList<>();
        while(i<l1 && j<l2){
            int commonStart = Math.max(firstList[i][0],secondList[j][0]);
            int commonEnd = Math.min(firstList[i][1],secondList[j][1]);
            if(commonStart<=commonEnd){
                commonList.add(new int[]{commonStart,commonEnd});
            }
            if(firstList[i][1]<=secondList[j][1]){
                i++;
            }else{
                j++;
            }
        }
        return commonList.toArray(new int[commonList.size()][2]);
    }
}