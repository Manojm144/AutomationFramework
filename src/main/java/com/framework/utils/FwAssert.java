package com.framework.utils;

import org.testng.Assert;

import com.aventstack.extentreports.Status;

public class FwAssert {

	public static void assertEquals(String actual,String expected,String failureMessage) {
		String comparing = "Actual ["+actual+"] == Expected  ["+expected+"]";
		try {
			Assert.assertEquals(actual, expected, failureMessage);
			Log.log(new Message(Status.PASS,comparing));
		} catch (AssertionError e) {
			Log.log(new Message(Status.FAIL,failureMessage+ ". " +comparing));
			throw e;
		}
	}
	public static void assertTrue(boolean actual,String failureMessage) {
		String comparing = "Actual ["+actual+"] == Expected  ["+true+"]";
		try {
			Assert.assertEquals(actual, true, failureMessage);
			Log.log(new Message(Status.PASS,comparing));
		} catch (AssertionError e) {
			Log.log(new Message(Status.FAIL,failureMessage+ ". " +comparing));
			throw e;
		}
	}
}
