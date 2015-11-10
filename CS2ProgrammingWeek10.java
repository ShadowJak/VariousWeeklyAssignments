// Adrian Melendez
// A1540936
// Week 10


import java.util.Scanner;

///////////////////////////////////////////
//
// Test frame for CS2 programming assignments
//   Created 12-10-2014 by Rick Leinecker
//
///////////////////////////////////////////

public class CS2ProgrammingWeek10
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
	
	//	Problem #1
	//	Given a string, count the number of words ending in 'y' 
	//	or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count, 
	//	but not the 'y' in "yellow" (not case sensitive). We'll say 
	//	that a y or z is at the end of a word if there is not an 
	//	alphabetic letter immediately following it. (Note: 
	//	Character.isLetter(char) tests if a char is an alphabetic letter.) 

	//	wordEndYZ("fez day") â†’ 2
	//	wordEndYZ("day fez") â†’ 2
	//	wordEndYZ("day fyyyz") â†’ 2
	
	/**
	 * 
	 * @param str
	 * 		str containing the original string
	 * 
	 * @return int
	 * 		int containing the # of words that end in y or z
	 */
	static int wordEndYZ(String str) {
		str = str.toLowerCase(); // Lower case for consistency
		int counter = 0; // Counter for the number of words ending in y or z
		int len = str.length();
		if (len == 0) { // Zero Length string obviously has 0 words
			return 0;
		}
		// Looking at last letter, if it is a y or z, increment counter
		if (str.charAt(len - 1) == 'y' || str.charAt(len - 1) == 'z') {
			counter++;
		}
		// Looping backwards looking for the ends of words and checking for y or z
		for (int i = str.length() - 1; i > 0; i--) {
			if (!Character.isLetter(str.charAt(i)) && (str.charAt(i-1) == 'y' || str.charAt(i-1) == 'z')) {
				counter++;
			}
		}
		
		return counter;
	}

	//	Problem #2
	//	Given two strings, base and remove, return a version of the base 
	//	string where all instances of the remove string have been removed 
	//	(not case sensitive). You may assume that the remove string is length 
	//	1 or more. Remove only non-overlapping instances, so with "xxx" 
	//	removing "xx" leaves "x".

	//	removeFromBase("Hello there", "llo") â†’ "He there"
	//	removeFromBase("Hello there", "e") â†’ "Hllo thr"
	//	removeFromBase("Hello there", "x") â†’ "Hello there"
	
	/**
	 * 
	 * @param base, remove
	 * 		base contains original string of characters
	 * 		remove contains original string that is to be removed from base
	 * 
	 * @return
	 * 		String containing the base with all instances of remove taken out
	 */
	static String removeFromBase(String base, String remove) {
		String lowerBase = base.toLowerCase(); // For consistency
		remove = remove.toLowerCase();
		
		int baseLen = base.length();
		int remLen = remove.length();
		int start = 0; // Index of the current letter in remove
		String result = ""; // Variable to hold the final answer
		
		for (int i = 0; i < baseLen; i++) {
			// Matching the characters in the base with the characters in remove.
			if (lowerBase.charAt(i) == remove.charAt(start) && baseLen - i + start >= remLen) {
				// If there is a match, check the next letter in start in the next iteration
				start++;
			} else {
				// If there isn't a match, add all the letters skipped until this point.
				for (int j = start; j >= 0; j--) {
					result = result + base.charAt(i - j);
				}
				// Resetting the start index
				start = 0;
			}
			// When the end of start is reached, reset it
			if (start == remLen) {
				start = 0;
			}
		}
		
		return result;
	}	

	//	Problem #3
	//	Given a string, return true if the number of appearances of 
	//	"is" anywhere in the string is equal to the number of appearances 
	//	of "not" anywhere in the string (case sensitive). 

	//	equalAppearance("This is not") â†’ false
	//	equalAppearance("This is notnot") â†’ true
	//	equalAppearance("noisxxnotyynotxisi") â†’ true
	
	/**
	 * 
	 * @param str
	 * 		str contains the original string of characters
	 * 
	 * @return
	 * 		returns true if "is" appears as many times as "not"
	 * 		returns false if "is" does not appear as many times as "not"
	 */
	static boolean equalAppearance(String str) {
		int isCounter = 0;
		int notCounter = 0;
		
		// substring makes this easy but need to make sure not to go out of bounds.
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.substring(i, i + 2).equals("is")) {
				isCounter++;
			}
		}
		
		for (int i = 0; i < str.length() - 2; i++) {
			if (str.substring(i, i + 3).equals("not")) {
				notCounter++;
			}
		}
		
		return (isCounter == notCounter);
	}	

	//	Problem #4
	//	We'll say that a lowercase 'g' in a string is "happy" if there 
	//	is another 'g' immediately to its left or right. Return true if 
	//	all the g's in the given string are happy. 

	//	gisHappy("xxggxx") â†’ true
	//	gisHappy("xxgxx") â†’ false
	//	gisHappy("xxggyygxx") â†’ false
	
	/**
	 * 
	 * @param str
	 * 		String containing original string of characters
	 * 
	 * @return
	 * 		returns true if 'g' appears with another 'g' to it's right or left
	 * 		returns false if this is not the case
	 */
	static boolean gisHappy(String str) {
		// If the length is exactly two, there need to be an even number of gs
		if (str.length() == 2) {
			int gCount = 0;
			for (char c : str.toCharArray()) {
				if (c == 'g') {
					gCount++;
				}
			}
			return (gCount != 1);
		// If the length is exactly 1, the string can't be g
		} else if (str.length() == 1) {
			return (!str.equals("g"));
		// No gs means no sad gs
		} else if (str.length() == 0) {
			return true;
		}
		
		// Looping over str, starting and ending before the beginning and end.
		for (int i = 1; i < str.length() - 1; i++) {
			if (str.charAt(i) == 'g') {
				// Needs at least one friend g
				if (str.charAt(i - 1) != 'g' && str.charAt(i + 1) != 'g'){
					return false;
				}
			}
		}
		
		return true;
	}
	
	//	Problem #5
	//	We'll say that a "triple" in a string is a char appearing three times in a row. 
	//	Return the number of triples in the given string. The triples may overlap. 

	//	numberOfTriples("abcXXXabc") â†’ 1
	//	numberOfTriples("xxxabyyyycd") â†’ 3
	//	numberOfTriples("a") â†’ 0	
	
	/**
	 * 
	 * @param str
	 * 		String containing the original string of characters
	 * 
	 * @return
	 * 		Integer containing the # of "triples" in str
	 */
	static int numberOfTriples(String str) {
		// Need at least length 3 for a triple
		if (str.length() < 3) { 
			return 0;
		}
		int counter = 0; // Counting the number of characters in a row
		int trips = 0; // Counting the total number of triples.
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				counter++;
			} else {
				counter = 0; // Reset the counter when a row is broken
			}
			if (counter > 1) {
				trips++; // As long as there are 3 or more in a row, increase the triples counter
			}
		}
		return trips;
	}
	
	//	Problem #6
	//	Given a string, return the sum of the digits 0-9 that appear in the 
	//	string, ignoring all other characters. Return 0 if there are no digits 
	//	in the string. (Note: Character.isDigit(char) tests if a char is one 
	//	of the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.) 

	//	addUpDigits("aa1bc2d3") â†’ 6
	//	addUpDigits("aa11b33") â†’ 8
	//	addUpDigits("Chocolate") â†’ 0
	
	/**
	 * 
	 * @param str
	 * 		String containing the original string of characters
	 * 
	 * @return 
	 * 		Integer containing the # sum of all digits that appear in str
	 */
	static int addUpDigits(String str) {
		if (str.length() == 0) {
			return 0;
		}
		int numVal = 0;
		int sum = 0;
		// Adding up the numerical digits. Are comments really necessary?
		for (int i = 0; i < str.length(); i++) {
			numVal = Character.getNumericValue(str.charAt(i));
			if (numVal > 0 && numVal < 10) {
				sum += numVal;
			}
		}
		return sum;
	}
	
	//	Problem #7
	//	Given a string, return the longest substring that appears at 
	//	both the beginning and end of the string without overlapping. 
	//	For example, beginningAndEndOfString("abXab") is "ab". 

	//	beginningAndEndOfString("abXYab") â†’ "ab"
	//	beginningAndEndOfString("xx") â†’ "x"
	//	beginningAndEndOfString("xxx") â†’ "x"
	
	/**
	 * 
	 * @param string
	 * 		String containing the original string of characters
	 * 
	 * @return 
	 * 		String containing the beginning and ending substrings that are the same
	 */
	static String beginningAndEndOfString(String str) {
		int len = str.length();
		if (len < 2) {
			return "";
		}
		String result = "";
		// Checking a substring of increasing size at the begining half of str with the 
		//   corresponding substring at the end of str.
		for (int i = 0; i < len/2; i++) {
			if (str.substring(0, i + 1).equals(str.substring(len - i - 1, len))) {
				result = str.substring(0, i + 1);
			}
		}
		
		return result;
	}
	
	//	Problem #8
	//	Given a string, look for a mirror image (backwards) string at both 
	//	the beginning and end of the given string. In other words, zero or more 
	//	characters at the very beginning of the given string, and at the very 
	//	end of the string in reverse order (possibly overlapping). For example, 
	//	the string "abXYZba" has the mirror end "ab". 

	//	beginningMirrorEnd("abXYZba") â†’ "ab"
	//	beginningMirrorEnd("abca") â†’ "a"
	//	beginningMirrorEnd("aba") â†’ "aba"
	
	/**
	 * 
	 * @param string
	 * 		String containing the original string of characters
	 * 
	 * @return 
	 * 		String containing the beginning of the string that is mirrored at the end
	 */
	static String beginningMirrorEnd(String str) {
		int len = str.length();
		String result = "";
		// This one is trivial. No comments needed. For real.
		for (int i = 0; i < len; i++) {
			if (str.charAt(i) == str.charAt(len - i - 1)) {
				result = result + str.charAt(i);
			} else {
				return result;
			}
		}
		
		return result;
	}
	
	//	Problem #9
	//	Given a string, return the length of the largest "block" in the string. 
	//	A block is a run of adjacent chars that are the same. 

	//	largestBlock("hoopla") â†’ 2
	//	largestBlock("abbCCCddBBBxx") â†’ 3
	//	largestBlock("") â†’ 0
	
	/**
	 * 
	 * @param str
	 * 		String containing the original string of characters
	 * 
	 * @return 
	 * 		Integer containing the # of chars in the largest "block" in str
	 */
	static int largestBlock(String str) {
		if (str.length() == 0) {
			return 0;
		}
		int max = 1; // Number of chars in the biggest block
		int counter = 1; // Temporarily counting the current block.
		
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				counter++;
				if (max < counter) {
					max = counter;
				}
			} else {
				counter = 1; // Resetting counter
			}
		}
		
		return max;
	}
	
	//	Problem #10
	//	Given a string, return the sum of the numbers appearing in the string, 
	//	ignoring all other characters. A number is a series of 1 or more digit 
	//	chars in a row. (Note: Character.isDigit(char) tests if a char is one 
	//	of the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.)

	//	addUpNumbers("abc123xyz") â†’ 123
	//	addUpNumbers("aa11b33") â†’ 44
	//	addUpNumbers("7 11") â†’ 18
	
	/**
	 * 
	 * @param str
	 * 		String containing the original string of characters
	 * 
	 * @return 
	 * 		Integer containing the sum of all the numbers that appear in str
	 */
	static int addUpNumbers(String str) {
		int len = str.length();
		if (len == 0) {
			return 0;
		}
		int result = 0; // The ultimate answer will be stored here
		int place = 0; // Tracking the place value of the number
		
		// Looping backwards. When a digit is found it is multiplied by the current place value, added to the result,
		//   and the place value is increased. Simple math is simple.
		for (int i = len - 1; i >= 0; i--) {
			if (Character.isDigit(str.charAt(i))) {
				result += (int) Math.pow(10, place) * Character.getNumericValue(str.charAt(i));
				place++;
			} else {
				place = 0; // Resetting the place value
			}
		}
		return result;
		
	}
	
	///////////////////////////////////////////
	//
	// End of assignment code.
	//
	///////////////////////////////////////////
	
	public static void main(String[] args) {
		
		
	}
	
}
