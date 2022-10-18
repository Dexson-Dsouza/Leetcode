class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b)->a[0]!=b[0]?a[0]-b[0]:b[1]-a[1]);
        
        for(int i=people.length-1;i>=0;i--){
            int steps=people[i][1];
            
            int index=i;
            while(steps>0){
                int[] temp = people[index];
                people[index] = people[index+1];
                people[index+1]=temp;
                steps--;
                index++;
            }
        }
        return people;
    }
}