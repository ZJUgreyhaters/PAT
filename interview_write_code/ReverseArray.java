import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;

/**
 * @ClassName: ReverseArray
 * @Description: TODO
 * @Author: wbchen
 * @Date: 2018/10/6 22:32
 * @Version 1.0.0
 **/

public class ReverseArray {
    public static void main(String[] args){
        int[] ints = new int[] {1,2,3,4,5};
        String[] strings = new String[] {"one","two","three"};

        System.out.println(Arrays.toString(ints));
        ArrayUtils.reverse(ints);
        System.out.println(Arrays.toString(ints));

        System.out.println(Arrays.toString(strings));
        ArrayUtils.reverse(strings);
        System.out.println(Arrays.toString(strings));
    }
}