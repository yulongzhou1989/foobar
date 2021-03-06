package foo;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int [] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		//int [] a = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		System.out.println(answer(200));
	}
	
    public static int answer(int n)
    {
        int sum=0;
        int [][]memo = new int[n][n];
        for(int[] row : memo) Arrays.fill(row,-1);
       for(int i=(int)Math.floor(Math.sqrt(n*2));i<=n-1;i++)
           sum+=helper(n-i,i,memo);
       return sum;
    }
    
    public static int helper(int left, int prev,int[][] memo)
    {
        if(left==0||prev==1) return 0;
        if(memo[left][prev]!=-1) return memo[left][prev];
        int sum=0;
        if(prev>left) sum++;
       for(int i=(int)Math.floor(Math.sqrt(left*2));i<=left-1;i++)
       {
           if(i>=prev) break;
           sum+=helper(left-i,i,memo);
       }
       memo[left][prev]=sum;
       return sum;
    }
	
}
