
public class LearnSort {

	public static void printArray(int[] a){
		for(int i=0;i < a.length;i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		int[] unsorted = new int[20];
		System.out.println("======  Origin  ======");
		for(int i=0;i < unsorted.length;i++) {
			unsorted[i] = (int) (Math.random() * 1000);
			System.out.print(unsorted[i] + " ");
		}
		System.out.println();
		System.out.println("稳定算法： 插入，归并，冒泡。（无隔空交换）");

		int[] bubbleSort = unsorted.clone();
		BubbleSort(bubbleSort);

		int[] selectionSort = unsorted.clone();
		SelectionSort(selectionSort);

		int[] insertionSort = unsorted.clone();
		InsertionSort(insertionSort);

		int[] quickSort = unsorted.clone();
		System.out.println("======  Quick  ======");
		QuickSort(quickSort, 0, quickSort.length - 1);
		printArray(quickSort);

		int[] heapSort = unsorted.clone();
		HeapSort(heapSort);

		System.out.println("======  Merge  ======");
		int[] mergeSort = unsorted.clone();
		MergeSort(mergeSort, 0, mergeSort.length - 1);
		printArray(mergeSort);
	}
	//merge
	public static void MergeSort(int[] mergeSort, int left, int right) {


		if(left == right) {
			return;
		}
		int mid = (left + right) / 2;
		MergeSort(mergeSort, left, mid);
		MergeSort(mergeSort, mid+1, right);

		MergeSortImpl(mergeSort, left, mid, right);
	}

	public static void MergeSortImpl(int[] mergeSort, int left, int mid, int right) {

		int[] space = new int[right - left + 1];
		int index = 0;
		int left_index = left;
		int right_index = mid + 1;

		while(left_index<=mid && right_index<=right) {
			if(mergeSort[left_index]<=mergeSort[right_index]) {
				space[index++] = mergeSort[left_index++];
			}else {
				space[index++] = mergeSort[right_index++];
			}
		}

		while(left_index<=mid) {
			space[index++] = mergeSort[left_index++];
		}

		while(right_index<=right) {
			space[index++] = mergeSort[right_index++];
		}

		left_index = left;
		for(int i=0;i < right - left + 1;i++) {
			mergeSort[left_index++] = space[i];
		}
	}

	//堆排序
	public static void HeapSort(int[] heapSort) {
		System.out.println("======  Heap  ======");

		
		int heapSize = BuildHeap(heapSort);

		while(heapSize > 1) {

			heapSize--;
			int tmp = heapSort[heapSize];
			heapSort[heapSize] = heapSort[0];
			heapSort[0] = tmp;

			RebuildHeap(heapSort, 0, heapSize);
		}
		printArray(heapSort);
	}

	public static int BuildHeap(int[] heapSort) {
		int heapSize = heapSort.length;
		for(int i=heapSize/2-1;i>=0;i--) {
			RebuildHeap(heapSort, i, heapSize);
		}
		return heapSize;
	}

	public static void RebuildHeap(int[] heapSort, int index, int heapSize) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;

		int max = index;

		if(left < heapSize && heapSort[left] > heapSort[max]) {
			max = left;
		}

		if(right < heapSize && heapSort[right] > heapSort[max]) {
			max = right;
		}

		if(max != index) {
			int tmp = heapSort[max];
			heapSort[max] = heapSort[index];
			heapSort[index] = tmp;

			RebuildHeap(heapSort, max, heapSize);
		}

	}

	//快排
	public static void QuickSort(int[] quickSort, int left, int right) {
		//System.out.println(left + " " + right);
		if(left >= right) {
			return;
		}
		int pivot_index = QuickSortImpl(quickSort, left, right);

		QuickSort(quickSort, left, pivot_index - 1);
		QuickSort(quickSort, pivot_index + 1, right);
	}

	public static int QuickSortImpl(int[] quickSort, int left, int right) {
		int pivot = quickSort[right];
		int tail = left - 1;

		for(int i=left;i < right;i++) {
			if(quickSort[i] <= pivot) {
				tail++;
				int tmp = quickSort[i];
				quickSort[i] = quickSort[tail];
				quickSort[tail] = tmp;
			}
		}

		tail++;
		int tmp = quickSort[right];
		quickSort[right] = quickSort[tail];
		quickSort[tail] = tmp;

		return tail;
	}

	//插入排序
	public static void InsertionSort(int[] insertionSort) {
		System.out.println("======  Insert  ======");
		int[] insert = insertionSort;

		for(int i=1;i < insert.length;i++) {
			int get = insert[i];
			int j = i - 1;
			while(j >= 0 && insert[j] > get) {
				insert[j+1] = insert[j];
				j--;
			}
			insert[j+1] = get;
		}

		System.out.println("分类 ------------- 内部比较排序\n" +
                        "数据结构 ---------- 数组\n" +
                        "最差时间复杂度 ---- 最坏情况为输入序列是降序排列的,此时时间复杂度O(n^2)\n" +
                        "最优时间复杂度 ---- 最好情况为输入序列是升序排列的,此时时间复杂度O(n)\n" +
                        "平均时间复杂度 ---- O(n^2)\n" +
                        "所需辅助空间 ------ O(1)\n" +
                        "稳定性 ------------ 稳定\n");
		printArray(insert);
	}
	//选择排序
	public static void SelectionSort(int[] selectionSort) {
		System.out.println("======  Select  ======");
		int[] select = selectionSort;

		for(int i=0;i < select.length - 1;i++) {
			int min = i;
			for(int j=i+1;j < select.length;j++) {
				if(select[min] > select[j]) {
					min = j;
				}
			}
			if(min != i) {
				int tmp = select[min];
				select[min] = select[i];
				select[i] = tmp;
			}
		}

		System.out.println("分类 -------------- 内部比较排序\n" +
                "数据结构 ---------- 数组\n" +
                "最差时间复杂度 ---- O(n^2)\n" +
                "最优时间复杂度 ---- O(n^2)\n" +
                "平均时间复杂度 ---- O(n^2)\n" +
                "所需辅助空间 ------ O(1)\n" +
                "稳定性 ------------ 不稳定\n");

		printArray(select);
	}
	//冒泡排序
	public static void BubbleSort(int[] bubbleSort) {
		System.out.println("======  Bubble  ======");
		int[] bubble = bubbleSort;

		for(int i=0;i < bubble.length-1;i++) {
			for(int j=0;j < bubble.length - i - 1;j++) {
				if(bubble[j] > bubble[j+1]) {
					int tmp = bubble[j];
					bubble[j] = bubble[j+1];
					bubble[j+1] = tmp;
				}
			}
		}

		System.out.println("分类 -------------- 内部比较排序\n" +
                			"数据结构 ---------- 数组\n" +
                			"最差时间复杂度 ---- O(n^2)\n" +
                			"最优时间复杂度 ---- 如果能在内部循环第一次运行时,使用一个旗标来表示有无需要交换的可能,可以把最优时间复杂度降低到O(n)\n" +
                			"平均时间复杂度 ---- O(n^2)\n" +
                			"所需辅助空间 ------ O(1)\n" +
                			"稳定性 ------------ 稳定\n");
		printArray(bubble);
	}


}