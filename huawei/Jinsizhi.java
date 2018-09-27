
import java.util.Scanner;

/**
 * @ClassName: Jinsizhi
 * @Description: TODO
 * @Author: wbchen
 * @Date: 2018/9/27 12:36
 * @Version 1.0.0
 **/

public class Jinsizhi {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        double in = scanner.nextDouble();

        boolean isBigger = ((long) (in * 10 % 10)) >= 5 ? true : false;
        if(isBigger){
            System.out.print((long) in + 1);
        }else{
            System.out.print((long) in);
        }

    }
}