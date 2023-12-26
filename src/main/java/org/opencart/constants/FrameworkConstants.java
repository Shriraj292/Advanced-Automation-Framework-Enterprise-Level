package org.opencart.constants;

import org.opencart.reports.ReportsManager;

public final class FrameworkConstants {

    private FrameworkConstants(){}
    private static final String ENV_CONFIG_PROP_FILE = "src/main/resources/config-files/environmentConfig.properties";
    private static final String TEST_DATA_EXCEL_FILE = "src/test/resources/excel-data/TestData.xlsx";
    private static final String JSON_CONFIG_ALLTESTS_FILE_PATH = "src/main/resources/extentConfigs/extentconfig-spark-all.json";
    private static final String JSON_CONFIG_ONLYFAILED_FILE_PATH = "src/main/resources/extentConfigs/extentconfig-spark-onlyfailed.json";
    
    private static String onlyFailedTestsReportPath = "test-reports/" + ReportsManager.getReportFolderName() + "/reports/report_onlyfailedtests.html";
	private static String allTestsReportPath = "test-reports/" + ReportsManager.getReportFolderName() + "/reports/report_alltests.html";
	private static String screenshotsFolderPath = "test-reports/" + ReportsManager.getReportFolderName() + "/screenshots";
	
	private static final String RUNMANAGER = "Run Manager";
	
    public static String getEnvConfigPropFile(){
        return ENV_CONFIG_PROP_FILE;
    }

    public static String getTestDataExcelFile(){
        return TEST_DATA_EXCEL_FILE;
    }

	public static String getJsonConfigAlltestsFilePath() {
		return JSON_CONFIG_ALLTESTS_FILE_PATH;
	}

	public static String getOnlyFailedTestsReportPath() {
		return onlyFailedTestsReportPath;
	}

	public static String getAllTestsReportPath() {
		return allTestsReportPath;
	}

	public static String getScreenshotsFolderPath() {
		return screenshotsFolderPath;
	}

	public static String getJsonConfigOnlyfailedFilePath() {
		return JSON_CONFIG_ONLYFAILED_FILE_PATH;
	}

	public static String getRunManagerSheet() {
		return RUNMANAGER;
	}
    
    
}
