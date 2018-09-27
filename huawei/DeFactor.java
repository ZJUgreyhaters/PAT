import java.util.Scanner;

/**
 * @ClassName: DeFactor
 * @Description: TODO
 * @Author: wbchen
 * @Date: 2018/9/27 12:24
 * @Version 1.0.0
 **/

public class DeFactor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long ulDataInput = scanner.nextLong();

        for(int i=2;i <= ulDataInput;i++){
            while (ulDataInput >= i){
                if(ulDataInput % i == 0){
                    System.out.print(i + " ");
                    ulDataInput = ulDataInput / i;
                }else break;
            }
//            System.out.print(" *" +i + "==");
        }
        return;
    }
}
