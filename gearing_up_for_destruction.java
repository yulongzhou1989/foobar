package minion_labor_shifts;

import java.util.Arrays;

public class gearing_up_for_destruction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] data = {0,5,8};
		System.out.println(Arrays.toString(answer(data)));
	}
	
	public static int [] answer(int [] pegs){
		
		if (pegs.length<2 || pegs.length>10000){
			return new int [] {-1, -1};
		}
		
		if (pegs.length == 2){
			int a1 = pegs[0];
			int a2 = pegs[1];
			int a, b, r1 = 0;
			if (a2-a1<2){
				return new int [] {-1, -1};
			}
			else {
				if ((a2-a1)%3 == 0){
					r1 = 2*((a2-a1)/3);
					return new int [] {r1, 1};
				} else {
					a = 2 * (a2-a1);
					b = 3;
					return new int [] {a, b};
				}
			}
		}
		
		int len = pegs.length;
		int an = pegs[len-1];
		int an_1 = pegs[len-2];
		int a1 = pegs[0];
		int r1 = 2*(2*an_1 - a1 -an);
		
		if(!checkEachRadius(r1, pegs)){
			return new int [] {-1, -1};
		}
		else 
		{
			return new int [] {r1, 1};
		}
	}
	
	public static boolean checkEachRadius (int r1, int [] pegs){
		int r, r_prev = r1;
		for (int i=0; i<pegs.length; i++){
			r = i==0? r1: (pegs[i]-pegs[i-1]- r_prev);
			if (r<1) {
				return false;
			}
			r_prev = r;
		}
		
		return true;
	}
}
