public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count=0;
        for(int i=0;i<32;i++){
            // System.out.println(((1<<i)&n) +" "+ (1<<i));
            count += (((1<<i)&n)!=0)?1:0;
        }
        return count;
    }
}