package edu.grinnell.csc207.lifengyuan.utils;

/**
 * CSC 207 Assignment 3
 * 
 * @author Fengyuan Li
 * @date Feb 5, 2014
 * 
 * Citation:
 * Testing case from online at:
 *http://www.cs.grinnell.edu/~rebelsky/Courses/CSC207/2014S/
 *assignments/assignment.03.html
 * The reference library for ArrayList from online at:
 * http://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html
 * I got idea from class discussion on Feb.5th for splitCSV.
 * I was pointed to use substring for java.lang.String class 
 * from Chenheli Hua for nameGame.
 * 
 * 
 */
import java.util.ArrayList;

public class StringUtils {

	/**
	 * splitAt takes a string str and a character c to use to split into an
	 * array of strings without symbol.
	 */
	public static String[] splitAt(String str, char c) {
		char[] charArray = str.toCharArray();
		String cur = "";
		// create a list of strings to turn into arrays
		ArrayList<String> split = new ArrayList<String>();

		for (int i = 0; i < str.length(); i++) {
			if (charArray[i] == c) {
				split.add(cur);
				cur = "";
			} else
				cur = cur + charArray[i];

		}
		split.add(cur); //add the end of sustring into the charArray.

		String[] strArray = (String[]) split.toArray(new String[split.size()]);
		//convert the charArray into a strArray

		return strArray;
	}// splitAt(String str, char c)

	/*
	 * splitCSV splits a string using those policies, with a comma as the
	 * separator.
	 */
	public static String[] splitCSV(String str) {
		char[] charArray = str.toCharArray();
		String cur = "";
		ArrayList<String> all = new ArrayList<String>();
		char separator = ',';
		int count = 0; // count to determine if we are already in the quotes

		for (int i = 0; i < str.length(); i++) {
			// When reach a quotation mark, combine two quotation marks to the
			// one
			if (charArray[i] == '"') {
				count = 1;
				i++;
				// If the next character is quote too
				if (charArray[i] == '"') {
					// If it is a double-quote, then reset count to 0 then move
					// on
					count = 0;
				}
				while (count == 1 && i < str.length()) {
					// If a quote was already established, end it
					if (charArray[i] == '"') {
						i++;
						// if there exist two quotation in one row, change it to
						// a character
						if (charArray[i] == '"') {
							cur = cur + charArray[i];
							i++;
						} else {
							count = 0;
						}
					} else {
						cur = cur + charArray[i];
						i++;
					}
				}
			}
			if (charArray[i] == separator) {
				// if the character at[i] is the separator without quotes
				// then separate the spring with quotation
				all.add(cur);
				cur = "";
			} else {
				// if the character at[i] is not a special character,
				// add it to the current string
				cur = cur + charArray[i];
			}
		}

		// add the final string
		all.add(cur);
		String[] strArray = (String[]) all.toArray(new String[all.size()]);

		return strArray;
	}// splitCSV

	/**
	 * deLeet takes as input a string of leet text and attempts to return the
	 * phrase in its more standard form. Translate the message to English within
	 * a while loop.
	 */
	public static String deLeet(String message) {
		char[] charArray = message.toCharArray();
		String cur = "";
		int i = 0;
		while (i < message.length()) {
			// check each character though following if statement
			// then change each leet text to corresponding letter.
			if (charArray[i] == '0') {
				cur = cur + "o";
				i++;
			} else if (charArray[i] == '+') {
				cur = cur + "t";
				i++;
			} else if (charArray[i] == '1') {
				cur = cur + "l";
				i++;
			} else if (charArray[i] == '3') {
				cur = cur + "e";
				i++;
			} else if (charArray[i] == '@') {
				cur = cur + "a";
				i++;
			} else if (charArray[i] == '|') {
				// Since "|" can be either b or n,
				// we need to continue to check with.
				if (charArray[i + 1] == '3') {
					cur = cur + "b";
					i += 2;
				} else if (charArray[i + 1] == '\\' && charArray[i + 2] == '|') {
					cur = cur + "n";
					i += 3;
				} else {
					cur = cur + "|";
					i++;
				}
			} else {
				// if there exist some text which cannot be recognized,
				// leave it as original
				cur = cur + charArray[i];
				i++;
			}
		}

		return cur;
	} // deLeet

	/**
	 * nameGame takes name as input a string and returns a verse of the form Ms.
	 * Ellis's "The Name Game".
	 */
	public static String nameGame(String name) {
		char[] nameArray = name.toCharArray();
		int position = 0;
		char check;
		int consonant = 1; // 1 is true, 0 is false
		// check if the [i] character in name is a vowel
		while (consonant == 1) {
			check = nameArray[position];
			if (check == 'a' || check == 'e' || check == 'i' || check == 'o'
					|| check == 'u' || check == 'y') {
				consonant = 0;
			} else {
				position++;
			}// else
		}// while

		String sub = name.substring(position); // take the name starting at
							// position

		// Finally, we create the verse
		String verse = name + "!\n" + name + ", " + name + " bo B" 
		               + sub + " Bonana fanna fo F" 
		               + sub + "\nFee fy mo M" 
		               + sub + ", " + name + "!";

		return verse;
	}// nameGame(String name)

}// stringUtils
