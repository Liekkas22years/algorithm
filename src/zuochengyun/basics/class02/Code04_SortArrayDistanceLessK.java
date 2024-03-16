package zuochengyun.basics.class02;

import java.util.PriorityQueue;

public class Code04_SortArrayDistanceLessK {

	public void sortedArrDistanceLessK(int[] arr, int k) {
		//优先级队列默认是小根堆
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		int index = 0;
		for (; index <= Math.min(arr.length, k); index++) {
			heap.add(arr[index]);
		}
		int i = 0;
		for (; index < arr.length; i++, index++) {
			heap.add(arr[index]);
			arr[i] = heap.poll();
		}
		while (!heap.isEmpty()) {
			arr[i++] = heap.poll();
		}
	}
}
