/*    
Given a list of non-negative integers nums, arrange them such that they form the largest number.
Note: The result may be very large, so you need to return a string instead of an integer.
Example 1:
Input: nums = [10,2]
Output: "210"
Example 2:
Input: nums = [3,30,34,5,9]
Output: "9534330"
*/


package Java;
import java.util.*;


public class biggestNumber {
    static String largestNumber(List<Integer> l) {
		String[] arr = new String[l.size()];
		for(int i=0; i<l.size(); i++) {
			arr[i] = String.valueOf(l.get(i));
		}
		Arrays.sort(arr, new Comparator<String>(){
			public int compare(String a, String b) {
				return (a+b).compareTo(b+a);
			}
		});
		StringBuilder sb = new StringBuilder();
		for(String a : arr) {
			sb.append(a);
		}
		if(sb.charAt(0) == '0') {
			return String.valueOf(0);
		}
		
		return sb.toString();
		
	}
}
