package foo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class minion_labor_shifts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] data = {5, 10, 15, 10, 7};
		int n = 2;
		System.out.println(Arrays.toString(answer1(data, n)));
	}
	
	public static int[] answer1(int [] data, int n){
		if (data.length == 0)
			return data;
		if (n <= 0)
			return new int [] {};
		
		List<Integer> resultList = new ArrayList<Integer> ();
		
		Map<Integer, Integer> dataMap = new HashMap();
		for (int i=0;i<data.length;i++){
			resultList.add(data[i]);
			if(!dataMap.containsKey(data[i])){
				dataMap.put(data[i], 1);
			}else {
				int count = dataMap.get(data[i]) + 1;
				dataMap.put(data[i], count);
			}
		}

		for(int i=0;i<resultList.size();i++){
			if(dataMap.get(resultList.get(i)) >n){
				resultList.remove(i);
				i--;
			}
		}
		
		int [] result = new int [resultList.size()];
		for(int i=0;i<result.length;i++){
			result[i] = resultList.get(i);
		}
		return result;
	}
}
