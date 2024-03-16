package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class homeWork {
    public static HashSet<Integer> set = new HashSet();

    // 从drug.txt中读数据，将无向图的邻接表转化为邻接矩阵
    public static List readData(String path) {
        List<String[]> list = new ArrayList<>();
        try {
            String encode = "GBK";
            File file = new File(path);
            if(file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file),encode);
                BufferedReader in = new BufferedReader(read);
                String str = null;
                while ((str = in.readLine()) != null) {
                    String[] text = str.split("\\s+");
                    list.add(text);
                    int from = Integer.parseInt(text[0]);
                    int to = Integer.parseInt(text[1]);
                    set.add(from);
                    set.add(to);

                }
                read.close();
            }
        } catch (Exception e) {

        }
        return list;
    }

    public static void floyd(int[][] e) {
        for(int i = 0; i < e.length; i++) {
            for(int j = 0; j < e.length; j++) {
                for(int k = 0; k <e.length; k++) {
                    if( e[i][j] > e[i][k] + e[k][j]) {
                        e[i][j] = e[i][k] + e[k][j];
                    }
                }
            }
        }
    }

    public static Map getCC(int[][] e) {

        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < e.length; i++) {
            int count = 0;
            for(int j = 0; j < e.length; j++) {
                for(int k = 0; k <e.length; k++) {
                    if( e[i][j] == e[j][k] && e[j][k] == e[k][i] && e[i][j] == 1) {
                        count++;
                    }
                }
            }
            map.put(i,count);
        }
        return map;
    }

    public static void main(String[] args) {
        List<String[]> list = new ArrayList<>();
        list = readData("D:\\homework\\drug.txt");
        // 顶点数
        int node = set.size();
        int len = list.size();
        // 邻接矩阵
        int[][] matrix = new int[node][node];
        for (int i = 0; i < list.size(); i++) {
            int from = Integer.parseInt(list.get(i)[0]);
            int to = Integer.parseInt(list.get(i)[1]);
            matrix[from][to] = 1;
        }

        // 平均度
        System.out.println((len*2.0)/node);
        //最短路径
        //floyd(matrix);

        //度分布
        int[] array = new int[node];
        int[] degree = new int[node];
        // array[i]中存的是节点i的度
        for (int i = 0; i < node; i++) {
            for (int j = 0; j < node; j++) {
                if(matrix[i][j] == 1) {
                    array[i]++;
                    array[j]++;
                }
            }
        }
        // degree[i]中存的是度为i的节点个数
        for (int i = 0; i < node; i++) {
            for (int j = 0; j < node; j++) {
                if (i == array[j]) {
                    degree[i]++;
                }
            }
        }


        for (int i = 0; i < degree.length; i++) {
            if(degree[i]*1.0/node != 0) {
                System.out.println("度为" + i + "概率为" + degree[i]*1.0/node);
            }
        }
        //聚类系数
        Map<Integer,Integer> map = new HashMap<>();
        map = getCC(matrix);
        for (int i = 0; i < node; i++) {
           System.out.println(i + "的聚类系数为" + map.get(i)*1.0/(array[i]*(array[i]-1)));
        }
    }
}
