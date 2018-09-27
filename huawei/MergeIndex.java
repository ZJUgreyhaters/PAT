import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @ClassName: MergeIndex
 * @Description: TODO
 * @Author: wbchen
 * @Date: 2018/9/27 12:42
 * @Version 1.0.0
 **/

public class MergeIndex {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Map<Long,Long> merge = new TreeMap<>();
        int num = scanner.nextInt();
        for(int i=0;i < num;i++){
            long key = scanner.nextInt();
            long value = scanner.nextInt();
            if(merge.keySet().contains(key)){
                merge.put(key, merge.get(key) + value);
            }else {
                merge.put(key, value);
            }

        }

        merge.forEach((key,value) -> {
            System.out.println(key + " " + value);
        });
        return;
    }
}