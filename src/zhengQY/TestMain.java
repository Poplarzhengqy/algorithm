package zhengQY;

import java.util.Arrays;
import java.util.Random;


public class TestMain {
	static int n = 800;   //物体总数
	static int capacity = 0;		//背包允许总重量;
	static int[] w = new int[1000];
	static int[] p = new int[1000];
	
	public static void main(String[] args){
		Random rd = new Random();
		int total = 0;  //记录物体总重量
		//生成每个物体的重量,限制在1-100之间
		for(int i=0; i<n; i++){
			w[i] = rd.nextInt(100)+1;
			total += w[i];
		}
		//背包所允许承受总重量设置为物体总重量的三分之二
		capacity = (int)total*2/3;
		
		//生成每个物体所含价值，限制在1-100之间
		for(int i=0; i<n; i++){
			p[i] = rd.nextInt(100)+1;
		}
		
		//double型重量数组，用于分支限界法
		double[] weight = new double[n];
		for(int i=0; i<n; i++){
			weight[i] = (double)w[i];
		}
		
		//double型价值数组，用于分支限界法
		double[] value = new double[n];
		for(int i=0; i<n; i++){
			value[i] = (double)p[i];
		}
		double capacity1 = (double) capacity;
		
		/**
		 * 贪心算法1(由于先把物体按每单位重量所含价值大小由大到小排序，最大价值基本等于动态规划的最大价值)
		 **/
		System.out.println("#####  贪心算法   #####");
		double startTime = System.currentTimeMillis();
		GreedKnapsack1.greed(w, p, capacity, n);
		double endTime = System.currentTimeMillis();
		System.out.println("贪心算法的运行时间是： " + (endTime-startTime) + " millseconds!\n\n");
		
		
		
		/**
		 * 贪心算法2(由于先把物体按每单位重量所含价值大小由大到小排序，最大价值基本等于动态规划的最大价值)
		 **/
		System.out.println("#####  贪心算法   #####");
		startTime = System.currentTimeMillis();
		GreedKnapsack.greed(w, p, capacity, n);
	    endTime = System.currentTimeMillis();
		System.out.println("贪心算法的运行时间是： " + (endTime-startTime) + " millseconds!\n\n");
		
		
		/**
		 * 动态规划
		 **/
		System.out.println("#####  动态规划算法   #####");
		startTime = System.currentTimeMillis();	
		DPKnapsack.output(capacity, n, DPKnapsack.countMatirx(capacity, n, w, p), w, p);
		endTime = System.currentTimeMillis();
		System.out.println("动态规划算法的运行时间是： " + (endTime-startTime) + " millseconds!\n\n");
		
		
		/**
		 * 分支限界
		 **/
		System.out.println("#####  分支限界算法   #####");
		startTime = System.currentTimeMillis();			
		BBKnapsack bbk = new BBKnapsack();
		int[] x = new int[1000];

		double maxValue = bbk.knapsack(value, weight, capacity1, x);
		System.out.println("背包中物品的最大价值为： " + maxValue);
		//System.out.println("解向量为： " + Arrays.toString(branch.bestWay));
		//System.out.println(branch.bestWay.length);
		endTime = System.currentTimeMillis();
		System.out.println("分支限界算法的运行时间是： " + (endTime-startTime) + " millseconds!\n\n");
		
		/**
		 * 分支限界
		 **//*
		System.out.println("#####  分支限界算法   #####");
		startTime = System.currentTimeMillis();			
		Branch branch = new Branch(w, value, n, capacity);
		branch.getMaxValue();
		System.out.println("背包中物品的最大价值为： " + branch.maxValue);
		System.out.println("解向量为： " + Arrays.toString(branch.bestWay));
		//System.out.println(branch.bestWay.length);
		endTime = System.currentTimeMillis();
		System.out.println("分支限界算法的运行时间是： " + (endTime-startTime) + " millseconds!\n\n");*/
		
		/**
		 * 模拟退火
		 **/
		
		System.out.println("#####  模拟退火算法   #####");
		startTime = System.currentTimeMillis();	
		
		maxValue = SAKnapsack.SA(w, p, n, capacity);
		//SAKnapsack.knapsackSA(w, p, n, capacity);
		System.out.println("背包中物品的最大价值为： " + maxValue);
		endTime = System.currentTimeMillis();
		System.out.println("模拟退火算法的运行时间是： " + (endTime-startTime) + " millseconds!\n\n");
		
	}		
}
