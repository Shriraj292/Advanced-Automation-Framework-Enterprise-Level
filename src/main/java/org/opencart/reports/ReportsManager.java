package org.opencart.reports;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class ReportsManager {
	
	private ReportsManager() {
		
	}

	private static String reportFolderName;
	
	public static String getTimeStamp() {
		LocalDateTime objDateTime = LocalDateTime.now();
		DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-yyyy_hh-mm-ss");
		return objDateTime.format(date);
	}
	
	private static void generateReportFolder() {
		reportFolderName = "Report_" + getTimeStamp();
	}

	public static String getReportFolderName() {
		generateReportFolder();
		return reportFolderName;
	}
}
