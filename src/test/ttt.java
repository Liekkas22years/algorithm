package test;

import java.util.*;

public class ttt {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void bubbleSort1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j-1]) {
                    swap(arr,j,j-1);
                }
            }
        }
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int e = arr.length - 1; e > 0; e--) {// 0 ~ e
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    // 插入排序 X
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // 在一个有序数组中，找某个数是否存在
    public static boolean isExist(int[] arr,int n) {
        if (arr.length == 0 || arr == null) {
            return false;
        }
        int l = 0;
        int r = arr.length - 1;;
        int mid = 0;
        while (l < r) {
            mid = l + ((r-l) >> 1);
            if (n == arr[mid]) {
                return true;
            } else if (n > arr[mid]) {
                l = mid + 1;
            } else {
                r = mid -1;
            }
        }
        return arr[mid] == n; //
    }

    // 在一个有序数组中，找>=某个数最左侧的位置  X
    public static int nearLeft(int[] arr,int n) {
        if (arr.length == 0) {
            return -1;
        }
        int l = 0;
        int r = arr.length - 1;;
        int mid = 0;
        int index = -1;
        while (l < r) {
            mid = l + ((r-l) >> 1);
            if(arr[mid] >= n) {
                r = mid - 1;
                index = mid;
            } else {
                l = mid + 1;
            }
        }
        return index;
    }

    // 一个数组中有一种数出现了奇数次，其他数都出现了偶数次，怎么找到这一个数

    // 一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到这两个数

    // 返回数组中的最大值
    public static int getMax(int[] arr,int l,int r) {
        if (l == r) {
            return arr[l];
        }
        int mid = l + ((r - l) >> 1);
        int left = getMax(arr,l,mid);
        int right = getMax(arr,mid+1,r);
        return Math.max(left,right);
    }

    // 归并排序
    public static void mergeSort(int[] arr) {
        if (arr.length < 2 || arr == null) {
            return;
        }
        mergeSort(arr,0,arr.length-1);
    }

    public static void mergeSort(int[] arr,int l,int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 2);
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }

    //
    public static void merge(int[] arr,int l,int mid,int r) {
        int[] help = new int[arr.length];

    }










    // 二叉树的先序遍历
    public static void prevOrder(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);
    }
    public static void main(String[] args) {
        int[] a = {-9,-7,0,3,8,10,40,9,100,-900,30};
        System.out.println(getMax(a,0,a.length-1));
    }










}
