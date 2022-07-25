package arrays;
import java.util.Arrays;

/*
 * Write a function that takes in a sorted integer array and returns a sorted array
 * of the same length that contains the squared amount of the elements.
 * */

class SortedSquaredArray 
{
	  public static int[] sortedSquaredArray(int[] array) {
	    // Write your code here.
	    int[] sortedSquaredArr = new int[array.length];
	    for(int i = 0; i < array.length; i++)
	    {
	      sortedSquaredArr[i] = array[i] * array[i];
	    }

	    Arrays.sort(sortedSquaredArr); // In case any of the numbers was negative, the order needs to be corrected

	    return sortedSquaredArr;
	  }
	  
	  public static void main(String[] args) {
		int[] testArr = {-3,2,7};
		System.out.println(Arrays.toString(sortedSquaredArray(testArr)));
	  }
}