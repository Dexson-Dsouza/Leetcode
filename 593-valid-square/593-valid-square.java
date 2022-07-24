class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return isValid(p1,p2,p3,p4) ||isValid(p1,p3,p2,p4) ||isValid(p1,p2,p4,p3) || 
            isValid(p1,p3,p4,p2) ||isValid(p1,p4,p2,p3) ||isValid(p1,p4,p3,p2);
    }
    
    boolean isValid(int[] p1, int[] p2, int[] p3, int[] p4){
        double d1=dist(p1,p2);
        double d2=dist(p3,p4);
        double d3=dist(p1,p3);
        double d4=dist(p2,p4);
        double d5=dist(p1,p4);
        double d6=dist(p2,p3);
        // System.out.println(d1+" "+d6 + " "+ d3);
        return d1!=0 && d3!=0 && d1==d2 && d3==d4 && d5==d6 && d5==d1; 
    }
    
    double dist(int[] p1, int[] p2){
        int x=Math.abs(p1[0]-p2[0]);
        int y=Math.abs(p1[1]-p2[1]);
        return (x*x+y*y); 
    }
}