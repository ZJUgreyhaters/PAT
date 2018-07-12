class Solution {
    public int largestPalindrome(int n) {
        long x = 0;
        long y = 0;
        long bound = 1;
        int flag = 0;
        long result = 0, tmp = 0;
        long[] dig = new long[16];
        int index = 0;
        int nice = 1;
        
        for(int i = 0;i < n;i++){
            x = x * 10 + 9;
            y = y * 10 + 9;
            bound = bound * 10;
        }
        bound = bound / 10;
        while((x >= bound) && (y >= bound)){
            result = x * y;
            tmp = result;
            //判断result是不是回文数
            index = 0;
            test:
            for(int i = 0;i < 16;i++){
                dig[i] = tmp % 10;
                tmp /= 10;
                index++;
                if(tmp == 0)
                    break test;
            }
            nice = 1;
            for(int i = 0;i <= index / 2;i++){
                if(dig[i] != dig[index - 1 - i])
                    nice = 0;
            }
            
            if(nice == 1)
                return (int)result % 1337;
            
            if(flag == 0){
                x--;
                flag = 1;
            }
            else{
                y--;
                flag = 0;
            }
        }
        
        return 0;
    }
}