class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int res = 0;
        Map<Integer, Integer>[] map = new Map[A.length];

        for (int i = 0; i < A.length; i++) {
            map[i] = new HashMap<>(i);

            for (int j = 0; j < i; j++) {
                long diff = (long)A[i] - A[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) continue;

                int d = (int)diff;
                int currentSeqCount = map[i].getOrDefault(d, 0);
                int prevSeqCount = map[j].getOrDefault(d, 0);
                res += prevSeqCount;
                map[i].put(d, currentSeqCount + prevSeqCount + 1);
            }
        }

        return res;
    }
}