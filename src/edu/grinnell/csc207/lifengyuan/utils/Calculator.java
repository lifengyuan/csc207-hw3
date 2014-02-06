package edu.grinnell.csc207.lifengyuan.utils;

/**
 * Citation:
 * The reference library for BigInteger from online at:
 * http://docs.oracle.com/javase/7/docs/api/java/util/BigInteger.html
 * The use of ArithmeticException and IllegalArgumentException for 
 * http://docs.oracle.com/javase/6/docs/api/java/math/BigDecimal.html
 * #divide%28java.math.BigDecimal%29
 * I got point for the BigInteger class from Earnest Wheeler for eva10.
 * Testing case from online at:
 *http://www.cs.grinnell.edu/~rebelsky/Courses/CSC207/2014S/
 *assignments/assignment.03.html
 */

import java.math.BigInteger;

public class Calculator {

	/*
	 * The string input must be formatted as below, and must begin with a
	 * number(integer). It will returns a calculation of all the terms and given
	 * operations. Only allow to do "+,-,*,/,^" Format :[int] [operation] [int]
	 * [operator] ...[int]
	 */
	public static BigInteger eval0(String input) {
		
		// Initialize the string by the procedure splitAt first to a new string only has
		//numbers and operation without whitespace.
		String[] strArray = StringUtils.splitAt(input, ' ');
		BigInteger cur = new BigInteger(strArray[0]);

		for (int i = 1; i < strArray.length; i += 2) {
			// check with if statement for the type of operation
			if (strArray[i].equals("+")) {
				cur = cur.add(new BigInteger(strArray[i + 1]));
			} else if (strArray[i].equals("-")) {
				cur = cur.subtract(new BigInteger(strArray[i + 1]));
			} else if (strArray[i].equals("*")) {
				cur = cur.multiply(new BigInteger(strArray[i + 1]));
			} else if (strArray[i].equals("/")) {

				// check the value which cannot divide by zero.
				if (!(new BigInteger(strArray[i + 1])).equals(BigInteger
						.valueOf(0))) {
					cur = cur.divide(new BigInteger(strArray[i + 1]));
				} else {
					throw new ArithmeticException("Cannot divide by zero.");
				}
			}

			else if (strArray[i].equals("^")) {
				cur = cur.pow(Integer.valueOf(strArray[i + 1]));
			} else {
				throw new IllegalArgumentException(
						"The only legal operators are '+, -, *, /, ^'.");
			}
		}

		return cur;
	}
}
