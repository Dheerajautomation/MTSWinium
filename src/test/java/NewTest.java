import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class NewTest{
	
	static String timetobeselectedweedays="";
	static String timetobeselectedweekends="";
	
	@org.testng.annotations.Test
public void new1() throws IOException, InterruptedException
{
		DesktopOptions option = new DesktopOptions();
		option.setApplicationPath("C:\\Program Files\\Max Secure Total Security\\MaxSDUI.exe");
		WiniumDriver driver=new WiniumDriver(new URL("http://localhost:9999"),option);
		driver.findElement(By.name("Protection Center")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("10020")).click();
		
		driver.findElement(By.id("5141")).click();		
		driver.findElement(By.name("Add")).click();	
		driver.findElement(By.id("5199")).sendKeys("192.168.1.201");
		driver.findElement(By.name("OK")).click();	
		driver.findElement(By.name("Save")).click();	
		Thread.sleep(2000);
		driver.findElement(By.name("OK")).click();	
}
	@BeforeClass
	 public void initialisewinium() throws IOException
	 {
		 Runtime runTime = Runtime.getRuntime();
	        String executablePath = "C:\\Users\\Automation\\eclipse-workspace\\MTSWinium\\WiniumDriver\\Winium.Desktop.Driver.exe";
	        Process process1 = runTime.exec(executablePath);
	 }
	
	@AfterClass
	 public void teardownwinium() throws IOException
	 {
		Runtime.getRuntime().exec("TASKKILL /F /IM Winium.Desktop.Driver.exe");
	 }
}


