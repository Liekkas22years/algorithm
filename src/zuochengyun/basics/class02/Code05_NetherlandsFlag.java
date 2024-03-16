package zuochengyun.basics.class02;

// 荷兰国旗问题
public class Code05_NetherlandsFlag {

	// arr[i] < p  将当前arr[i]与<区下一个位置交换，i++,<区往右扩
	// arr[i] == p  i++
	// arr[i] > p  将当前arr[i]与>区前一个位置交换,i不动,>区往左扩
	public static int[] partition(int[] arr, int l, int r, int p) {
		int less = l - 1; // <区右边界
		int more = r + 1; // >区左边界
		while (l < more) {
			if (arr[l] < p) {
				swap(arr, ++less, l++);
			} else if (arr[l] > p) {
				swap(arr, --more, l);
			} else {
				l++;
			}
		}
		return new int[] { less + 1, more - 1 };
	}

	// for test
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// for test
	public static int[] generateArray() {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 3);
		}
		return arr;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] test = generateArray();

		printArray(test);
		int[] res = partition(test, 0, test.length - 1, 1);
		printArray(test);
		System.out.println(res[0]);
		System.out.println(res[1]);

	}
}
