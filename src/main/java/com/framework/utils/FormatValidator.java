package com.framework.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormatValidator {

	public static boolean validate(String format, String txt) {

		Pattern pattern = Pattern.compile(format);
		Matcher matcher = pattern.matcher(txt);
		return (matcher.matches());

	}

}
