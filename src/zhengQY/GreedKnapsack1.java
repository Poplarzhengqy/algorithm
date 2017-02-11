package zhengQY;

import java.util.Arrays;

public class GreedKnapsack1 {
	public static void greed(int[] w, int[] p, int capacity, int n){
        

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
            if (w[i] < capacity) {
                x[i] = 1;
                capacity = capacity - w[i];
            }
        }
        System.out.println("解向量是: " + Arrays.toString(x));
        /**
         *根据解向量求出背包中存放物品的最大价值并打印
         */
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            if (x[i] == 1) {
                maxValue += p[i];
            }
        }
        //double endTime = System.currentTimeMillis();
        System.out.println("背包中物品的最大价值为: " + maxValue);
        //System.out.println("Basic Statements take(基本语句用时) " + (endTime - startTime) + " milliseconds!");
	}
}
