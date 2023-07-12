package com.ish.genericutility;

import java.io.File;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementaion extends BaseClass implements ITestListener{

	@Override
	public void onFinish(ITestContext context) {
		ITestListener.super.onFinish(context);
	}

	@Override
	public void onStart(ITestContext context) {
		ITestListener.super.onStart(context);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
         String res = result.getName();
		 TakesScreenshot t = (TakesScreenshot)BaseClass.sDriver;
		 LocalDateTime dt = LocalDateTime.now();
		 String dateTime = dt.toString().replace(" ","_").replace(":","_");
         File src = t.getScreenshotAs(OutputType.FILE);
         File des = new File("./screenshots/"+res+dateTime+".png");
	      try {
	    	 FileUtils.copyFile(src, des);	
		} catch (Exception e) {

		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestStart(ITestResult result) {
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ITestListener.super.onTestSuccess(result);
	}

}
