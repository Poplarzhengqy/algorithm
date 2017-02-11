package zhengQY;

import java.util.Arrays;
import java.util.Random;


public class TestMain {
	static int n = 800;   //��������
	static int capacity = 0;		//��������������;
	static int[] w = new int[1000];
	static int[] p = new int[1000];
	
	public static void main(String[] args){
		Random rd = new Random();
		int total = 0;  //��¼����������
		//����ÿ�����������,������1-100֮��
		for(int i=0; i<n; i++){
			w[i] = rd.nextInt(100)+1;
			total += w[i];
		}
		//�����������������������Ϊ����������������֮��
		capacity = (int)total*2/3;
		
		//����ÿ������������ֵ��������1-100֮��
		for(int i=0; i<n; i++){
			p[i] = rd.nextInt(100)+1;
		}
		
		//double���������飬���ڷ�֧�޽編
		double[] weight = new double[n];
		for(int i=0; i<n; i++){
			weight[i] = (double)w[i];
		}
		
		//double�ͼ�ֵ���飬���ڷ�֧�޽編
		double[] value = new double[n];
		for(int i=0; i<n; i++){
			value[i] = (double)p[i];
		}
		double capacity1 = (double) capacity;
		
		/**
		 * ̰���㷨1(�����Ȱ����尴ÿ��λ����������ֵ��С�ɴ�С��������ֵ�������ڶ�̬�滮������ֵ)
		 **/
		System.out.println("#####  ̰���㷨   #####");
		double startTime = System.currentTimeMillis();
		GreedKnapsack1.greed(w, p, capacity, n);
		double endTime = System.currentTimeMillis();
		System.out.println("̰���㷨������ʱ���ǣ� " + (endTime-startTime) + " millseconds!\n\n");
		
		
		
		/**
		 * ̰���㷨2(�����Ȱ����尴ÿ��λ����������ֵ��С�ɴ�С��������ֵ�������ڶ�̬�滮������ֵ)
		 **/
		System.out.println("#####  ̰���㷨   #####");
		startTime = System.currentTimeMillis();
		GreedKnapsack.greed(w, p, capacity, n);
	    endTime = System.currentTimeMillis();
		System.out.println("̰���㷨������ʱ���ǣ� " + (endTime-startTime) + " millseconds!\n\n");
		
		
		/**
		 * ��̬�滮
		 **/
		System.out.println("#####  ��̬�滮�㷨   #####");
		startTime = System.currentTimeMillis();	
		DPKnapsack.output(capacity, n, DPKnapsack.countMatirx(capacity, n, w, p), w, p);
		endTime = System.currentTimeMillis();
		System.out.println("��̬�滮�㷨������ʱ���ǣ� " + (endTime-startTime) + " millseconds!\n\n");
		
		
		/**
		 * ��֧�޽�
		 **/
		System.out.println("#####  ��֧�޽��㷨   #####");
		startTime = System.currentTimeMillis();			
		BBKnapsack bbk = new BBKnapsack();
		int[] x = new int[1000];

		double maxValue = bbk.knapsack(value, weight, capacity1, x);
		System.out.println("��������Ʒ������ֵΪ�� " + maxValue);
		//System.out.println("������Ϊ�� " + Arrays.toString(branch.bestWay));
		//System.out.println(branch.bestWay.length);
		endTime = System.currentTimeMillis();
		System.out.println("��֧�޽��㷨������ʱ���ǣ� " + (endTime-startTime) + " millseconds!\n\n");
		
		/**
		 * ��֧�޽�
		 **//*
		System.out.println("#####  ��֧�޽��㷨   #####");
		startTime = System.currentTimeMillis();			
		Branch branch = new Branch(w, value, n, capacity);
		branch.getMaxValue();
		System.out.println("��������Ʒ������ֵΪ�� " + branch.maxValue);
		System.out.println("������Ϊ�� " + Arrays.toString(branch.bestWay));
		//System.out.println(branch.bestWay.length);
		endTime = System.currentTimeMillis();
		System.out.println("��֧�޽��㷨������ʱ���ǣ� " + (endTime-startTime) + " millseconds!\n\n");*/
		
		/**
		 * ģ���˻�
		 **/
		
		System.out.println("#####  ģ���˻��㷨   #####");
		startTime = System.currentTimeMillis();	
		
		maxValue = SAKnapsack.SA(w, p, n, capacity);
		//SAKnapsack.knapsackSA(w, p, n, capacity);
		System.out.println("��������Ʒ������ֵΪ�� " + maxValue);
		endTime = System.currentTimeMillis();
		System.out.println("ģ���˻��㷨������ʱ���ǣ� " + (endTime-startTime) + " millseconds!\n\n");
		
	}		
}
