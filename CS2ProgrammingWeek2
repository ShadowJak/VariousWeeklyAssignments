// Adrian Melendez
// A1540936
// COP3503C-15Fall 0001
// Due Sep 9
// Week 2

import java.util.Arrays;
import java.util.Scanner;

///////////////////////////////////////////
//
// Test frame for CS2 programming assignments
//   Created 12-10-2014 by Rick Leinecker
//
///////////////////////////////////////////

public class CS2ProgrammingWeek2 
{
	
	///////////////////////////////////////////
	//
	// Start of assignment code.
	//
	///////////////////////////////////////////
	
	/**
	 * Returns the last name, first name, and PID of the student.
	 * 
	 * This is required in order to get credit for the programming assignment.
	 */
	static String GetNameAndPID()
	{
		return( "Melendez, Adrian, A1540936");
	}
	
	//	Problem #1
	// Directions: Return true if the array contains, somewhere,
	// three increasing consecutive numbers like ....4, 5, 6,... or
	// 23, 24, 25.

	//	FindThreeIncreasingNumbers({1, 4, 5, 6, 2}) â†’ true
	//	FindThreeIncreasingNumbers({1, 2, 3}) â†’ true
	//	FindThreeIncreasingNumbers({1, 2, 4}) â†’ false
	
	/**
	 * 
	 * @param NumberList
	 * 		int[] list containing some numbers.
	 * 
	 * @return
	 * 		returns true if there are three increasing consecutive numbers
	 * 		returns false if there are not three increasing consecutive numbers
	 */
	static boolean FindThreeIncreasingNumbers(int[] NumberList) 
	{
		// counter to keep track of numbers
		int c = 1;
		
		// Iterating over the list. Stops 1 before the end to avoid out of bounds issues.
		for (int x = 0; x < NumberList.length - 1; x++) {
			// if the next number is 1 bigger, increase the counter by 1
			if (NumberList[x+1] == (NumberList[x] + 1)) {
				c++;
			// Otherwise, reset the counter.
			} else {
				c = 1;
			}
			// If the counter is big enough, return true.
			if (c > 2) {
				return true;
			}
		}
		
		// If the above loop finishes without returning true, three consecutive, increasing ints were not found.
		return false;
	}

	//	Problem #2
	//	For each multiple of 10 in the given array, change all the values 
	//	following it to be that multiple of 10, until encountering another 
	//	multiple of 10. So {2, 10, 3, 4, 20, 5} yields {2, 10, 10, 10, 20, 20}.

	//	multiplesOfTen({2, 10, 3, 4, 20, 5}) â†’ {2, 10, 10, 10, 20, 20}
	//	multiplesOfTen({10, 1, 20, 2}) â†’ {10, 10, 20, 20}
	//	multiplesOfTen({10, 1, 9, 20}) â†’ {10, 10, 10, 20}
	
	/**
	 * 
	 * @param NumberList
	 * 		int[] list containing some numbers.
	 * 
	 * @return NumberList
	 * 		int[] list of the same numbers changed to multiples of
	 * 		ten as they are encountered.
	 */
	static int[] multiplesOfTen(int[] NumberList) 
	{
		// Variable to track the current mult of 10
		int currentTen = -1;
		
		// Variable to track when the first mult of 10 has been found
		boolean tensOn = false;
		
		// Simple loop over the array
		for (int x = 0; x < NumberList.length; x++) {
			// If the value is a mult of 10, set currentTen to that number
			//   and set tensOn to true
			if (NumberList[x] % 10 == 0) {
				currentTen = NumberList[x];
				tensOn = true;
			// Otherwise, if tensOn is true, change the value to currentTen
			} else if (tensOn) {
				NumberList[x] = currentTen;
			}
		}
		
		// Return the updated array
		return NumberList;
	}	

	//	Problem #3
	//	We'll say that an element in an array is "alone" if there are 
	//	values before and after it, and those values are different 
	//	from it. Return a version of the given array where every instance 
	//	of the given value which is alone is replaced by whichever 
	//	value to its left or right is larger.

	//	CheckForAloneNumbers({1, 2, 3}, 2) â†’ {1, 3, 3}
	//	CheckForAloneNumbers({1, 2, 3, 2, 5, 2}, 2) â†’ {1, 3, 3, 5, 5, 2}
	//	CheckForAloneNumbers({3, 4}, 3) â†’ {3, 4}
	
	/**
	 * 
	 * @param NumberList, changingNumber
	 * 		int[] list containing some numbers.
	 * 		int value of the number that should change in the array.
	 * 
	 * @return NumberList
	 * 		int[] list of numbers where every occurrence of changingNumber
	 * 		has been replaced by the larger of its two neighbors.
	 */
	static int[] CheckForAloneNumbers(int[] NumberList, int changingNumber) 
	{
		// Loop over the list. Start and end an index after and before start and end to avoid
		//   out of bounds problems.
		for (int x = 1; x < NumberList.length - 1; x++) {
			if (NumberList[x] == changingNumber) {
				// Checking the numbers before and after the current number
				//   If both are different, replace the current number with the higher of the surrounding numbers.
				if (NumberList[x-1] != changingNumber && NumberList[x+1] != changingNumber) {
					NumberList[x] = Math.max(NumberList[x-1], NumberList[x+1]);
				}
			}
		}
		
		// Return the updated array.
		return NumberList;
	}	

	//	Problem #4
	//	Return a version of the given array where each zero value in 
	//	the array is replaced by the largest odd value to the right 
	//	of the zero in the array. If there is no odd value to the 
	//	right of the zero, leave the zero as a zero. 

	//	ReplaceZerosWithLargestOdd({0, 5, 0, 3}) â†’ {5, 5, 3, 3}
	//	ReplaceZerosWithLargestOdd({0, 4, 0, 3}) â†’ {3, 4, 3, 3}
	//	ReplaceZerosWithLargestOdd({0, 1, 0}) â†’ {1, 1, 0}
	
	/**
	 * 
	 * @param NumberList
	 * 		int[] list containing some numbers.
	 * 
	 * @return NumberList
	 * 		int[] list containing the numbers where the zeros have been
	 * 		replaced with the largest odd number to the right of them.
	 */
	public static int[] ReplaceZerosWithLargestOdd(int[] NumberList) 
	{
		// Variable to keep track of the current highest odd number
		int maxOdd = 0;
		// Loop over the list backwards because the logic is easier
		for (int x = NumberList.length - 1; x >= 0; x--) {
			// If 0, replace with maxOdd. If no odds have been found yet, 0 will be used anyway
			if (NumberList[x] == 0) {
				NumberList[x] = maxOdd;
			// If the current number is odd and bigger than maxOdd, make maxOdd the number
			} else if (NumberList[x] % 2 == 1 && maxOdd < NumberList[x]) {
				maxOdd = NumberList[x];
			}
		}
		// Return the updated array
		return NumberList;
	}
	
	//	Problem #5
	//	Given start and end numbers, return a new array containing 
	//	the sequence of integers from start up to but not including end, 
	//	so start=5 and end=10 yields {5, 6, 7, 8, 9}. The end number 
	//	will be greater or equal to the start number. 
	//	Note that a length-0 array is valid. 

	//	CreateIncreasingArray(5, 10) â†’ {5, 6, 7, 8, 9}
	//	CreateIncreasingArray(11, 18) â†’ {11, 12, 13, 14, 15, 16, 17}
	//	CreateIncreasingArray(1, 3) â†’ {1, 2}	
	
	/**
	 * 
	 * @param start, end
	 * 		Two integers stating the start and end of the sequence.
	 * 
	 * @return NumberList
	 * 		int [] containg numbers ranging from start to end
	 * 		in order from least to greatest.
	 */
	static int[] CreateIncreasingArray(int start, int end) 
	{
		// Variable for the size of the loop and array
		int n = end - start;
		// The array we will be returning 
		int[] temp = new int[n];
		
		// Loop to populate the array. Start is incremented each time
		for (int x = 0; x < n; x++) {
			temp[x] = start++;
		}
		
		// Return the array
		return temp;
	}
	
	//	Problem #6
	//	Given a non-empty array of ints, return a new array containing 
	//	the elements from the original array that come before the 
	//	first 4 in the original array. The original array will contain 
	//	at least one 4. Note that it is valid in java to create 
	//	an array of length 0.  

	//	CopyNumbersBeforeFour({1, 2, 4, 1}) â†’ {1, 2}
	//	CopyNumbersBeforeFour({3, 1, 4}) â†’ {3, 1}
	//	CopyNumbersBeforeFour({1, 4, 4}) â†’ {1}
	
	/**
	 * 
	 * @param NumberList
	 * 		int[] list containing some numbers.
	 * 
	 * @return AbridgedList
	 * 		int[] list containing all the numbers that appeared
	 * 		before the first 4 in the array.
	 */
	static int[] CopyNumbersBeforeFour(int[] NumberList) 
	{
		// Variable for the array to be returned
		int[] temp;
		// Loop until a 4 is found
		for (int x = 0; x < NumberList.length; x++) {
			// When a 4 is found, make a copy of the start of NumberList until the index of the 4
			if (NumberList[x] == 4) {
				temp = Arrays.copyOf(NumberList, x);
				return temp;
			}
		}
		
		// If no 4 was found, return a 0 length array.
		temp = new int[0];
		return temp;
	}
	
	//	Problem #7
	//	Return an array that contains the exact same numbers as 
	//	the given array, but rearranged so that all the zeros 
	//	are grouped at the start of the array. The order of the 
	//	non-zero numbers does not matter. So {1, 0, 0, 1} becomes 
	//	{0 ,0, 1, 1}. You may modify and return the 
	//	given array or make a new array.  

	//	MoveZerosToFront({1, 0, 0, 1}) â†’ {0, 0, 1, 1}
	//	MoveZerosToFront({0, 1, 1, 0, 1}) â†’ {0, 0, 1, 1, 1}
	//	MoveZerosToFront({1, 0}) â†’ {0, 1}
	
	/**
	 * 
	 * @param NumberList
	 * 		int[] list containing some numbers.
	 * 
	 * @return RearrangedList
	 * 		int[] list containing all the numbers from original
	 * 		list with the zeros moved to the front.
	 */
	static int[] MoveZerosToFront(int[] NumberList) 
	{
		// Variable to store the pivot
		int p = 0;
		// Loop over the array looking for Zeros
		for (int x = 0; x < NumberList.length; x++) {
			// If 0, swap to the pivot and increment the pivot.
			if (NumberList[x] == 0) {
				int temp = NumberList[p];
				NumberList[p] = NumberList[x];
				NumberList[x] = temp;
				p++;
			}
		}
		// Return the array
		return NumberList;
	}
	
	//	Problem #8
	//	Return an array that contains the exact same numbers as 
	//	the given array, but rearranged so that all the even numbers 
	//	come before all the odd numbers. Other than that, the 
	//	numbers can be in any order. You may modify and 
	//	return the given array, or make a new array.  

	//	EvenFrontOddBack({1, 0, 1, 0, 0, 1, 1}) â†’ {0, 0, 0, 1, 1, 1, 1}
	//	EvenFrontOddBack({3, 3, 2}) â†’ {2, 3, 3}
	//	EvenFrontOddBack({2, 2, 2}) â†’ {2, 2, 2}
	
	/**
	 * 
	 * @param NumberList
	 * 		int[] list containing some numbers.
	 * 
	 * @return RearrangedList
	 * 		int[] list containing all the numbers from original
	 * 		list with the even numbers in the front and the
	 * 		odd numbers in the back.
	 */
	static int[] EvenFrontOddBack(int[] NumberList) 
	{
		// Variable to store the pivot
		int p = 0;
		// Loop over the array looking for Evens
		for (int x = 0; x < NumberList.length; x++) {
			// If even, swap to the pivot and increment the pivot.
			if (NumberList[x] % 2 == 0) {
				int temp = NumberList[p];
				NumberList[p] = NumberList[x];
				NumberList[x] = temp;
				p++;
			}
		}
		// Return the array
		return NumberList;
	}
	
	///////////////////////////////////////////
	//
	// End of assignment code.
	//
	///////////////////////////////////////////
	
	public static void main(String[] args)
	{
		
		
	}
	
}
