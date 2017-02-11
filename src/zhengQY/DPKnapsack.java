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
				//��i����������Ϊw[i-1],��ֵΪp[i-1]
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
	    //�����һ��״̬��¼c[n][m]��ʼ����  
	    for(int i=n; i>0; i--){  
	    //���c[i][m]����c[i-1][m]��˵��c[i][m]�������ֵ�а�����w[i-1](ע��������i-1����Ϊc���鳤����n+1)  
	       if(c[i][m]>c[i-1][m]){  
	           x[i-1] = 1;
	           totalValue += p[i-1];
	           m-=w[i-1];  
	       }  
	    }  
	    System.out.println("��������Ʒ������ֵΪ�� " + totalValue);
	    System.out.println("������Ϊ�� " + Arrays.toString(x)); 
	    //return x;  
	}


}
