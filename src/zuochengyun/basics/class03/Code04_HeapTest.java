package zuochengyun.basics.class03;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code04_HeapTest {

	public static class AComp implements Comparator<Integer> {
		// 如果返回负数，认为第一个参数应该排在上面
		// 如果返回正数，认为第二个参数应该排在上面
		// 如果返回0，认为谁放前面都行
		@Override
		public int compare(Integer arg0, Integer arg1) {
			return arg1 - arg0;
		}
	}

	public static void main(String[] args) {
		//优先级队列默认是小根堆
		PriorityQueue<Integer> heap = new PriorityQueue<>(new AComp());

		heap.add(8);
		heap.add(9);
		heap.add(4);
		heap.add(7);
		heap.add(10);
		heap.add(6);
		heap.add(5);

		// 用了比较器后，将小根堆改为大根堆
		while (!heap.isEmpty()) {
			System.out.println(heap.poll());
		}
	}
}
