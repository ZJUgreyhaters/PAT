class Solution {
    public int reverse(int x) {
    	if(x == 0)
    		return 0;
        int re = 0;//返回值
        int sign = 0;//正负  num-> 	0 1 2 3 4 5 6 7 8 9
        int index_l = 0;//	8960-> 	0 6 9 8 0 0 0 0 0 0
        int index_r = 0;//   412-> 	2 1 4 0 0 0 0 0 0 0
        int[] num = new int[10];

        if(x < 0){
        	x = -x;
            sign = 1; //正负
        }
        
        for(int i = 0;i < 10;i++)
            num[i] = 0;

        for(int i = 0;i < 10;i++){
            num[i] = x % 10;
            x = x / 10;
        }
        
        for(int i = 0;i < 10;i++){
        	if(num[i] != 0){
        		index_l = i;
        		break;
        	}
        }

        for(int i = 9;i >= 0;i--){
        	if(num[i] != 0){
        		index_r = i;
        		break;
        	}
        }
        for(int i = index_l;i <= index_r;i++){
        	re = re * 10 + num[i];
        }
        if(re%10 == num[index_r]){//判断溢出
        	if(sign == 1)
        		return -re;
        	else return re;
        }
        else return 0;

    }
}