class Solution {
    public int minDays(int n) {
        Map<Integer,Integer> minimumDaysToEat=new HashMap<>();
        return findMinimumDaysToEat(n,minimumDaysToEat);
    }
    
    public int findMinimumDaysToEat(int n, Map<Integer,Integer> minimumDaysToEat){
        if(n==0 || n == 1){
            return n;
        }
        if(minimumDaysToEat.containsKey(n)){
            return minimumDaysToEat.get(n);
        }
        
        int steps= Math.min(n%3 + 1 + findMinimumDaysToEat(n/3,minimumDaysToEat),
                            n%2 + 1 + findMinimumDaysToEat(n/2,minimumDaysToEat));
        // System.out.println(n+" "+steps);
        minimumDaysToEat.put(n,steps);
        return steps;
    }
}