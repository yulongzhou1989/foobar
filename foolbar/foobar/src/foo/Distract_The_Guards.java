package foo;

import java.util.Arrays;
import java.util.List;

public class Distract_The_Guards {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static int answer(int[] banana_list) { 

        // Your code goes here.
    	List bananaList = Arrays.asList(banana_list);
    	int count = 0;
    	for (int k=0;k<banana_list.length;k++){
	    	for (int i=k;i<banana_list.length; i++){
	    		int count1 = 0;
	    		for (int j=i+1;j<banana_list.length; j++){
	    			if (judgeInfiniteLoop(banana_list[i], banana_list[j])){
	    				count1 ++;
	    				i++;
	    				j++;
	    			}
	    		}
	    	}
    	}
    	
    	return count;
    }
    
    public static boolean judgeInfiniteLoop(int a, int b){
    	while (true){
    		int x1 = 2*a;
    		int x2 = b-2*a;
    		if (x1 == x2) {
    			return false;
    		} 
    		int a1 = x1<x2?x1:x2;
    		int b1 = x1>x2?x1:x2;
    		if (a1 == b && b1 == a){
    			return true;
    		}
    		if (b1%a1 == 0){
    			a1 = 1;
    			b1 = b1/a1;
    		}else {
    			int g = gcd(a1, b1);
    			a1 = a1/g;
    			b1 = b1/g;
    		}
    		
    		a = a1;
    		b = b1;
    	}
    }
    
    private static int gcd(int a, int b)
    {
        while (b > 0)
        {
            int temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }
}
