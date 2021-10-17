/*


Given an unsorted array of size n. Array elements are in the range from 1 to n. 
One number from set {1, 2, …n} is missing and one number occurs twice in the array.
Find these two numbers.

*/

class Solution {
    static int[] findMissingAndRepeating(int[] arr) {
		int res[] = new int[2];
		for(int i=0; i<arr.length; i++) {
			int abs_val = Math.abs(arr[i]);
			if(arr[abs_val - 1] > 0) {
				arr[abs_val-1] = -arr[abs_val-1];
			}
			else {
				res[0] = abs_val;
			}
			
		}
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > 0)
				res[1] = i+1;
		}
		return res;
	}
}