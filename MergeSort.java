import java.util.Arrays;

/**
 * An implementation of a merge sort algorithm
 * @author Christopher
 *
 */
public class MergeSort {

	public static void main(String[] args) {
  
	}
	
	/**
	 * Arrays to recursively iterate over until they are sorted
	 * @param array array to be sorted
	 * @return The merged array
	 */
	public int[] mergeSort(int[] array) {
		//Get the length of the array
		int length = array.length;
		//If at the end of splitting arrays and there only exists 1 or less item in this current array
		if (length <= 1) return array;
		//Otherwise split the arrays and copy their values
		int[] left = mergeSort(Arrays.copyOfRange(array, 0, length / 2));
		int[] right = mergeSort(Arrays.copyOfRange(array, length / 2, length));
		//Combine the two arrays into a larger array
		return merge(left, right);
	}
	
	/**
	 * Merge the two sorted arrays into one larger array
	 * @param left Half of the previous sorted array
	 * @param right Half of the previous sorted array
	 * @return sorted array
	 */
	public int[] merge(int[] left, int[] right) {
		//Get the length of both sub arrays
		int lengthLeft = left.length;
		int lengthRight = right.length;
		int totalLength = lengthLeft + lengthRight;
		//Set up new iterable variables to find the correct position in each array
		int iterableOne = 0;
		int iterableTwo = 0;
		//Create a new array to merge the sub arrays to
		int[] array = new int[totalLength];
		
		for (int i = 0; i < totalLength; i++) {
			//If at the end of the first sub array, only one value must exist in the last subarray
			if(iterableOne == lengthLeft) {
				//Write the last value to the array
				array[i] = right[iterableTwo++];
			}
			//If at the end of the second sub array, only one value must exist in the last subarray
			else if(iterableTwo == lengthRight) {
				//Write the last value to the array
				array[i] = left[iterableOne++];
			}
			//If not at the end of either sub array
			else {
				//Test if the value in the left array at the current position is less than the value
				//of the right arrays current position
				if(left[iterableOne] < right[iterableTwo]) {
					//Write the left position to the array
					array[i] = left[iterableOne++];
				}
				//Otherwise the value in the right subarray must be smaller than the  value in the left subarray
				else {
					array[i] = right[iterableTwo++];
				}
				
			}
		}	
		//Return the sorted array
		return array;
	}
}
