package org.opencart.utilities;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.opencart.constants.FrameworkConstants;
import org.testng.annotations.DataProvider;

public final class DataProviderUtilities {
    private DataProviderUtilities(){}

    private static List<Map<String, String>> list = new ArrayList<>();
    
    @DataProvider(name="dataSupplier")
    public static Object[] getData(Method m){
    	String methodName = m.getName();
    	String scenarioSheet = null;
    	
    	List<Map<String, String>> tempList = new ArrayList<>();
    	tempList = ExcelUtilities.getData(FrameworkConstants.getRunManagerSheet());
    	for (int i = 0; i < tempList.size(); i++) {
			if (tempList.get(i).get("test name").equals(methodName) &&
					tempList.get(i).get("execute").equalsIgnoreCase("Yes")) {
				scenarioSheet = tempList.get(i).get("test scenario");
				break;
			}
		}
    	list = ExcelUtilities.getData(scenarioSheet);
    	
    	List<Map<String, String>> methodSpecificDataList = new ArrayList<>();
    	for (int i = 0; i < list.size(); i++) {
			if (list.get(i).get("testcase name").equals(methodName) &&
					list.get(i).get("execute").equalsIgnoreCase("Yes")) {
				methodSpecificDataList.add(list.get(i));
			}
		}
    	
        return methodSpecificDataList.toArray();
    }
}
