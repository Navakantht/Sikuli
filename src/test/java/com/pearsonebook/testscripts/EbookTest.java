package com.pearsonebook.testscripts;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;

public class EbookTest{
	String rDir=System.getProperty("user.dir")+"\\src\\test\\resources";
	String ebookImagesPath=rDir+"\\ebookImages";
	String exePath=rDir+"\\application_under_test.exe";

	@BeforeMethod
	public void launchApp() throws IOException, InterruptedException{
		String start[]={"cmd.exe", "/C", exePath};
		Runtime.getRuntime().exec(start);
		NXGReports.addStep("Launched application", LogAs.PASSED, null);
	}
	
    @Test(priority=1,enabled=false,description="Open E-Book, Verify the functionality of buttons")
	public void testEBook() throws Throwable
	{
		try{
			String acceptPath=ebookImagesPath+"\\accept.PNG";
			String mathematicsPath=ebookImagesPath+"\\mathematics.PNG";
			String subMenuPath=ebookImagesPath+"\\submenu.PNG";
			String pageCoverPath=ebookImagesPath+"\\page cover.PNG";
			String goToPagePath=ebookImagesPath+"\\Go to page.PNG";
			String nextPath=ebookImagesPath+"\\next.PNG";
			String previousPath=ebookImagesPath+"\\previous.PNG";
			String zoominPath=ebookImagesPath+"\\zoomin.PNG";
			String zoomoutPath=ebookImagesPath+"\\zoomout.PNG";
			String fullscreenPath=ebookImagesPath+"\\fullscreen.PNG";
			String defaultScreenPath=ebookImagesPath+"\\defaultscreen.PNG";
			Screen screen=new Screen();
			screen.click(acceptPath);
			screen.click(mathematicsPath);
			if(screen.exists(pageCoverPath) != null){
				System.out.println("Cover Page is displaying");
				NXGReports.addStep("pass", LogAs.PASSED, null);
			}
			else
			{
				System.out.println("Cover Page is not displaying");
			}
			if(screen.exists(subMenuPath)!=null){
				System.out.println(" Sub Menu is displaying");
			}
			else
			{
				System.out.println(" Sub Menu is not displaying");
			}
			screen.click(pageCoverPath);
			screen.type(goToPagePath,"15");
			Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
			// To click next and previous icons
			int i=1;
			do{
				screen.click(nextPath);
				screen.click(previousPath);
				screen.click(nextPath);
				screen.click(zoominPath);
				screen.click(zoomoutPath);
				screen.click(fullscreenPath);
				screen.click(defaultScreenPath);
				System.out.println("i value: "+i);
				i++;
			}while(screen.exists(nextPath)!=null);

		}
		catch(Exception e){
			throw e;
		}
	}
    @Test(priority=2,enabled=true,description="Launch ebook, Click on resources, Select 'Measurement of length' and check the functionality of buttons")
   	public void testMeasurementofLength() throws Throwable
   	{
   		try{
   			String mathematicsPath=ebookImagesPath+"\\mathematics.PNG";
   			String resourcesImgPath=ebookImagesPath+"\\Resources.PNG";
   			String interactiveImgPath=ebookImagesPath+"\\interactive.PNG";
   			String MeasurementoflengthImgPath=ebookImagesPath+"\\Measurement of length.PNG";
   			String swapiconImgPath=ebookImagesPath+"\\swap icon.PNG";
   			String refreshiconImgPath=ebookImagesPath+"\\refresh icon.PNG";
   			String volumeDecreaseImgPath=ebookImagesPath+"\\Volume decrease.PNG";
   			String volumeIncreaseImgPath=ebookImagesPath+"\\Volume Increase.PNG";
   			String VolumeImgPath=ebookImagesPath+"\\Volume icon.PNG";
   			String muteiconImgPath=ebookImagesPath+"\\Mute icon.PNG";
   			String paginationiconImgPath=ebookImagesPath+"\\Paginationicon.PNG";
   			String paginationNextIconImgPath=ebookImagesPath+"\\paginationNextIcon.PNG";
   			String fiveIconImgPath=ebookImagesPath+"\\FiveIcon.PNG";
   			String paginationPreviousIconImgPath=ebookImagesPath+"\\paginationPreviousIcon.PNG";
   			String oneiconImgPath=ebookImagesPath+"\\OneIcon.PNG";
   			String blinkingIconImgPath=ebookImagesPath+"\\Blinking next icon.PNG";
   			String centemeterImgPath=ebookImagesPath+"\\centemeter.PNG";
   			String meterImgPath=ebookImagesPath+"\\Meter.PNG";
   			String millimeterImgPath=ebookImagesPath+"\\Millimeter.PNG";
   			String kilometerImgPath=ebookImagesPath+"\\kilometer.PNG";
   			String submitButtonImgPath=ebookImagesPath+"\\submit.PNG";
   			String nextButtonImgPath=ebookImagesPath+"\\activityNext.PNG";
   			String resultsMessageImgPath=ebookImagesPath+"\\resultsMessage.PNG";
   			String nextIconImgPath=ebookImagesPath+"\\Next icon.PNG";
   			Screen screen=new Screen();
   			screen.click(mathematicsPath);
   			screen.click(resourcesImgPath);
   			screen.click(interactiveImgPath);
   			screen.click(MeasurementoflengthImgPath);
   			screen.click(refreshiconImgPath);
   			screen.click(volumeDecreaseImgPath);
   			screen.click(volumeIncreaseImgPath);
   			screen.click(VolumeImgPath);
   			screen.click(muteiconImgPath);
   			screen.click(paginationiconImgPath);
   			screen.click(paginationNextIconImgPath);
   			screen.click(fiveIconImgPath);
   			screen.click(paginationPreviousIconImgPath);
   			screen.click(oneiconImgPath);
   			screen.click(paginationiconImgPath);
   			screen.click(blinkingIconImgPath);
   			screen.click(meterImgPath);
   			screen.click(submitButtonImgPath);
   			screen.click(nextButtonImgPath);
   			screen.click(centemeterImgPath);   	
   			screen.click(submitButtonImgPath);
   			screen.click(nextButtonImgPath);
   			screen.click(kilometerImgPath);   	
   			screen.click(submitButtonImgPath);
   			screen.click(nextButtonImgPath);
   			screen.click(millimeterImgPath);
   			screen.click(submitButtonImgPath);
   			if(screen.exists(resultsMessageImgPath) != null){
				System.out.println("'You have scored 4/4 Excellent!' Message is displaying");
			}
			else
			{
				System.out.println("'You have scored 4/4 Excellent!' Message is not displaying");
			}
   			screen.click(blinkingIconImgPath);
   			for(int i=2;i<=14;i++){
   				screen.click(nextIconImgPath);	
   				}
   			screen.click(swapiconImgPath);
   		  			
   		}
		catch(Exception e){
			throw e;
		}
	}
    @AfterMethod
	public void tearDown() throws IOException{
		Runtime.getRuntime().exec("taskkill /F /IM myPedia.exe");
	}
}
