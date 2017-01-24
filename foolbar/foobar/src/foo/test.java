package foo;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int [] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		int [] a = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		System.out.println(answer(a));
	}
	
	public static int answer(int[] l) {
	   // Your code goes here.
		if (l.length<3)
			return 0;
		
		int [] memo = new int [l.length];

		int sum = 0;
		for (int i=0;i<l.length;i++){
			Arrays.fill(memo, -1);
			sum+=getCount(1,l,i,memo);
		}
		return sum;
	} 
	
	public static int getCount(int count, int [] l, int pos, int [] memo){
		if (count == 3){
			return 1;
		}
		if (pos == l.length){
			return 0;
		}
		if (memo[pos]!=-1) return memo[pos];
		int sum = 0;
		for(int i=pos+1;i<l.length;i++){
			if (l[i]%l[pos] == 0){
				sum+=getCount(count+1,l,i,memo);
			}
		}
		
		memo[pos] = sum;
		return sum;
	}
	
}
