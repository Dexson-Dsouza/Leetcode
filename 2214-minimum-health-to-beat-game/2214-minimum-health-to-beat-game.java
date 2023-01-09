class Solution {
    public long minimumHealth(int[] damage, int armor) {
        int maxDamage = 0;
        long damageSum = 0;
        for(int attackDamage:damage){
            damageSum+=attackDamage;
            maxDamage=Math.max(attackDamage,maxDamage);
        }
        return damageSum - Math.min(armor,maxDamage) + 1;
    }
}