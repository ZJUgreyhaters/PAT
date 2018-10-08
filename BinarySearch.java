import java.util.Arrays;

public class BinarySearch {
	public static void main(String[] args){
		int[] target = new int[] {3, 2, 8, 1, 26, 15, 96, 24};
		Arrays.sort(target);
		int index = BinarySearchRecursion(target, 0, target.length - 1, 26);
		System.out.println("--- BinarySearch ---");
		System.out.println(target[index] + " is at palce " + index);

		System.out.println(BinarySearch(target, target.length - 1, 26));
	}

	public static int BinarySearch(int[] target, int size, int key){
		System.out.println("--- BinarySearch ---");
		int low = 0;
		int high = size;
		while(low<=high){
			int mid = (low + high) / 2;
			if(target[mid] == key){
				return mid;
			}else if(target[mid] > key){
				high = mid - 1;
			}else if(target[mid] < key){
				low = mid + 1;
			}
		}
		return -1;
	}

	public static int BinarySearchRecursion(int[] target, int low, int high, int key){
		if(low<=high){
			int mid = (low+high)/2;
			if(key == target[mid]){
				return mid;
			}else if(key>target[mid]){
				return BinarySearchRecursion(target, mid+1, high, key);
			}else if(key<target[mid]){
				return BinarySearchRecursion(target, low, mid-1, key);
			}
		}
		return -1;
	}

}