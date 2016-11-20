package chrome_webdriver_communication;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeWebdriverCommunication {
	
	
	public void ChromeCommunication() throws IOException{
		
		// This will start the chrome 
		ChromeDriverService service = new ChromeDriverService.Builder()
	     .usingDriverExecutable(new File("chromedriver/chromedriver"))
	     .usingAnyFreePort()
	     .build();
		service.start();
		 
		// Setting DesiredCapabilities for chrome
		DesiredCapabilities capabilities = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();
		
		// The address string should be in the form of "hostname/ip:port". 9222 is the port that you specified in the
		// --remote-debugging-port Chromium 
		String remoteDebuggingAddress = "localhost:9222";
		options.setExperimentalOption("debuggerAddress", remoteDebuggingAddress);
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        
        // Create a WebDriver instance using URL provided by the ChromeDriverService and capabilities with
        WebDriver driver = new RemoteWebDriver(service.getUrl(), capabilities);
        java.util.Set<java.lang.String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);
        
        //pass your window ID if you have multiple window 
        driver.switchTo().window("CDwindow-E1C85686-476B-47A1-8150-61A62975EC59");	
		
	}
	
	  public void StartYourApp(){  
		   
		  try{
			  ChromeDriverService service = new ChromeDriverService.Builder()
		      . usingDriverExecutable(new File("/Applications/AnywhereWorks.app/Contents/MacOS/AnywhereWorks")) 
		      .usingAnyFreePort()
		      .build();
			  
		       service.start();
			  }
		  
		  catch(Exception ex){
			   }
	  }
	  
	  public static void main(String args[]) throws IOException{
		  
		  ChromeWebdriverCommunication communication = new ChromeWebdriverCommunication();
		  communication.StartYourApp();
		  communication.ChromeCommunication();
	  }

}
