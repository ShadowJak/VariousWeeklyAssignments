// Adrian Melendez
// A1540936
// COP3503C-15Fall 0001
// Due Sep 16
// Week 3

import java.util.Scanner;

///////////////////////////////////////////
//
// Test frame for CS2 programming assignments
//   Created 12-10-2014 by Rick Leinecker
//
///////////////////////////////////////////

public class CS2ProgrammingWeek3 
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
	//	Given a string and a non-empty substring sub, compute recursively if at 
	//	least n copies of sub appear in the string somewhere, possibly with 
	//	overlapping. N will be non-negative.

	//	subCopies("catcowcat", "cat", 2) → true
	//	subCopies("catcowcat", "cow", 2) → false
	//	subCopies("catcowcat", "cow", 1) → true
	
	/**
	 * 
	 * @param str, sub, n
	 * 		String str contains the original string to be tested against
	 * 		String sub contains the string that is used to test against str
	 * 		int n specifies how many copies of sub to check for
	 * 
	 * @return
	 * 		returns true if there are n copies of sub in str
	 * 		returns false if there are not n copies of sub in str
	 */
	static boolean subCopies(String str, String sub, int n) 
	{
		// n will be counting down so when n hits 0, we know we have at least
		//   as many copies as the original n.
		if (n < 1) {
			return true;
		}
		
		// Until n is 0, we will be shrinking the original string. If str is
		//   shorter than the sub, obviously a match isn't possible anymore
		if (str.length() >= sub.length()) {
			// Looping over the first sub.length chars in str.
			for (int x = 0; x < sub.length(); x++) {
				// If at any point a character doesn't match its counterpart,
				//   cut off the first char of str and try again with the same n.
				if (str.charAt(x) != sub.charAt(x)) {
					return subCopies(str.substring(1), sub, n);
				// If all the chars in sub match up with the first chars in str,
				//   cut off the first char of str and try again with n - 1.
				// Reducing n here is how n may eventually be less than 1.
				} else if (x == sub.length() - 1) {
					return subCopies(str.substring(1), sub, n - 1);
				}
			}
		}
		
		// If this point is reached, n is still larger than 0 and str is smaller than sub.
		// Therefore, not enough matches were found and false is returned.
		return false;
	}

	//	Problem #2
	//	Given a non-negative int n, return the sum of its digits recursively 
	//	(no loops). Note that mod (%) by 10 yields the rightmost 
	//	digit (126 % 10 is 6), while divide (/) by 10 removes the 
	//	rightmost digit (126 / 10 is 12).

	//	sumDigitsInNumber(126) → 9
	//	sumDigitsInNumber(49) → 13
	//	sumDigitsInNumber(12) → 3
	
	/**
	 * 
	 * @param n
	 * 		int n contains integer to deal with.
	 * 
	 * @return integer
	 * 		integer that is the sum of each digit in int n.
	 */
	static int sumDigitsInNumber(int n) 
	{
		// n will be progressively reduced and added to previous results.
		// The program will eventually reach 0 and can't go below 0 so 0 will always be
		//   the last number added.
		if (n == 0) {
			return 0;
		}
		
		// n % 10 is the value of the ones digit. Dividing by 10 using integer math cuts off
		//   the current ones digit. Every time this method is called the ones digit is added
		//   to the total on the stack and dividing by 10 removes the ones digit and effectively
		//   shifts the other digits to the right by 1.
		return (n % 10) + sumDigitsInNumber(n / 10);
	}	

	//	Problem #3
	//	Given base and n that are both 1 or more, compute recursively (no loops) 
	//	the value of base to the n power, so powerN(3, 2) is 9 (3 squared).

	//	exponential(3, 1) → 3
	//	exponential(3, 2) → 9
	//	exponential(3, 3) → 27
	
	/**
	 * 
	 * @param base, n
	 * 		int base containing the base of the term
	 * 		int n containing the exponent of the term
	 * 
	 * @return integer
	 * 		integer that corresponds with equating base to the n power
	 */
	static int exponential(int base, int n) 
	{
		// n will be progressively reduced. Any number to the power of 0 equals 1.
		// 1 will always be the last number the value on the stack is multiplied by.
		if (n == 0) {
			return 1;
		}
		
		// The base will be multiplied against itself n times because every time this
		//   method is called, n will be reduced by 1 until it reaches 0 and then it
		//   will be multiplied by 1.
		return (base * exponential(base, n - 1));
	}	

	//	Problem #4
	//	Given a string, compute recursively (no loops) a new string 
	//	where all the lowercase 'x' chars have been changed to 'y' chars. 

	//	changeXtoY("codex") → "codey"
	//	changeXtoY("xxhixx") → "yyhiyy"
	//	changeXtoY("xhixhix") → "yhiyhiy"
	
	/**
	 * 
	 * @param str
	 * 		String containing original string of chars to deal with
	 * 
	 * @return String
	 * 		String of characters where the lowercase x's have been changed to y's
	 */
	public static String changeXtoY(String str) 
	{
		// The length of str will shrink until it is 0. At that point, the recursion will
		//   be done and an empty string will be added to the end of the string on the stack.
		if (str.length() == 0) {
			return "";
		}
		
		// If the first char of str is an x, a y will be returned with the results of this method
		//   on the rest of the string.
		if (str.charAt(0) == 'x') {
			return ("y" + changeXtoY(str.substring(1)));
		// Otherwise, that character will be returned with the results of this method
		//   on the rest of the string.
		} else {
			return (str.charAt(0) + changeXtoY(str.substring(1)));
		}
	}
	
	//	Problem #5
	//	Given an array of ints, compute recursively if the array 
	//	contains a 6. We'll use the convention of considering only 
	//	the part of the array that begins at the given index. 
	//	In this way, a recursive call can pass index+1 to move down 
	//	the array. The initial call will pass in index as 0. 

	//	find6({1, 6, 4}, 0) → true
	//	find6({1, 4}, 0) → false
	//	find6({6}, 0) → true	
	
	/**
	 * 
	 * @param nums, index
	 * 		int[] list containing the original array of numbers
	 * 		int containing the position to start in nums
	 * 
	 * @return boolean
	 * 		returns true if a 6 is found in the array
	 * 		returns false if no 6 is found in the array
	 */
	static boolean find6(int[] nums, int index) 
	{
		// index will be increased. When the index is out of bounds, that means
		//   a 6 was never found so false is returned.
		if (index >= nums.length) {
			return false;
		}
		
		// If a 6 is found at the current index, return true.
		if (nums[index] == 6) {
			return true;
		}
		
		// If a 6 wasn't found, call the method again on the next index.
		return find6(nums, index + 1);
	}
	
	//	Problem #6
	//	Given a string, compute recursively a new string where all 
	//	the adjacent chars are now separated by a "*".   

	//	insertAsterisk("hello") → "h*e*l*l*o"
	//	insertAsterisk("abc") → "a*b*c"
	//	insertAsterisk("ab") → "a*b"
	
	/**
	 * 
	 * @param str
	 * 		String containing the original chars
	 * 
	 * @return AbridgedList
	 * 		String with an asterisk between each char
	 */
	static String insertAsterisk(String str) 
	{
		// When the last letter is reached, an asterisk isn't added and the recursion is done.
		if (str.length() <= 1) {
			return str;
		} else {
			// If the last letter has not been reached, return the current letter, an asterisk,
			//   and the results of calling this method again with the first character of str removed.
			return (str.charAt(0) + "*" + insertAsterisk(str.substring(1)));
		}
	}
	
	//	Problem #7
	//	We'll say that a "pair" in a string is two instances of 
	//	a char separated by a char. So "AxA" the A's make a pair. 
	//	Pair's can overlap, so "AxAxA" contains 3 pairs -- 2 for 
	//	A and 1 for x. Recursively compute the number of 
	//	pairs in the given string.  

	//	numberPairs("axa") → 1
	//	numberPairs("axax") → 2
	//	numberPairs("axbx") → 1
	
	/**
	 * 
	 * @param str
	 * 		String containing the original chars provided
	 * 
	 * @return 
	 * 		int with the number of pairs as defined above
	 */
	static int numberPairs(String str) 
	{
		// When the str has a length less than 3, no more pairs can be found.
		if (str.length() < 3) {
			return 0;
		}
		
		// If a pair is found, return 1 plus the result of this method being called
		//   with the first letter in str removed.
		if (str.charAt(0) == str.charAt(2)) {
			return (1 + numberPairs(str.substring(1)));
		// Otherwise, return 0 + the result of this method being called with the first
		//   letter in str removed.
		} else {
			return (0 + numberPairs(str.substring(1)));
		}
	}
	
	//	Problem #8
	//	Given a string, return recursively a "cleaned" string where 
	//	adjacent chars that are the same have been reduced 
	//	to a single char. So "yyzzza" yields "yza".  

	//	reduceChars("yyzzza") → "yza"
	//	reduceChars("abbbcdd") → "abcd"
	//	reduceChars("Hello") → "Helo"
	
	/**
	 * 
	 * @param str
	 * 		String containing the original chars
	 * 
	 * @return 
	 * 		String with all repeated, adjacent chars are removed
	 */
	static String reduceChars(String str) 
	{
		// A string with only 1 char can't have adjacent characters matching anything.
		// Therefore, str can be returned.
		if (str.length() < 2) {
			return str;
		}
		
		// If the first two characters match, remove the first char and try again.
		if (str.charAt(0) == str.charAt(1)) {
			return reduceChars(str.substring(1));
		// Otherwise, those chars don't match so the first one can be returned along with the
		//   results of this method called on the rest of the string.
		} else {
			return (str.charAt(0) + reduceChars(str.substring(1)));
		}
	}
	
	//	Problem #9
	//	Given a string, return true if it is a nesting of zero or more 
	//	pairs of parenthesis, like "(())" or "((()))". Suggestion: 
	//	check the first and last chars, and then recur on what's inside them.  

	//	nestedParens("(())") → true
	//	nestedParens("((()))") → true
	//	nestedParens("(((x))") → false
	
	/**
	 * 
	 * @param str
	 * 		String containing the original chars
	 * 
	 * @return 
	 * 		returns true if there are zero or more pairs of parenthesis
	 * 		returns false if there are not zero or more pairs of parenthesis
	 */
	static boolean nestedParens(String str) 
	{
		// If str.len is 0 then it is a nesting of 0 parenthesis
		if (str.length() == 0) {
			return true;
		// If the length is odd, it obviously can't be a nesting even if it is symmetrical.
		} else if (str.length() % 2 != 0) {
			return false;
		}
		
		// If the first and last chars are ( and ), call this method on the remaining part
		//   of the string. Eventually the str will be size 0.
		if (str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')') {
			return nestedParens(str.substring(1, str.length() - 1));
		// Otherwise, it isn't a nesting of ()
		} else {
			return false;
		}
	}
	
	//	Problem #10

	//	Given a string and a non-empty substring sub, compute 
	//	recursively the largest substring which starts and 
	//	ends with sub and return its length.  

	//	subStrSub("catcowcat", "cat") → 9
	//	subStrSub("catcowcat", "cow") → 3
	//	subStrSub("cccatcowcatxx", "cat") → 9
	
	/**
	 * 
	 * @param str, sub
	 * 		String containing the original chars to be tested against
	 * 		String containing the original chars to test with
	 * 
	 * @return 
	 * 		integer containing the largest number of chars in string 
	 * 		that start and end with sub
	 */
	static int subStrSub(String str, String sub) 
	{
		// If str is smaller than sub, it isn't possible for sub to be in str.
		// Therefore, the size of the largest relevant substring will be 0.
		if (str.length() < sub.length()) {
			return 0;
		}
		
		// Iterating over each letter in the sub string from front to back and back to front and
		//   comparing those letters with the first and last letters in str.
		for (int x = 0; x < sub.length(); x++) {
			// If both the first and last parts of str are wrong, try again by removing the first and last letter.
			if (str.charAt(x) != sub.charAt(x) && 
			str.charAt(str.length() - 1 - x) != sub.charAt(sub.length() - 1 - x)) {
				if (str.length() > 1) {
					return subStrSub(str.substring(1, str.length() - 1), sub);
				} else {
					return 0;
				}
			// If only the first part is wrong, remove the first letter and try again.
			} else if (str.charAt(x) != sub.charAt(x)) {
				return subStrSub(str.substring(1), sub);
			// If only the last part is wrong, remove the last letter and try again.
			} else if (str.charAt(str.length() - 1 - x) != sub.charAt(sub.length() - 1 - x)) {
				return subStrSub(str.substring(0, str.length() - 1), sub);
			}
		}
		
		// If all the letters are correct in both the front and back, return the length of str.
		return str.length();
	}
	
	///////////////////////////////////////////
	//
	// End of assignment code.
	//
	///////////////////////////////////////////
	
	public static void main(String[] args)
	{
		// 1
		//	subCopies("catcowcat", "cat", 2) → true
		//	subCopies("catcowcat", "cow", 2) → false
		//	subCopies("catcowcat", "cow", 1) → true
		
		System.out.println("#1");
		System.out.println(subCopies("catcowcat", "cat", 2));
		System.out.println(subCopies("catcowcat", "cow", 2));
		System.out.println(subCopies("catcowcat", "cow", 1));
		System.out.println();
		
		// 2
		//	sumDigitsInNumber(126) → 9
		//	sumDigitsInNumber(49) → 13
		//	sumDigitsInNumber(12) → 3
		
		System.out.println("#2");
		System.out.println(sumDigitsInNumber(126));
		System.out.println(sumDigitsInNumber(49));
		System.out.println(sumDigitsInNumber(12));
		System.out.println();
		
		// 3
		//	exponential(3, 1) → 3
		//	exponential(3, 2) → 9
		//	exponential(3, 3) → 27
		
		System.out.println("#3");
		System.out.println(exponential(3, 1));
		System.out.println(exponential(3, 2));
		System.out.println(exponential(3, 3));
		System.out.println();
		
		// 4
		//	changeXtoY("codex") → "codey"
		//	changeXtoY("xxhixx") → "yyhiyy"
		//	changeXtoY("xhixhix") → "yhiyhiy"
		
		System.out.println("#4");
		System.out.println(changeXtoY("codex"));
		System.out.println(changeXtoY("xxhixx"));
		System.out.println(changeXtoY("xhixhix"));
		System.out.println();
		
		// 5
		//	find6({1, 6, 4}, 0) → true
		//	find6({1, 4}, 0) → false
		//	find6({6}, 0) → true
		
		System.out.println("#5");
		System.out.println(find6(new int[] {1, 6, 4}, 0));
		System.out.println(find6(new int[] {1, 4}, 0));
		System.out.println(find6(new int[] {6}, 0));
		System.out.println();
		
		// 6
		//	insertAsterisk("hello") → "h*e*l*l*o"
		//	insertAsterisk("abc") → "a*b*c"
		//	insertAsterisk("ab") → "a*b"
		
		System.out.println("#6");
		System.out.println(insertAsterisk("hello"));
		System.out.println(insertAsterisk("abc"));
		System.out.println(insertAsterisk("ab"));
		System.out.println();
		
		// 7
		//	numberPairs("axa") → 1
		//	numberPairs("axax") → 2
		//	numberPairs("axbx") → 1
		
		System.out.println("#7");
		System.out.println(numberPairs("axa"));
		System.out.println(numberPairs("axax"));
		System.out.println(numberPairs("axbx"));
		System.out.println();
		
		// 8
		//	reduceChars("yyzzza") → "yza"
		//	reduceChars("abbbcdd") → "abcd"
		//	reduceChars("Hello") → "Helo"
		
		System.out.println("#8");
		System.out.println(reduceChars("yyzzza"));
		System.out.println(reduceChars("abbbcdd"));
		System.out.println(reduceChars("Hello"));
		System.out.println();
		
		// 9
		//	nestedParens("(())") → true
		//	nestedParens("((()))") → true
		//	nestedParens("(((x))") → false
		
		System.out.println("#9");
		System.out.println(nestedParens("(())"));
		System.out.println(nestedParens("((()))"));
		System.out.println(nestedParens("(((x))"));
		System.out.println();
		
		// 10
		//	subStrSub("catcowcat", "cat") → 9
		//	subStrSub("catcowcat", "cow") → 3
		//	subStrSub("cccatcowcatxx", "cat") → 9
		
		System.out.println("#10");
		System.out.println(subStrSub("xyx", "z"));
		System.out.println(subStrSub("catcowcat", "cow"));
		System.out.println(subStrSub("cccatcowcatxx", "cat"));
		System.out.println();
		
	}
	
}
