package zhengQY;

import java.util.Arrays;
import java.util.Scanner;

public class GreedKnapsack {
	public static void greed(int[] w, int[] p, int capacity, int n){
        /**
         *����λ������ֵr[i]=v[i]/w[i]��������
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
         *�����������ͼ�ֵ�ֱ�浽w1[]��v1[]��
         */
        int[] w1 = new int[n];
        int[] v1 = new int[n];
        for (int i = 0; i < n; i++) {
            w1[i] = w[index[i]];
            v1[i] = p[index[i]];
        }
        System.out.println("�������Ʒ������ " + Arrays.toString(w1));
        System.out.println("�������Ʒ��ֵ�� " + Arrays.toString(v1));
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
            if (w1[i] < capacity) {
                x[i] = 1;
                capacity = capacity - w1[i];
            }
        }
        System.out.println("��������: " + Arrays.toString(x));
        /**
         *���ݽ�������������д����Ʒ������ֵ����ӡ
         */
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            if (x[i] == 1) {
                maxValue += v1[i];
            }
        }
        //double endTime = System.currentTimeMillis();
        System.out.println("��������Ʒ������ֵΪ: " + maxValue);
        //System.out.println("Basic Statements take(���������ʱ) " + (endTime - startTime) + " milliseconds!");
	}
}
