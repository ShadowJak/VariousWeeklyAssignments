// Adrian Melendez
// A1540936
// Week 1

import java.util.Scanner;

///////////////////////////////////////////
//
// Test frame for CS2 programming assignments
//   Created 12-10-2014 by Rick Leinecker
//
///////////////////////////////////////////

public class CS2ProgrammingWeek1 
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
		return("Melendez, Adrian, A1540936");
	}

	// Directions: Return the number of even ints in the given 
	// array (The number '0' counts as an even number). 
	// Note: the % "mod" operator computes the remainder, 
	// e.g. 5 % 2 is 1. 

	// CountEvenNumbersInArray({2, 1, 2, 3, 4}) → 3
	// CountEvenNumbersInArray({2, 2, 0}) → 3
	// CountEvenNumbersInArray({1, 3, 5}) → 0
	
	/**
	 * 
	 * @param NumberList
	 * 		int[] list containing some numbers.
	 * 
	 * @return
	 * 		int with the number of even numbers in NumberList
	 */
	static int CountEvenNumbersInArray(int[] NumberList) 
	{
		// Variable to count number of evens. Starts at 0.
		int evenCounter = 0;
		
		// For Each loop using modulus operation to test for evenness and increment the counter
		for (int x : NumberList)
		{
			if (x % 2 == 0)
			{
				evenCounter++;
			}
		}
		return evenCounter;
	}

	// Given an array of ints, return true if the array contains no 
	//   1's and no 3's.

	// LookForLucky13({0, 2, 4}) → true
	// LookForLucky13({1, 2, 3}) → false
	// LookForLucky13({1, 2, 4}) → false
	
	/**
	 * 
	 * @param NumberList
	 * 		int[] list containing some numbers.
	 * 
	 * @return
	 * 		returns false if there is a 1 or 3 in the list.
	 * 		returns true if there are no 1s or 3s in the list.
	 */
	static boolean LookForLucky13(int[] NumberList) 
	{
		// For Each loop to iterate over the array
		//   As soon as a 1 or 3 is found, returns false.
		for (int x : NumberList) {
			if (x == 1 || x == 3) {
				return false;
			}
		}
		// If no 1s or 3s were found, true is returned.
		return true;
	}	

	// Given arrays NumberList1 and NumberList2 of the same length, 
	//   for every element in NumberList1, consider the 
	//   corresponding element in NumberList2 (at the same index). 
	//   Return the count of the number of times that the two 
	//   elements differ by 2 or less, but are not equal. 

	// MatchUpLists({1, 2, 3}, {2, 3, 10}) → 2
	// MatchUpLists({1, 2, 3}, {2, 3, 5}) → 3
	// MatchUpLists({1, 2, 3}, {2, 3, 3}) → 2
	
	static int MatchUpLists(int[] NumberList1, int[] NumberList2) 
	{
		// Variable to count the number of matches. Starts at 0.
		int matchCounter = 0;
		
		// Variable to store the length of the array
		int arrayLength = NumberList1.length;
		
		// Loops over the arrays and increments the counter when there is a match.
		for (int x = 0; x < arrayLength; x++) {
			// Variable to store the difference
			int diff = NumberList1[x] - NumberList2[x];
			// Verifying Matching
			if (diff >= -2 && diff <= 2 && diff != 0) {
				matchCounter++;
			}
		}
		return matchCounter;
	}	

	// Given an array of ints, return true if the array 
	//   contains either 3 even or 3 odd values all next 
	//   to each other. 

	// ModThreeNumbers({2, 1, 3, 5}) → true
	// ModThreeNumbers({2, 1, 2, 5}) → false
	// ModThreeNumbers({2, 4, 2, 5}) → true
	
	/**
	 * 
	 * @param NumberList
	 * 		int[] list containing some numbers.
	 * 
	 * @return
	 * 		return true if there are three consecutive events
	 * 			or three consecutive odds
	 * 
	 * 		otherwise returns false
	 */
	public static boolean ModThreeNumbers(int[] NumberList) 
	{
		// Counters for consecutive even and odd integers
		int evenCounter = 0;
		int oddCounter = 0;
		
		// For Each loop on the array
		for (int x : NumberList) {
			// When integer is even, increments the even counter and resets the
			//   odd counter to 0 because the streak of odds was broken. 
			//   Vice versa for odd numbers.
			if (x % 2 == 0) {
				evenCounter++;
				oddCounter = 0;
			} else {
				evenCounter = 0;
				oddCounter++;
			}
			// When the counter reaches 3 for either evens or odds, returns true
			if (evenCounter > 2 || oddCounter > 2) {
				return true;
			}
		}
		// If there was never a streak of 3 or more, returns false
		return false;
		
	}

	// Return the "centered" average of an array of ints, 
	//   which we'll say is the mean average of the values, 
	//   except ignoring the largest and smallest values in 
	//   the array. If there are multiple copies of the 
	//   smallest value, ignore just one copy, and likewise 
	//   for the largest value. Use int division to produce 
	//   the final average. You may assume that the array is 
	//   length 3 or more. 

	// FindCenteredAverage({1, 2, 3, 4, 100}) → 3
	// FindCenteredAverage({1, 1, 5, 5, 10, 8, 7}) → 5
	// FindCenteredAverage({-10, -4, -2, -4, -2, 0}) → -3	
	
	/**
	 * 
	 * @param NumberList
	 * 		int[] list containing some numbers.
	 * 
	 * @return
	 * 		Average of the list of numbers without the
	 * 		first of the lowest numbers and the last of the
	 * 		highest numbers.
	 */
	static int FindCenteredAverage(int[] NumberList) 
	{
		// Variables for the largest and smallest values in the array.
		//   Initialized to the first value in the array.
		int minInt = NumberList[0];
		int maxInt = NumberList[0];
		
		// Variable to store the sum of all the values in the array
		int total = 0;
		
		// For Each loop to find the min and max values and also sum all values
		for (int x : NumberList) {
			if (minInt > x) {
				minInt = x;
			}
			if (maxInt < x) {
				maxInt = x;
			}
			total += x;
		}
		// Simple Math to return value. Removes the high and low values and divides by the number of remaining ints
		return ((total - minInt - maxInt)/(NumberList.length - 2));
	}
	
	// Given an array of ints, return true if every 2 that 
	//   appears in the array is next to another 2. 

	// LookForTwoTwo({4, 2, 2, 3}) → true
	// LookForTwoTwo({2, 2, 4}) → true
	// LookForTwoTwo({2, 2, 4, 2}) → false
	
	/**
	 * 
	 * @param NumberList
	 * 		int[] list containing some numbers.
	 * 
	 * @return
	 * 		true if every 2 is adjacent to another 2
	 * 		otherwise false
	 */
	static boolean LookForTwoTwo(int[] NumberList) 
	{
		// Variable to store the length of the array
		int len = NumberList.length;
		
		// Variable to store if a 2 was found at all
		boolean foundTwo = false;
		
		// Variables to store if a 2 was found before or after the current index in the array
		boolean beforeTwo = false;
		boolean afterTwo = false;
		
		// Loop over the array looking for 2s
		for (int x = 0; x < len; x++) {
			// When a 2 is found, sets foundTwo to true and then looks for 2s before and after
			//   Simple math added to make sure the program stays in bounds.
			if (NumberList[x] == 2) {
				foundTwo = true;
				if (x - 1 >= 0) {
					if (NumberList[x - 1] == 2) {
						beforeTwo = true;
					}
				}
				if (x + 1 < len) {
					if (NumberList[x + 1] == 2) {
						afterTwo = true;
						x++;
					}
				}
				// As long as there is a 2 before or after the current 2, we are good to go
				//   Otherwise, returns false
				if (!(beforeTwo || afterTwo)) {
					return false;
				}
				// Reset the before and after booleans to be used for the next index
				beforeTwo = false;
				afterTwo = false;
			}
		}
		// When the above loop is done, return the value of foundTwo.
		//   If a two was found and the above loop didn't return false, then everything was ok
		//   and we return true. If there was no two in the array at all, the above loop would still
		//   complete but the foundTwo variable would never have been set to true so false gets returned
		//   because there were no twos to be next to each other.
		return foundTwo;
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
