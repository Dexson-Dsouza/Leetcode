class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b)-> a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        
        Deque<int[]> curList=new LinkedList<>();
        
        int totalPeople=people.length;
        for(int index=totalPeople-1;index>=0;index--){
            // System.out.println(people[index][0]+" "+people[index][1]);
            int countOfPeopleInFront=people[index][1];
            int curHeight=people[index][0];
            Deque<int[]> peopleInFront=new LinkedList<>();
            while(countOfPeopleInFront>0){
                int[] processedPerson = curList.pollFirst();
                int processedPersonHeight=processedPerson[0];
                if(processedPersonHeight>=curHeight){
                    countOfPeopleInFront--;
                }
                peopleInFront.offerLast(processedPerson);
            }
            
            curList.offerFirst(people[index]);
            while(peopleInFront.size()>0){
                curList.offerFirst(peopleInFront.pollLast());
            }            
        }
        int[][] result=new int[totalPeople][2];
        for(int index=0;index<totalPeople;index++){
            result[index]=curList.pollFirst();
        }
        return result;
    }
}