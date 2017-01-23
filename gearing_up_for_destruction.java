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
