package leetcode;

import java.util.Arrays;

public class t_ff {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        return 1;
    }

    public static void swap(int[] arr, int j, int i){

        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static int partition(int arr[], int start, int end){
        assert(null != arr);
        int temp = arr[start];

        while(start < end){
            while(temp < arr[end] && start < end){
                end--;
            }
            swap(arr, start, end);
            while(temp > arr[start] && start < end){
                start++;
            }
            swap(arr, start, end);
        }
        System.out.println(Arrays.toString(arr) + "   " +  start);
        return start;
    }

    public static void partitionSort(int arr[], int start, int end){
        assert(null != arr);

        if(start < end){
            int midd = partition(arr, start, end);
            partitionSort(arr, start, midd - 1);
            partitionSort(arr, midd + 1, end);
        }
    }

    public static void main(String[] args) {
        int arr[] = {9,1,5,8,3,7,4,6,2};
        t_ff.partitionSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
