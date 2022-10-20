class Solution {
    public String intToRoman(int num) {
        int[] values=new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] roman=new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    
        StringBuilder romanStr=new StringBuilder();
        int index=0;
        while(num>0){
            while(num<values[index]){
                index++;
            }
            romanStr.append(roman[index]);
            num-=values[index];
        }
        return romanStr.toString();
    }
}