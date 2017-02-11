package zhengQY;

import java.util.Arrays;
import java.util.Scanner;

public class GreedKnapsack {
	public static void greed(int[] w, int[] p, int capacity, int n){
        /**
         *按单位重量价值r[i]=v[i]/w[i]降序排列
         */
        
        double[] r = new double[n];
        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            r[i] = (double) p[i] / (double) w[i];
            index[i] = i;
        }
        double temp = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (r[i] < r[j]) {
                    temp = r[i];
                    r[i] = r[j];
                    r[j] = temp;
                    int x = index[i];
                    index[i] = index[j];
                    index[j] = x;
                }
            }
        }
        /**
         *排序后的重量和价值分别存到w1[]和v1[]中
         */
        int[] w1 = new int[n];
        int[] v1 = new int[n];
        for (int i = 0; i < n; i++) {
            w1[i] = w[index[i]];
            v1[i] = p[index[i]];
        }
        System.out.println("排序后物品重量： " + Arrays.toString(w1));
        System.out.println("排序后物品价值： " + Arrays.toString(v1));
        /**
         *初始化解向量x[n]
         */
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = 0;
        }
        /**
         *求解并打印解向量
         */
        for (int i = 0; i < n; i++) {
            if (w1[i] < capacity) {
                x[i] = 1;
                capacity = capacity - w1[i];
            }
        }
        System.out.println("解向量是: " + Arrays.toString(x));
        /**
         *根据解向量求出背包中存放物品的最大价值并打印
         */
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            if (x[i] == 1) {
                maxValue += v1[i];
            }
        }
        //double endTime = System.currentTimeMillis();
        System.out.println("背包中物品的最大价值为: " + maxValue);
        //System.out.println("Basic Statements take(基本语句用时) " + (endTime - startTime) + " milliseconds!");
	}
}
