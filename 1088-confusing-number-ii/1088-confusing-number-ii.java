class Solution {
    private static final Map<Integer,Integer> map= new HashMap<>();
    private static final int[] num = {0, 1, 6, 8, 9};

    static {
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
    }

    private int count;
    private int N;

    public int confusingNumberII(int N) {
        count = 0;
        this.N = N;
        dfs(0);
        return count;
    }

    private void dfs(long start) {
        if (start > N) {
            return;
        }
        if (isConfusing(start)) {
            count++;
        }
        for (int i = start == 0 ? 1 : 0; i < 5; i++) {
            dfs(start * 10 + num[i]);
        }
    }

    private static boolean isConfusing(long s) {
        long res = 0, x = s;
        while (x > 0) {
            int i = (int) (x % 10);
            long digit = map.get(i);
            res = res * 10 + digit;
            x = x / 10;
        }
        return res != s;
    }
}