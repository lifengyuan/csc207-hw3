package edu.grinnell.csc207.lifengyuan.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.grinnell.csc207.lifengyuan.utils.StringUtils;

public class StringUtilsTest {

	@Test
	public void test() {
		assertArrayEquals(new String[] { "a", "b", "c" },
				StringUtils.splitAt("a:b:c", ':'));
		assertArrayEquals(new String[] { "a", "b", "c" },
				StringUtils.splitAt("a b c", ' '));
		assertArrayEquals(new String[] { "a:b:c" },
				StringUtils.splitAt("a:b:c", ' '));
		assertArrayEquals("one field", new String[] { "a" },
				StringUtils.splitAt("a", ':'));
		assertArrayEquals("empty inner field", new String[] { "a", "", "c" },
				StringUtils.splitAt("a::c", ':'));
		assertArrayEquals("leading empty field", new String[] { "", "a" },
				StringUtils.splitAt(":a", ':'));
		assertArrayEquals("trailing empty field", new String[] { "a", "" },
				StringUtils.splitAt("a:", ':'));

		assertArrayEquals(new String[] { "a", "b", "c" },
				StringUtils.splitCSV("a,b,c"));
		assertArrayEquals(new String[] { "a,b", "c" },
				StringUtils.splitCSV("\"a,b\",c"));
		assertArrayEquals(new String[] { "a", "b,b\"", "c" },
				StringUtils.splitCSV("a,\"b,b\"\"\",c"));
	
		assertEquals ("e", StringUtils.deLeet ("3"));
		assertEquals ("leet", StringUtils.deLeet ("133+"));
		assertEquals ("eat banana", StringUtils.deLeet ("3@+ |3@|\\|@|\\|@"));
	}
}