package test360;

import java.util.*;

public class T_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Map<Integer, Boolean> map = new HashMap<>();//等待队列
        List<Integer> list = new ArrayList<>();
        int[] array = new int[n];
        int index = 0;//当前开到哪一个门
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if(arr[i] > i+1 ) {
                map.put(arr[i], true);
                list.add(arr[i]);
                continue;
            }else if(arr[i] == 1){
                flag = true;//开始开门
                array[arr[i]-1]=i+1;
                index = arr[i];//开到第一个门了
            }else if(flag && arr[i]<=i+1&&arr[i]==index+1){
                array[arr[i]-1] = i+1;
                index = arr[i];
                //查看等待队列里有么有可以开的门
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) <= i+1 && map.get(list.get(j)) == true){
                        array[list.get(j)-1] = i+1;
                        map.put(list.get(j),false);
                        index = list.get(j);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if(i!=n-1){
                System.out.print(array[i]+" ");
            }else {
                System.out.print(array[i]);
            }
        }
    }
}
