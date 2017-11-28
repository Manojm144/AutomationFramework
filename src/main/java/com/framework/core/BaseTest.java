package com.framework.core;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import org.openqa.selenium.*;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.framework.driverfactory.BrowserFactoryUtil;
import com.framework.utils.ScreenshotUtils;
import com.google.common.io.*;

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
