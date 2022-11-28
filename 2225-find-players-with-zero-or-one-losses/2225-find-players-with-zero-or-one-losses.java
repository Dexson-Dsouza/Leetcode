class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer,Integer> winCount=new HashMap<>();
        
        for(int[] match:matches){
            int winner = match[0];
            int loser = match[1];
            if(winCount.containsKey(winner)==false){
                winCount.put(winner,0);
            }
            winCount.put(loser,winCount.getOrDefault(loser,0)-1);
        }
        List<Integer> undefeatedList=new ArrayList<>();
        List<Integer> oneLostList=new ArrayList<>();
        for(int player:winCount.keySet()){
            int count = winCount.get(player);
            if(count==0){
                undefeatedList.add(player);
            }else if(count==-1){
                oneLostList.add(player);
            }
        }
        List<List<Integer>> result=new ArrayList<>();
        Collections.sort(undefeatedList);
        Collections.sort(oneLostList);
        result.add(undefeatedList);
        result.add(oneLostList);
        return result;
    }
}