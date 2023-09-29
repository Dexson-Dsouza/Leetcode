class Solution {
    public int countPairs(int[] deliciousness) {
        Set<Integer> powersOf2 = new HashSet<>();
        int mod = (int)Math.pow(10,9)+7;
        long curNum = 1;
        powersOf2.add(1);
        for(int i=1;i<=21;i++){
            curNum = curNum<<1;
            powersOf2.add((int)(curNum%mod));
        }
        Map<Integer,Integer> s = new HashMap<>();
        long count = 0;
        for(int i=0;i<deliciousness.length;i++){
            int cur = deliciousness[i];
            for(int power:powersOf2){
                if(s.containsKey(power-cur)){
                    count+=s.get(power-cur);
                }
            }
            s.put(cur,s.getOrDefault(cur,0)+1);
        }
        return (int)(count%mod);
    }
}