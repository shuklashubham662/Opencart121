package testBase;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class BaseClass {
public  static WebDriver driver;
public Logger logger;
public Properties p;
public FileReader file;

	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"browser","os"})
public	void setup(String br,String os) throws IOException
		{
		//loading config file		
	file=new FileReader(".//src//test//resources//config.properties");
	p=new Properties();
	p.load(file);
		
		logger=LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("no matching os");
				return;
			}
			
			switch(br.toLowerCase())
			{
			case "chrome" :capabilities.setBrowserName("chrome"); break;
			case "Firefox" :capabilities.setBrowserName("Firefox"); break;
			default : System.out.println("Invalid browser name"); return;
			
			}
		driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
		switch(br.toLowerCase())
		{
		case "chrome":driver=new ChromeDriver(); break;
		case "firefox": driver=new FirefoxDriver(); break;
		default : System.out.println("Invalid browser name"); return;
		}
		}	
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		}
		
@AfterClass(groups= {"Sanity","Regression","Master"})
public	void tearDown()
	 {
		driver.quit();
	 }
	public String randomstring()
	{
	String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	 public String randomNumber()
	 {
	String genetratednumber=RandomStringUtils.randomNumeric(5);
	return genetratednumber;
	 }
	 public String alphanumeric()
	 {
	String generatedstring=RandomStringUtils.randomAlphabetic(5);
	String genetratednumber=RandomStringUtils.randomNumeric(5);
	return (generatedstring+"@"+genetratednumber);
	 }
	 public String captureScreen(String tname) {
	String timestamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	TakesScreenshot takescreenshot=(TakesScreenshot) driver;
	File sourceFile=takescreenshot.getScreenshotAs(OutputType.FILE);
String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+ tname +"_"+timestamp+".png";
File targetFile=new File(targetFilePath);
sourceFile.renameTo(targetFile);
		return targetFilePath;
		 
	 }
}
