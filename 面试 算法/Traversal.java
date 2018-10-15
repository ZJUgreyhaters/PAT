import java.util.Stack;
import java.util.Queue;
import java.util.ArrayDeque;

public class Traversal {
	
	public static void main(String[] args){
		TreeNode root = new TreeNode("root");

		root.setLeft(new TreeNode("left"));
		root.setRight(new TreeNode("right"));

		root.getLeft().setRight(new TreeNode("1"));
		root.getLeft().getRight().setLeft(new TreeNode("3"));
		root.getRight().setRight(new TreeNode("2"));

		TreeNode.preOrderWithoutRecursion(root);
		TreeNode.inOrderWithoutRecursion(root);
		TreeNode.postOrderWithoutRecursion(root);
		TreeNode.levelOrder(root);
		TreeNode.theInOrderTraversal_Stack(root);
	}
}


class TreeNode {
	String data;
	TreeNode left;
	TreeNode right;

	public TreeNode(String data){
		this.data = data;
		left = right = null;
	}

	public String getData(){
		return data;
	}

	public TreeNode getLeft(){
		return left;
	}

	public void setLeft(TreeNode left){
		this.left = left;
	}

	public TreeNode getRight(){
		return right;
	}
	public void setRight(TreeNode right){
		this.right = right;
	}

	public static void preOrderWithoutRecursion(TreeNode root){
		System.out.println("--- preOrderWithoutRecursion ---");
		Stack<TreeNode> nodes = new Stack<>();
		if(root != null)
			nodes.push(root);

		while(!nodes.isEmpty()){
			TreeNode current = nodes.pop();
			System.out.println(current.getData());
			if(current.getRight() != null){
				nodes.push(current.getRight());
			}
			if(current.getLeft() != null){
				nodes.push(current.getLeft());
			}
		}
	}
	public static void thePreOrderTraversal_Stack(TreeNode root){
		System.out.println("--- thePreOrderTraversal_Stack ---");
		Stack<TreeNode> stack = new Stack<>();

		while(root!=null || stack.size()>0){
			if(root!=null){
				System.out.println(root.getData());
				stack.push(root);
				root = root.getLeft();
			}else{
				root = stack.pop();
				root = root.getRight();
			}
		}

	}

	public static void inOrderWithoutRecursion(TreeNode root){
		System.out.println("--- inOrderWithoutRecursion ---");
		Stack<TreeNode> nodes = new Stack<>();

		while (root != null || !nodes.isEmpty()) {
			while(root!=null){
				nodes.push(root);
				root = root.getLeft();
			}
			lable:
			while(!nodes.isEmpty()){
				TreeNode node = nodes.pop();
				System.out.println(node.getData());
				root = node.getRight();
				if(root != null)
					break lable;
			}
		}
	}
	public static void theInOrderTraversal_Stack(TreeNode root) {  //中序遍历  
        System.out.println("--- theInOrderTraversal_Stack ---");
        Stack<TreeNode> stack = new Stack<>();  
        TreeNode node = root;  
        while (node != null || stack.size() > 0) {  
            if (node != null) {
                stack.push(node);   //直接压栈  
                node = node.getLeft();  
            } else {  
                node = stack.pop(); //出栈并访问  
                System.out.println(node.getData()); 
                node = node.getRight(); 
            }  
        }  
    } 

	public static void postOrderWithoutRecursion(TreeNode node){
		System.out.println("--- postOrderWithoutRecursion ---");
		Stack<TreeNode> stack = new Stack<>();
		Stack<TreeNode> output = new Stack<>();
        while (node != null || stack.size() > 0) {  
            if (node != null) {
            	output.push(node);
                stack.push(node);   //直接压栈
                node = node.getRight();
            } else {  
                node = stack.pop(); //出栈并访问
                node = node.getLeft();
            }
        }

        while(output.size() > 0){
        	System.out.println(output.pop().getData());
        }
	}

	public static void levelOrder(TreeNode root){
		System.out.println("--- levelOrder ---");
		Queue<TreeNode> queue = new ArrayDeque<>();
		if(root != null){
			queue.offer(root);
		}
		while(!queue.isEmpty()){
			TreeNode current = queue.poll();
			System.out.println(current.getData());
			if(current.getLeft() != null){
				queue.offer(current.getLeft());
			}
			if(current.getRight() != null){
				queue.offer(current.getRight());
			}
		}
	}
	
}