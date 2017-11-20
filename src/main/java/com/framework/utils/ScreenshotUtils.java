package com.framework.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.google.common.io.Files;

public class ScreenshotUtils {
	static int snapCounter;
	public static void takeScreenshot(WebDriver driver){
		//if(testResult.getStatus() == ITestResult.FAILURE){
		TakesScreenshot ts = (TakesScreenshot) driver;
		File snap = ts.getScreenshotAs(OutputType.FILE);
		// Move snap from temp to snaps folder in current project
		try {
			File dest = new File( "./snaps/"+(snapCounter++) + ".png");
			Files.move(snap,dest);
			Log.log(new Message(Status.INFO,dest.getAbsolutePath(),true));
		} catch (IOException e) {

			e.printStackTrace();
		}
	//}
	}
}
