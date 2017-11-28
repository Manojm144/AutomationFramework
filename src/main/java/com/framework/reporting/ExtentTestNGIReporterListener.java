package com.framework.reporting;

import java.awt.TrayIcon.MessageType;
import java.io.IOException;
import java.util.*;
import org.testng.*;
import org.testng.xml.XmlSuite;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.*;
import com.framework.utils.Message;

public class ExtentTestNGIReporterListener implements IReporter {
    
    private static final String OUTPUT_FOLDER = "./";
    private static final String FILE_NAME = "Extent.html";
    public static final String LOG_ATTRIBUTE="LOG";
    
    private ExtentReports extent;

    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory){
    
        init();
        
        for (ISuite suite : suites) {
        	Map<String, ISuiteResult> result = suite.getResults();
            
            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();
                
                buildTestNodes(context.getFailedTests(), Status.FAIL);
                buildTestNodes(context.getSkippedTests(), Status.SKIP);
                buildTestNodes(context.getPassedTests(), Status.PASS);
                
            }
        }
        
        for (String s : Reporter.getOutput()) {
            extent.setTestRunnerOutput(s);
        }
        
        extent.flush();
    }
    
    private void init() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(OUTPUT_FOLDER + FILE_NAME);
        htmlReporter.config().setDocumentTitle("ExtentReports - Created by TestNG Listener");
        htmlReporter.config().setReportName("ExtentReports - Created by TestNG Listener");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setTheme(Theme.STANDARD);
        
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setReportUsesManualConfiguration(true);
    }
    
    private void buildTestNodes(IResultMap tests, Status status) {
        ExtentTest test;
        
        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                test = extent.createTest(result.getMethod().getMethodName());
                @SuppressWarnings("unchecked")
				List<Message> logs=(List<Message>) result.getAttribute(LOG_ATTRIBUTE);
                if(logs!=null) {
                	for (Message message : logs) {
						if(message.isSnap()) {
							try {
								test.log(message.getStatus(), "", MediaEntityBuilder.createScreenCaptureFromPath(message.getMessage()).build());
							} catch (IOException e) {
								System.err.println("Failed to add snap in report");
							}
						}
						else {
							test.log(message.getStatus(), message.getMessage());
						}
                		
					}
                }
                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);

                if (result.getThrowable() != null) {
                    test.log(status, result.getThrowable());
                }
                else {
                    test.log(status, "Test " + status.toString().toLowerCase() + "ed");
                }
                
                test.getModel().setStartTime(getTime(result.getStartMillis()));
                test.getModel().setEndTime(getTime(result.getEndMillis()));
            }
        }
    }
    
    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();      
    }
}