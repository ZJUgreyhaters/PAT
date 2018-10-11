import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName: PddCard
 * @Description: TODO
 * @Author: wbchen
 * @Date: 2018/10/11 00:37
 * @Version 1.0.0
 **/

public class PddCard {
    public static int caseCount = 0;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String str = scanner.nextLine().toLowerCase();
            Stack<Character> stack = new Stack<>();

            for(int i = 0;i < str.length();i++){
                char c = str.charAt(i);
                if(str.indexOf(c, i+1) == -1){
                    stack.push(c);
                    break;
                }
                stack.push(c);
            }
            char min = 'z';
            for(int i = 0;i < stack.size();i++){
                char tmp = stack.pop();
                if(tmp < min){
                    min = tmp;
                }
            }
            System.out.printf("Case %d # %c\n", caseCount++, min);
        }
    }
}

