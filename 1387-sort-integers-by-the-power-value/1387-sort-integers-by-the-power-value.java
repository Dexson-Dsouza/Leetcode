class Solution {
    public int getKth(int lo, int hi, int k) {
        Map<Integer,Integer> powerMap = new HashMap<>();
        powerMap.put(1,0);
        for(int i=lo;i<=hi;i++){
            findPower(i,powerMap);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]==b[1]?b[0]-a[0]:b[1]-a[1]);
        
        for(int i=lo;i<=hi;i++){
            // System.out.println(i+" "+findPower(i,powerMap));
            pq.add(new int[]{i,findPower(i,powerMap)});
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek()[0];
    }
    
    public int findPower(int n, Map<Integer,Integer> powerMap){
        if(powerMap.containsKey(n)){
            return powerMap.get(n);
        }
        int power;
        if(n%2==0){
            power = 1 + findPower(n/2,powerMap);
        }else{
            power = 1 + findPower(3*n+1,powerMap);
        }
        powerMap.put(n,power);
        return power;
    }
}