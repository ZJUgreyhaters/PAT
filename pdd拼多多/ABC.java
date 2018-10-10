import java.util.BitSet;
import java.util.Scanner;

/**
 * @ClassName: ABC
 * @Description: TODO
 * @Author: wbchen
 * @Date: 2018/10/10 23:16
 * @Version 1.0.0
 **/

public class ABC {
    public static void main(String[] args){
        System.out.println("X,Y,Z is in the range [0,A],[0,B],[0,C](0<=Z<=C),max value of X xor Y xor Z ?");
        Scanner in = new Scanner(System.in);
        System.out.print("A : ");
        long a = in.nextLong();
        System.out.print("B : ");
        long b = in.nextLong();
        System.out.print("C : ");
        long c = in.nextLong();
        BitSet x = longToBitSet(a);
        BitSet y = longToBitSet(b);
        BitSet z = longToBitSet(c);

        BitSet result = new BitSet(64);
        for(int i = 0;i < 64;i++){
            if(x.get(i) || y.get(i) || z.get(i)){
                if((x.get(i) && (y.get(i) || z.get(i))) || (y.get(i) && z.get(i))){
                    for(int j = i;j < 64;j++){
                        result.set(j);
                    }
                    break;
                }

                result.set(i);
            }
        }
        long max = 0;
        for(int i = 0;i < 64;i++){
            max = max * 2 + (result.get(i) ? 1 : 0);
        }
        System.out.println("The max value is :" + max);
    }

    public static BitSet longToBitSet(long para){
        BitSet re = new BitSet(64);
        int index = 63;
        while (para!=0){
            if(para % 2 == 1){
                re.set(index--);
            }else{
                index--;
            }

            para /= 2;
        }
        return re;
    }
}
