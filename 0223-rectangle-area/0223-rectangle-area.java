class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1= (ay2-ay1)*(ax2-ax1);
        int area2= (by2-by1)*(bx2-bx1);
        int commonArea=0;
        int areaOfOverlap = calcOverlap(ax1, ax2, bx1, bx2) * calcOverlap(ay1, ay2, by1, by2);
        return area1+area2-areaOfOverlap;
    }
    
    public int calcOverlap(int a1, int a2, int b1, int b2) {
        int overlap =  Math.min(a2, b2) - Math.max(a1, b1);
        return overlap > 0 ? overlap: 0;
    }
}