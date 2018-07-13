class Solution {
    public int countPrimes(int n) {
        int count = 1;
        int flag = 0;
        if(n <= 2)
            return 0;
        if(n == 3)
            return 1;

        for(int i = 3;i < n;i+=2){
                
            flag = 1;
            test:
            for(int j = 2;j <= Math.sqrt(i);j++){
                if(i % j == 0){
                    flag = 0;
                    break test;
                }
            }
            if(flag == 1){
                count++;
            }

        }
        return count;
    }
}