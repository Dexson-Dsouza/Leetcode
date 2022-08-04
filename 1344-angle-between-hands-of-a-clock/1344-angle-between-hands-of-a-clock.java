class Solution {
    public double angleClock(int hour, int minutes) {
        double angle1 = 30*hour + 0.5*minutes;
        double angle2 = 6*minutes;
        double diff = angle2>=angle1 ? angle2-angle1 : angle1-angle2;
        return Double.min(diff,360-diff);
    }
}