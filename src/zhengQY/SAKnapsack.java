package zhengQY;

import java.util.Random;


public class SAKnapsack {
	public static  int SA(int[] w, int[] v, int N, int C){
		  float t0=500;
		  float t=t0;
		  float a=0.95f;
		  float e=0.00001f;
		  int L=30*N;
		  int i, j;
		  int cw = 0;
		  int cv = 0;
		  int dw, dv;
		  
		  int[] x = new int[N];
		  
		  Random random = new Random();
		  while(t>e)
		  {
		    //srand((unsigned)time(NULL));
		    for(int k=0;k<L;k++)
		    {
		      i=random.nextInt(N); // 随机选一个物品i
		      if(x[i]==0){    // 若i不在背包中
		        if(cw+w[i]<=C)    // 若i可以加入背包，则加入，更新x,f,m
		        {
		          x[i]=1;
		          cv=cv+v[i];
		          cw=cw+w[i];
		        }
		        else    // i不能加入背包，找一个已经在背包中的j，
		        {
		          j = random.nextInt(N);
		          //j=random(1, N);
		          while(x[j]==0)
		          {
		        	  j = random.nextInt(N);
		          }
		          dv=v[i]-v[j];
		          dw=w[i]-w[j];
		          if(cw+dw<=C)
		        	  if(dv>0||(Math.exp(dv/t)>(double)(random.nextInt()/(double)Integer.MAX_VALUE)))
		        	  {
		        		  x[i]=1;
		        		  x[j]=0;
		        		  cv=cv+dv;
		        		  cw=cw+dw;
		        	  }
		        }
		      }
		      else    // 若i已在背包中，随即选择一个不在背包中的j，
		      {
		        j = random.nextInt(N);
		        while(x[j]==1)
		        {
		        	j = random.nextInt(N);
		        }
		        dv=v[j]-v[i];
		        dw=w[j]-w[i];
		        if(cw+dw<=C)
		        if(dv>0||(Math.exp(dv/t)>(double)(random.nextInt()/(double)Integer.MAX_VALUE)))
		        {
		          x[i]=0;
		          x[j]=1;
		          cv=cv+dv;
		          cw=cw+dw;
		        }
		      }
		    }
		    t=t*a;
		  }
		  return cv;
		}

}
