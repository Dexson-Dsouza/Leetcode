class Solution {
    public long minimumHealth(int[] damage, int armor) {
        long damageSum= 0;
        for(int d:damage){
            damageSum+=d;
        }
        long healthRequired = Long.MAX_VALUE;
        for(int d:damage){
            int damageTakeWithArmon = Math.max(0,d-armor);
            healthRequired=Math.min(healthRequired, damageSum - d +damageTakeWithArmon);
        }
        
        return healthRequired+1;
    }
}