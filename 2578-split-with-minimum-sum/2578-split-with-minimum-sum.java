class Solution {
    public int splitNum(int num) {
        char[] numArr = (String.valueOf(num)).toCharArray();
        Arrays.sort(numArr);
        int index = 0;
        while (index < numArr.length && numArr[index] == '0') {
          index++;
        }

        int i1 = index;
        int n1 = 0;
        while (i1 < numArr.length) {
          n1 = n1 * 10 + (numArr[i1] - '0');
          i1 += 2;
        }

        int i2 = index + 1;
        int n2 = 0;
        while (i2 < numArr.length) {
          n2 = n2 * 10 + (numArr[i2] - '0');
          i2 += 2;
        }
        return n1 + n2;
      }
}