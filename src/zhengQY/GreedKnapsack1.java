package zhengQY;

import java.util.Arrays;

public class GreedKnapsack1 {
	public static void greed(int[] w, int[] p, int capacity, int n){
        

        /**
         *��ʼ��������x[n]
         */
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = 0;
        }
        /**
         *��Ⲣ��ӡ������
         */
        for (int i = 0; i < n; i++) {
            if (w[i] < capacity) {
                x[i] = 1;
                capacity = capacity - w[i];
            }
        }
        System.out.println("��������: " + Arrays.toString(x));
        /**
         *���ݽ�������������д����Ʒ������ֵ����ӡ
         */
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            if (x[i] == 1) {
                maxValue += p[i];
            }
        }
        //double endTime = System.currentTimeMillis();
        System.out.println("��������Ʒ������ֵΪ: " + maxValue);
        //System.out.println("Basic Statements take(���������ʱ) " + (endTime - startTime) + " milliseconds!");
	}
}
