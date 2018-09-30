import java.util.*;

/**
 * @ClassName: HuffmanCode
 * @Description: TODO
 * @Author: wbchen
 * @Date: 2018/9/27 15:13
 * @Version 1.0.0
 **/

public class HuffmanCode {
    public static void main(String[] args){

        HuffmanNode a = new HuffmanNode("A", 45);
        HuffmanNode b = new HuffmanNode("B", 13);
        HuffmanNode c = new HuffmanNode("C", 12);
        HuffmanNode d = new HuffmanNode("D", 16);
        HuffmanNode e = new HuffmanNode("E", 9);
        HuffmanNode f = new HuffmanNode("F", 5);
        HuffmanNode g = new HuffmanNode(6);
        List<HuffmanNode> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        list.add(f);
        list.add(g);

        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>();
        queue.add(a);
        queue.add(b);
        queue.add(c);
        queue.add(d);
        queue.add(e);
        queue.add(f);
//        queue.add(g);

        while (queue.size() > 1){
            HuffmanNode first = queue.poll();
            HuffmanNode second = queue.poll();
            HuffmanNode father = HuffmanNode.merge(first, second);
            queue.add(father);
        }

        queue.peek();
        for(int i=0;i < list.size();i++){
            System.out.println(list.get(i).toString());
        }
        return;
    }
}

class HuffmanNode implements Comparable<HuffmanNode> {

    @Override
    public int compareTo(HuffmanNode node) {
        if(this.getWeight() > node.getWeight()){
            return 1;
        }else if(this.getWeight() <= node.getWeight()) {
            // <= 后添加的树放在前面
            // 4 7 8 11  
            // 8 11 11
            //   /\
            //   4 7
            return -1;
        }
        return 0;
    }

    String name = "defaultName";
    String code = "";
    int weight = -1;
    HuffmanNode left;
    HuffmanNode right;

    HuffmanNode() {

    }

    public HuffmanNode(int weight) {
        this.weight = weight;
    }
    public HuffmanNode(String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString(){
        return "Name: " + this.name + ", Code: " + this.code + ", Weight:" + this.weight;
    }

    //合并子树，返回新树，同时更新叶子节点code，效率可能不高，有待优化
    public static HuffmanNode merge(HuffmanNode l, HuffmanNode r){
        HuffmanNode re = new HuffmanNode(l.getWeight() + r.getWeight());

        if(l.getWeight() < r.getWeight()){
            re.setLeft(l);
            re.setRight(r);
            pathCode(re.getLeft(), "0");
            pathCode(re.getRight(), "1");
        }else{
            //权重相同时，将合并的树放到右边
            re.setLeft(r);
            re.setRight(l);
            pathCode(re.getLeft(), "0");
            pathCode(re.getRight(), "1");
        }

        return re;
    }

    //递归，将节点的哈夫曼编码更新
    public static void pathCode(HuffmanNode root, String code) {
        HuffmanNode left = root.getLeft();
        HuffmanNode right = root.getRight();
        if(left == null || right == null){
            root.setCode(code + root.getCode());
            return;
        }else{
            pathCode(left, code);
            pathCode(right, code);
        }
    }

    public void setLeft(HuffmanNode left){
        this.left = left;
    }
    public HuffmanNode getLeft() {
        return this.left;
    }

    public void setRight(HuffmanNode right){
        this.right =right;
    }
    public HuffmanNode getRight() {
        return this.right;
    }

    public void setCode(String code){
        this.code = code;
    }
    public String getCode() {
        return this.code;
    }

    public void setWeight(int weight){
        this.weight =weight;
    }
    public int getWeight() {
        return this.weight;
    }

}




