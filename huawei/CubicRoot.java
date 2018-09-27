import java.util.Scanner;

/**
 * @ClassName: CubicRoot
 * @Description: TODO
 * @Author: wbchen
 * @Date: 2018/9/27 14:39
 * @Version 1.0.0
 **/

public class CubicRoot {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        Double x = scanner.nextDouble();
        Double guess = 1d;
        System.out.printf("%.1f" ,Cubic(guess, x));
        return;
    }
    public static double Cubic(double guess, double x){
        /**
         * 如果guess是立方根的一个近似值，那么牛顿法：
         * （x/guess/guess + guess*2）/ 3
         * 是一个更优的解。
         */
        if(Math.abs(guess * guess * guess - x) < 0.00001){
            return guess;
        }else {
            return Cubic((x/guess/guess + guess * 2)/3, x);
        }
    }
}