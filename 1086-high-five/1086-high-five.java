class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer,List<Integer>> studentScoreMap = new HashMap<>();
        
        Arrays.sort(items,(a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        
        for(int[] item:items){
            int id = item[0];
            int score = item[1];
            if(studentScoreMap.containsKey(id)==false){
                studentScoreMap.put(id,new ArrayList<>());
            }
            if(studentScoreMap.get(id).size()<5){
                studentScoreMap.get(id).add(score);
            }
        }
        int totalStudent = studentScoreMap.size();
        int[][] highFiveArr = new int[totalStudent][2];
        
        int index = 0;
        for(int id:studentScoreMap.keySet()){
            int scoreSum = 0;
            for(int score:studentScoreMap.get(id)){
                scoreSum += score;
            }
            int avgScore = scoreSum/5;
            highFiveArr[index][0] = id;
            highFiveArr[index][1] = avgScore;
            index++;
        }
        
        Arrays.sort(highFiveArr,(a,b)->a[0]-b[0]);
        return highFiveArr;
    }
}