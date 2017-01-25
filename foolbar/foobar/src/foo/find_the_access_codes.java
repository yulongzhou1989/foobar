package foo;

import java.util.Arrays;

public class find_the_access_codes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = {1,2,3,4,5,6};
		System.out.println(answer(a));
	}
	
	public static int answer(int[] l) {
	   // Your code goes here.
		//if (l.length<3)
		//	return 0;
			//return foolMethod(l);
		
		int [] memo = new int [l.length];
		int sum=0;
		for (int i=1;i<l.length;i++){
			for(int j=i-1;j>=0;j--){
				if (l[i]%l[j] == 0){
					memo[i]++;
					sum+=memo[j];
				}
			}
		}
		
		return sum;
		
		//int [] memo = new int [l.length];
		//Arrays.fill(memo, -1);
//		int sum = 0;
//		for (int i=0;i<l.length;i++){
//			//Arrays.fill(memo, -1);
//			int [] memo = new int [l.length];
//			sum+=getCount(1,l,i,memo);
//		}
//		return sum;
	} 
	
//	public static int getCount(int count, int [] l, int pos, int [] memo){
//		if (count == 3){
//			return 1;
//		}
//		if (pos == l.length){
//			return 0;
//		}
//		if (memo[pos]!=0) return memo[pos];
//		int sum = 0;
//		for(int i=pos+1;i<l.length;i++){
//			if (l[i]%l[pos] == 0){
//				sum+=getCount(count+1,l,i,memo);
//			}
//		}
//		
//		memo[pos] = sum;
//		return sum;
//	}
//	
//	public static int foolMethod(int [] l){
//		int count = 0;
//		for(int i =0;i<l.length-2;i++){
//			for (int j=i+1; j<l.length-1;j++){
//				if (l[j]%l[i]!=0){
//					continue;
//				}
//				for (int k=j+1;k<l.length;k++){
//					if (l[k]%l[j] == 0 && l[j]%l[i] == 0){
//						count++;
//					}
//				}
//			}
//		}
//		
//		return count;
//	}
}
