package zhengQY;

import java.util.Arrays;

public class DPKnapsack {
	
	public static int[][] countMatirx(int m, int n, int w[], int p[]){
		int c[][] = new int[n+1][m+1];
		for(int i=0; i<=n; i++)
			c[i][0] = 0;
		for(int j=0; j<=m; j++)
			c[0][j] = 0;
		for(int i=1; i<=n; i++){
			for(int j=1; j<=m; j++){
				//第i个物体重量为w[i-1],价值为p[i-1]
				if(w[i-1]<=j){
					if(c[i-1][j]<c[i-1][j-w[i-1]]+p[i-1])
						c[i][j] = c[i-1][j-w[i-1]]+p[i-1];
					else
						c[i][j] = c[i-1][j];
				}else
					c[i][j] = c[i-1][j];
			}
		}
		return c;
	}
	
	public static void output(int m, int n, int[][] c, int[] w, int[] p){
		int totalValue = 0;
		int[] x = new int[n]; 
	    //从最后一个状态记录c[n][m]开始逆推  
	    for(int i=n; i>0; i--){  
	    //如果c[i][m]大于c[i-1][m]，说明c[i][m]这个最优值中包含了w[i-1](注意这里是i-1，因为c数组长度是n+1)  
	       if(c[i][m]>c[i-1][m]){  
	           x[i-1] = 1;
	           totalValue += p[i-1];
	           m-=w[i-1];  
	       }  
	    }  
	    System.out.println("背包中物品的最大价值为： " + totalValue);
	    System.out.println("解向量为： " + Arrays.toString(x)); 
	    //return x;  
	}


}
