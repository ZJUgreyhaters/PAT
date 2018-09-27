//
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: RandomNum
 * @Description: TODO
 * @Author: wbchen
 * @Date: 2018/9/27 11:07
 * @Version 1.0.0
 **/

public class RandomNum {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int len = scanner.nextInt();
            int[] random = new int[len];

            for(int i = 0;i < len;i++){
                random[i] = scanner.nextInt();
            }

            Arrays.sort(random);
            for(int i=0;i<len;){
                System.out.println(random[i]);

                labale:
                while(++i < len){
                    if(random[i] != random[i - 1]){
                        break ;
                    }
                }
            }
        }
        return;
    }
}