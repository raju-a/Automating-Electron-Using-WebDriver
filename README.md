# Automating-Electron-Using-WebDriver-java
Automating any CEF based application using WebDriver in java, We can achieve this in 4 steps.


## 1. Setup the Environment 

   We need chromeDriver, Download from [ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/downloads) 
	

## 2. Start ChromeDriver

    ChromeDriverService service = new ChromeDriverService.Builder()
     .usingDriverExecutable(new File("chromedriver/chromedriver"))
     .usingAnyFreePort()
     .build();
      service.start();
	    
	
        
## 3. Setting DesiredCapabilities for chrome

    DesiredCapabilities capabilities = new DesiredCapabilities();
     ChromeOptions options = new ChromeOptions();
     // The address string should be in the form of "hostname/ip:port". 9222 is the port that you specified                        // in the--remote-debugging-port Chromium 
     String remoteDebuggingAddress = "localhost:9222";
     options.setExperimentalOption("debuggerAddress", remoteDebuggingAddress);
     capabilities.setCapability(ChromeOptions.CAPABILITY, options)
	   
	   
        
## 4. Connect to chrome driver

     // Create a WebDriver instance using URL provided by the ChromeDriverService and capabilities
      WebDriver driver = new RemoteWebDriver(service.getUrl(), capabilities);
  
## Note : 
 If your application have Multiple pages or windows, You can discover available pages by requesting: http://localhost:9222/json and getting a JSON object with information about inspectable pages.
