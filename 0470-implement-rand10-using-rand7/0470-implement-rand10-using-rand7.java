/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int r = 40;
        while(r>=40){
            r = (rand7() - 1)*7 + rand7()-1;
        }
        
        return r%10+1;
    }
}