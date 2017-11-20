package com.framework.core;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.framework.driverfactory.BrowserFactoryUtil;
import com.framework.utils.ScreenshotUtils;
import com.google.common.io.Files;
import com.google.common.io.MoreFiles;
import com.google.common.io.RecursiveDeleteOption;

public class BaseTest {

	protected WebDriver driver;
	static int snapCounter = 1;

	@BeforeSuite
	public void init() {
		File f = new File("./snaps");
		if (f.exists()) {
			try {
				MoreFiles.deleteDirectoryContents(Paths.get("./snaps"), RecursiveDeleteOption.ALLOW_INSECURE);
			} catch (IOException e) {
				System.err.println("Failed to clear snaps folder");
			}
		} else {
			f.mkdir();
		}
	}

	@BeforeTest
	public void setUp() {
		driver = BrowserFactoryUtil.getDriver();
	}

	@AfterMethod
	public void tearDown(ITestResult testResult) {
		ScreenshotUtils.takeScreenshot(driver);

		driver.quit();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
