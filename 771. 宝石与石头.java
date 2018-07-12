class Solution {
    public int numJewelsInStones(String J, String S) {
        char[] s = S.toCharArray();
        char[] j = J.toCharArray();
        int x = J.length();
        int y = S.length();
        int count = 0;

        for(int m = 0, n = 0;m < y;m++)
            for(n = 0;n < x;n++){
                if(s[m] == j[n])
                    count++;
            }
        return count;
    }
}