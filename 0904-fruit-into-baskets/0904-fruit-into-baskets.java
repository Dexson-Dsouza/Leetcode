class Solution {
    public int totalFruit(int[] fruits) {
        int maxCount = 0;
        int firstPtr = 0;
        int secondPtr = 0;
        Map<Integer,Integer> fruitMap = new HashMap<>();
        while(secondPtr<fruits.length){
            
            int currentFruit = fruits[secondPtr];
            fruitMap.put(currentFruit,fruitMap.getOrDefault(currentFruit,0)+1);
            while(fruitMap.size()>2){
                int prevFruit = fruits[firstPtr];
                int updatedCount = fruitMap.get(prevFruit) - 1;
                if(updatedCount==0){
                    fruitMap.remove(prevFruit);
                }else{
                    fruitMap.put(prevFruit,updatedCount);
                }
                firstPtr++;
            }
            maxCount=Math.max(maxCount,secondPtr - firstPtr +1);
            secondPtr++;
        }
        return maxCount;
    }
}