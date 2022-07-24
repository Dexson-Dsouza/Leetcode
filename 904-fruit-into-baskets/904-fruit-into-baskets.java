class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> fruitCountMap=new HashMap<>();
        
        int totalTree=fruits.length;
        int startTree=0;
        
        int MaxFruits=0;
        
        for(int tree=0;tree<totalTree;tree++){
            int curFruit=fruits[tree];
            fruitCountMap.put(curFruit,fruitCountMap.getOrDefault(curFruit,0)+1);
            while(fruitCountMap.size()>2){
                int startFruit=fruits[startTree];
                fruitCountMap.put(startFruit,fruitCountMap.get(startFruit)-1);
                if(fruitCountMap.get(startFruit)==0){
                    fruitCountMap.remove(startFruit);
                }
                startTree++;
            }
            MaxFruits=Math.max(MaxFruits,tree-startTree+1);
        }
        return MaxFruits;
    }
}