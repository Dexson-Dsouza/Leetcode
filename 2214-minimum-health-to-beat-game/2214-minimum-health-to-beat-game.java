class Solution {
    public long minimumHealth(int[] damage, int armor) {
        Arrays.sort(damage);
        
        int maxDamage=damage[damage.length-1];
        long healthRequired= armor>=maxDamage? 0 : maxDamage-armor;
        
        for(int i=damage.length-2;i>=0;i--){
            healthRequired+=damage[i];
        }
        return healthRequired+1;
    }
}