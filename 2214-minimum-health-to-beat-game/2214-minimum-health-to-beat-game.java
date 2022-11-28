class Solution {
    public long minimumHealth(int[] damage, int armor) {
        int maxDamage = 0;
        long damageSum= 0;
        for(int d:damage){
            damageSum+=d;
            maxDamage = Math.max(maxDamage,d);
        }
        int damageWithArmor = Math.max(0 , maxDamage - armor);
        long healthRequired = damageWithArmor + damageSum - maxDamage;
        
        return healthRequired+1;
    }
}