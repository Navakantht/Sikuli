package com.pearsonebook.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class GenericLib {

	public static String sFile;
	public static int iPassCount = 0;
	public static int iFailCount = 0;
	public static int iSkippedCount = 0;
	static public String sDirPath = System.getProperty("user.dir");
	public static String sConfigFile = sDirPath + "//Config.Properties";
	public static String sTestDataFile = sDirPath+"\\TestData.xlsx";
	public static int sStatusCnt = 0;

	public static String getConfigValue(String sFile, String sKey) {
		Properties prop = new Properties();
		String sValue = null;
		try {
			InputStream input = new FileInputStream(sFile);
			prop.load(input);
			sValue = prop.getProperty(sKey);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sValue;
	}

	public static void setCongigValue(String sFile, String sKey, String sValue) {
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(new File(sFile));
			prop.load(fis);
			fis.close();

			FileOutputStream fos = new FileOutputStream(new File(sFile));
			prop.setProperty(sKey, sValue);
			prop.store(fos, "Updating folder path");
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

	public static void waitForElement(int timeInMilliSec){
		try {
			Thread.sleep(timeInMilliSec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void setStatus(String sName, String sResult, ArrayList sTestName, ArrayList sStatus) {
		sName = sName.replace("test", "");
		sTestName.add(sName);
		sStatus.add(sResult);

		if (sResult.equals("Passed")) {
			iPassCount = iPassCount + 1;
		} else if (sResult.equals("Failed")) {
			iFailCount = iFailCount + 1;
		} else {
			iSkippedCount = iSkippedCount + 1;
		}
	}
	
	
}
