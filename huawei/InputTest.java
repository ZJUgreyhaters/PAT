import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: InputTest
 * @Description: TODO
 * @Author: wbchen
 * @Date: 2018/9/26 22:00
 * @Version 1.0.0
 **/

public class InputTest {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Integer> output = new ArrayList<>();

        int flag = 0;
        int countSeq = 0;

        String[] str = input.nextLine().trim().split(" ");

        for(int m = 0;m<str.length;m++){
            if(Integer.decode(str[m]) == 0x00){

                int seq;
                int typeNum;

                if(++m < str.length){

                    seq = Integer.decode(str[m]);
                    if (flag == 0){
                        flag = 1;
                        countSeq = seq;
                        if(seq > 15 || seq < 1){
                            System.out.println("FALSE");
                            return;
                        }
                    }
                    if (flag == 1 && (seq > 15 || seq < 1) && (seq - 1) % 15 != countSeq){
                        System.out.println("FALSE");
                        return;
                    }
                }else {
                    System.out.println("FALSE");
                    return;
                }

                if(++m < str.length){
                    typeNum = Integer.decode(str[m]);
                }else {
                    System.out.println("FALSE");
                    return;
                }

                int[] tmp = new int[16];

                int type = (typeNum & 0xF0) / 16;
                int num = (typeNum & 0x0F);
                for(int i = 0;i<num;i++){
                    if (++m < str.length){
                        tmp[i] = Integer.decode(str[m]);
                    }else{
                        System.out.println("FALSE");
                        return;
                    }
                }
                Arrays.sort(tmp);
                if(type == 2){
                    for (int i=16-num;i<16;i++){
                        output.add(tmp[i]);
                    }
                }else {
                    for (int i = 15;i >= 16-num;i--){
                        output.add(tmp[i]);
                    }
                }
            }
        }
        for (int i = 0;i< output.size();i++){
            System.out.printf("0x%x ",output.get(i));
        }
    }
}
