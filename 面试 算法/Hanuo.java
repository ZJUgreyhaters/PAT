import java.util.Scanner;
public class Hanuo {
	static int m = 0;
	
	public static void move(int disk, char A, char C) {
		System.out.println(++m + "th move: move[" + disk + "] " + A + " -> " + C);
	}

	public static void hanuo(int n, char A, char B, char C) {
		if(n == 1){
			Hanuo.move(1,A,C);
		} else {
			hanuo(n-1,A,C,B);
			Hanuo.move(n,A,C);
			hanuo(n-1,B,A,C);
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Input the number of Disk:");
		int disk = input.nextInt();
		Hanuo.hanuo(disk,'A','B','C');
		input.close();
		System.out.println("一共移动了： " + m + "次。");
	}
}
