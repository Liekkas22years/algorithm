package zuochengyun.basics.class01;

public class Code07_EvenTimesOddTimes {
	// 一个数组中有一种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这种数
	// 异或运算满足交换律，结合律
	// 一个数和它自身异或，为0
	// 一个数和0异或，为它本身
	public static void printOddTimesNum1(int[] arr) {
		int eO = 0;
		for (int cur : arr) {
			eO ^= cur;
		}
		System.out.println(eO);
	}

	// a和b这两种数出现奇数次，其他数出现偶数次，找出a,b
	public static void printOddTimesNum2(int[] arr) {
		int eO = 0, eOhasOne = 0;
		for (int curNum : arr) {
			eO ^= curNum;
		}
		// 结果必然是 eor = a ^ b
		// 因为a!=b ,所以 eor != 0
		// eor必然有一个位置上是1
		int rightOne = eO & (~eO + 1);// 提取出最右的1
		for (int cur : arr) {
			if ((cur & rightOne) != 0) {
				eOhasOne ^= cur;
			}
		}
		System.out.println(eOhasOne + " " + (eO ^ eOhasOne));
	}

	public static void main(String[] args) {
		int a = 5;
		int b = 7;

		a = a ^ b;
		b = a ^ b;
		a = a ^ b;

		System.out.println(a);
		System.out.println(b);

		int[] arr1 = { 3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1 };
		printOddTimesNum1(arr1);

		int[] arr2 = { 4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2 };
		printOddTimesNum2(arr2);

	}

}
