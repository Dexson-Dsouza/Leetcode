class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    
    public int confusingNumberII(int N) {
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        
        int[] res = new int[1];
        helper(N, 0,res);
        return res[0];
    }
    private void helper(int N, long cur ,int[] res) {
        if (isConfusingNumber(cur)) {
            res[0]++;
        }
        for (Integer i : map.keySet()) {
            if (cur * 10 + i <= N && cur * 10 + i > 0) {
                helper(N, cur * 10 + i,res);
            }
        }
    }
    private boolean isConfusingNumber(long n) {
        long src = n;
        long res = 0;
        while (n > 0) {
            res = res * 10 + map.get((int) n % 10); 
            n /= 10;
        }
        return res != src;
    }
}