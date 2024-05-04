class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int cnt=0;
        
        int f=0;
        int l=people.length-1;
        while(f<=l){
            int curWt = people[l];
            if(f<l && (people[f] + curWt)<=limit){
                f++;
            }
            l--;
            cnt++;
        }
        return cnt;
    }
}