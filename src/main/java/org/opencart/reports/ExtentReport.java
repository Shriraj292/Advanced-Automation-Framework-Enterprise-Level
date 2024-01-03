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

/**
 * ExtentReport class is responsible for initializing and flushing the reports.
 * 
 * @author Shriraj Ghorpade
 */
public final class ExtentReport {

	private ExtentReport() {

	}

	private static ExtentReports extent;
	private static ExtentTest test;

	/**
	 * This method initializes extent reports
	 * 
	 * @throws IOException
	 */
	public static void initReports() throws IOException {
		if (Objects.isNull(extent)) {
			extent = new ExtentReports();

			if (PropertyUtilities.getPropertyValue(ConfigProperties.ALLTESTS).equalsIgnoreCase("yes")) {
				ExtentSparkReporter reporterAllTests = new ExtentSparkReporter(
						FrameworkConstants.getAllTestsReportPath());

				reporterAllTests.loadJSONConfig(new File(FrameworkConstants.getJsonConfigAlltestsFilePath()));

				reporterAllTests.viewConfigurer().viewOrder()
						.as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY }).apply();
				extent.attachReporter(reporterAllTests);
			}

			if (PropertyUtilities.getPropertyValue(ConfigProperties.ONLYFAILEDTESTS).equalsIgnoreCase("yes")) {
				ExtentSparkReporter reporterOnlyFailedTests = new ExtentSparkReporter(
						FrameworkConstants.getOnlyFailedTestsReportPath());

				reporterOnlyFailedTests.loadJSONConfig(new File(FrameworkConstants.getJsonConfigOnlyfailedFilePath()));

				reporterOnlyFailedTests.filter().statusFilter().as(new Status[] { Status.FAIL });
				reporterOnlyFailedTests.viewConfigurer().viewOrder()
						.as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY }).apply();
				extent.attachReporter(reporterOnlyFailedTests);
			}

		}
	}

	/**
	 * This method publishes extent reports and automatically opens reports in
	 * default browser.
	 * 
	 * @throws IOException
	 */
	public static void flushReports() throws IOException {
		if (Objects.nonNull(extent)) {
			extent.flush();
			ExtentReportManager.unload();

			if (PropertyUtilities.getPropertyValue(ConfigProperties.LAUNCHEXTENTREPORTS).equalsIgnoreCase("yes")) {
				if (PropertyUtilities.getPropertyValue(ConfigProperties.ALLTESTS).equalsIgnoreCase("yes")) {
					Desktop.getDesktop().browse(new File(FrameworkConstants.getAllTestsReportPath()).toURI());
				}

				if (PropertyUtilities.getPropertyValue(ConfigProperties.ONLYFAILEDTESTS).equalsIgnoreCase("yes")) {
					Desktop.getDesktop().browse(new File(FrameworkConstants.getOnlyFailedTestsReportPath()).toURI());
				}
			}

		}
	}

	/**
	 * This method creates extent test for the testcase passed as argument.
	 * 
	 * @param testcaseName
	 */
	public static void createTest(String testcaseName) {
		test = extent.createTest(testcaseName);
		ExtentReportManager.setExtTest(test);
	}
}
