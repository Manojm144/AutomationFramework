package com.framework.utils;

import java.util.ArrayList;
import java.util.List;

import org.testng.Reporter;

import com.framework.reporting.ExtentTestNGIReporterListener;

public class Log {

	public static void log(Message m) {
		List<Message> log = (List<Message>) Reporter.getCurrentTestResult().getAttribute(ExtentTestNGIReporterListener.LOG_ATTRIBUTE);
		if(log==null) {
			log = new ArrayList<Message>();
		}
		log.add(m);
		Reporter.getCurrentTestResult().setAttribute(ExtentTestNGIReporterListener.LOG_ATTRIBUTE,log);
	}
}
