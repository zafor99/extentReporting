package library;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Utility {

	public static String captureScreenShot(WebDriver driver,String screenShotName){
		
		String filePath = "C:\\MyDevelopment\\EclipseWorkspaces\\githubprojects\\extentReporting\\report\\"+screenShotName+".jpeg";
		try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(filePath));
			System.out.println("Screenshot taken");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception while taking screenshot "+e.getMessage());
		}
		
		return filePath;
	}
}
