import java.util.Scanner;

/**
 * @ClassName: Gcd
 * @Description: TODO
 * @Author: wbchen
 * @Date: 2018/9/27 14:30
 * @Version 1.0.0
 **/

public class Gcd {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(a * b / Gcd(a, b));

    }

    public static int Gcd(int a, int b) {
        if(a < b){
            return Gcd(a, b-a);
        }else if(a > b){
            return Gcd(a-b, b);
        }
        return a;
    }
}