package minion_labor_shifts;

// Gearing Up for Destruction
// ==========================

// As Commander Lambda's personal assistant, you've been assigned the task of configuring the LAMBCHOP doomsday device's axial orientation gears. It should be pretty simple - just add gears to create the appropriate rotation ratio. But the problem is, due to the layout of the LAMBCHOP and the complicated system of beams and pipes supporting it, the pegs that will support the gears are fixed in place.

// The LAMBCHOP's engineers have given you lists identifying the placement of groups of pegs along various support beams. You need to place a gear on each peg (otherwise the gears will collide with unoccupied pegs). The engineers have plenty of gears in all different sizes stocked up, so you can choose gears of any size, from a radius of 1 on up. Your goal is to build a system where the last gear rotates at twice the rate (in revolutions per minute, or rpm) of the first gear, no matter the direction. Each gear (except the last) touches and turns the gear on the next peg to the right.

// Given a list of distinct positive integers named pegs representing the location of each peg along the support beam, write a function answer(pegs) which, if there is a solution, returns a list of two positive integers a and b representing the numerator and denominator of the first gear's radius in its simplest form in order to achieve the goal above, such that radius = a/b. The ratio a/b should be greater than or equal to 1. Not all support configurations will necessarily be capable of creating the proper rotation ratio, so if the task is impossible, the function answer(pegs) should return the list [-1, -1].

// For example, if the pegs are placed at [4, 30, 50], then the first gear could have a radius of 12, the second gear could have a radius of 14, and the last one a radius of 6. Thus, the last gear would rotate twice as fast as the first one. In this case, pegs would be [4, 30, 50] and answer(pegs) should return [12, 1].

// The list pegs will be given sorted in ascending order and will contain at least 2 and no more than 20 distinct positive integers, all between 1 and 10000 inclusive.

// Languages
// =========

// To provide a Python solution, edit solution.py
// To provide a Java solution, edit solution.java

// Test cases
// ==========

// Inputs:
    // (int list) pegs = [4, 30, 50]
// Output:
    // (int list) [12, 1]

// Inputs:
    // (int list) pegs = [4, 17, 50]
// Output:
    // (int list) [-1, -1]


import java.util.Arrays;

public class gearing_up_for_destruction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] data = {4, 7};
		System.out.println(Arrays.toString(answer(data)));
	}
	
	public static int [] answer(int [] pegs){
		
		int [] notQualified = {-1, -1};
		
		if (pegs.length<2 || pegs.length>10000){
			return notQualified;
		}
		
		int len = pegs.length;
		double rn = pegs[len-1];
		double r1 = 0;
		int a=0, b=0;
		
		String operator = "minus";
		for (int i=len-2;i>=0;i--){
			double currentNum = i==0? pegs[i]: 2*pegs[i]; 
			
			if (operator.equals("minus")){
				rn -= currentNum;
				operator = "plus";
			} else {
				rn += currentNum;
				operator = "minus";
			}
		}
		
		if (len%2 == 0){
			r1 = rn/3 * 2;
			if (rn%3 == 0){
				a = (int)r1;
				b = 1;
			} else {
				a = (int)(2 * rn);
				b = 3;
			}
		}else {
			r1 = -rn*2;
			a = (int)r1;
			b = 1;
		}
		
		if(!checkEachRadius(r1, pegs)){
			return notQualified;
		}
		else 
		{
			return new int [] {a, b};
		}
	}
	
	public static boolean checkEachRadius (double r1, int [] pegs){
		double r, r_prev = r1;
		if (r1<1) return false;
		
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
