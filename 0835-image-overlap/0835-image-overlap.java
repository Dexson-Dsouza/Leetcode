class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int rows = A.length, cols = A[0].length;
        List<int[]> Apixels = new ArrayList<>();
        List<int[]> Bpixels = new ArrayList<>();
        for (int r = 0; r<rows; r++)
            for (int c = 0; c<cols; c++){
                if (A[r][c] == 1) Apixels.add(new int[]{r,c});
                if (B[r][c] == 1) Bpixels.add(new int[]{r,c});
            }
        Map<String, Integer> map = new HashMap<>();
        for (int[] pa : Apixels)
            for (int[] pb : Bpixels) {
                int xTranslationDist = pa[0] - pb[0];
                int yTranslationDist = pa[1]-pb[1];
                String s = (xTranslationDist) + " " + (yTranslationDist);
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        int max = 0;
        for (int count : map.values())
            max = Math.max(max, count);
        return max;
    }
}