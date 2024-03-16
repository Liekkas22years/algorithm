package classical_algorithm.josephus;

import java.util.Scanner;

//约瑟夫环---数组实现
public class realize_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt=0;
        int[] a = new int[110];
        int i =0;
        int k=0;
        int N = scanner.nextInt();
        int M = scanner.nextInt();//表示总共有n人，数到数字m时出局

        while(cnt!=N) //因为要求N个人的出局顺序，因此当cnt（用来统计已经出局的人）未达到n时，需要循环不断报数
        {
            i++;   //i是每个人的编号
            if(i>N) i=1;  //这里需要特别注意：i的值是不断累加的，一旦发现i的值>N，那么i需要重新从第1个人开始
            //数组要从第一个元素重新开始一个一个往后判断
            if(a[i]==0)   //只有元素值为0的人 才需要报数，元素值为非0的代表已经出局了，不用报数
            {
                k++;
                if(k==M)     //代表已经某个人已经报了M这个数，需要出局
                {
                    a[i]=1;  //编号为i的这个人出局
                    cnt++;   //出局的人数+1
                    System.out.println(i); //输出出局的人的编号
                    k=0;   //清空k，让下一个人重新从1开始报数
                }
            }
        }
    }
}
