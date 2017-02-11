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
		      i=random.nextInt(N); // ���ѡһ����Ʒi
		      if(x[i]==0){    // ��i���ڱ�����
		        if(cw+w[i]<=C)    // ��i���Լ��뱳��������룬����x,f,m
		        {
		          x[i]=1;
		          cv=cv+v[i];
		          cw=cw+w[i];
		        }
		        else    // i���ܼ��뱳������һ���Ѿ��ڱ����е�j��
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
		      else    // ��i���ڱ����У��漴ѡ��һ�����ڱ����е�j��
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
