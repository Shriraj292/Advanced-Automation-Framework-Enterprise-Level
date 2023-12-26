package org.opencart.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import org.opencart.constants.FrameworkConstants;
import org.opencart.enums.ConfigProperties;
import org.opencart.utilities.PropertyUtilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public final class ExtentReport {

	private ExtentReport() {

	}

	private static ExtentReports extent;
	private static ExtentTest test;

	public static void initReports() throws Exception {
		if (Objects.isNull(extent)) {
			extent = new ExtentReports();

			if (PropertyUtilities.getPropertyValue(ConfigProperties.ALLTESTS).equalsIgnoreCase("yes")) {
				ExtentSparkReporter reporterAllTests = new ExtentSparkReporter(FrameworkConstants.getAllTestsReportPath());
				try {
					reporterAllTests.loadJSONConfig(new File(FrameworkConstants.getJsonConfigAlltestsFilePath()));
				} catch (IOException e) {
					e.printStackTrace();
				}
				reporterAllTests.viewConfigurer().viewOrder()
						.as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY }).apply();
				extent.attachReporter(reporterAllTests);
			}
			
			if (PropertyUtilities.getPropertyValue(ConfigProperties.ONLYFAILEDTESTS).equalsIgnoreCase("yes")) {
				ExtentSparkReporter reporterOnlyFailedTests = new ExtentSparkReporter(FrameworkConstants.getOnlyFailedTestsReportPath());
				try {
					reporterOnlyFailedTests.loadJSONConfig(new File(FrameworkConstants.getJsonConfigOnlyfailedFilePath()));
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				reporterOnlyFailedTests.filter().statusFilter().as(new Status[] {Status.FAIL});
				reporterOnlyFailedTests.viewConfigurer().viewOrder()
						.as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY }).apply();
				extent.attachReporter(reporterOnlyFailedTests);
			}

		}
	}

	public static void flushReports() throws Exception {
		if (Objects.nonNull(extent)) {
			extent.flush();
			ExtentReportManager.unload();
			
			if (PropertyUtilities.getPropertyValue(ConfigProperties.ALLTESTS).equalsIgnoreCase("yes")) {
				try {
					Desktop.getDesktop().browse(new File(FrameworkConstants.getAllTestsReportPath()).toURI());				
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (PropertyUtilities.getPropertyValue(ConfigProperties.ONLYFAILEDTESTS).equalsIgnoreCase("yes")) {
				try {
					Desktop.getDesktop().browse(new File(FrameworkConstants.getOnlyFailedTestsReportPath()).toURI());				
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			
		}
	}

	public static void createTest(String testcaseName) {
		test = extent.createTest(testcaseName);
		ExtentReportManager.setExtTest(test);
	}
}
