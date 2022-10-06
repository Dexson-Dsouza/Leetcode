class Solution {
    public int minDays(int n) {
        Map<Integer,Integer> dayRequired=new HashMap<>();
        
        return findDays(n,dayRequired);
    }
    
    public int findDays(int n, Map<Integer,Integer> dayRequired){
        if(n==1){
            return 1;
        }
        if(n<=0){
            return 0;
        }
        
        if(dayRequired.containsKey(n)){
            return dayRequired.get(n);
        }
        int required=n;
        required=Math.min(required,n%2 + findDays(n/2,dayRequired)+1);
        required=Math.min(required,n%3 + findDays(n/3,dayRequired)+1);
        dayRequired.put(n,required);
        // System.out.println(n+" "+required);
        return required;
    }
}