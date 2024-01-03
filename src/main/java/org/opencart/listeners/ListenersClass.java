package org.opencart.listeners;

import java.io.IOException;
import java.util.Objects;

import org.opencart.driverutils.DriverManager;
import org.opencart.exceptions.FileOperationsFailedException;
import org.opencart.reports.ExtentLogger;
import org.opencart.reports.ExtentReport;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersClass implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		try {
			ExtentReport.initReports();
		} catch (IOException e) {
			throw new FileOperationsFailedException("Some I/O exception occured while working with config file.", e);
		}
	}

	@Override
	public void onFinish(ISuite suite) {
		try {
			ExtentReport.flushReports();
		} catch (IOException e) {
			throw new FileOperationsFailedException("Some I/O exception occured while launching reports.", e);
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName() + " passed succesfully.", false);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if (Objects.nonNull(DriverManager.getDriver())) {
			ExtentLogger.fail(result.getMethod().getMethodName() + " failed.", true);
			ExtentLogger.fail(result.getThrowable().toString(), true);
		} else {
			ExtentLogger.skip(result.getMethod().getMethodName() + " skipped.", false);
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName() + " is skipped.", true);
	}

}
