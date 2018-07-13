class Solution {
    public boolean judgeSquareSum(int c) {
        if(c == 0)
            return true;
        int a = 0;
        for(int i = 0;i <= Math.sqrt(c/2);i++){
            a = c - i * i;
            if(a == ((int)Math.sqrt(a) * (int)Math.sqrt(a)))
                return true;
        }
        return false;
    }
}