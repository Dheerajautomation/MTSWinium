import java.awt.RenderingHints.Key;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import org.ini4j.Ini;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sun.jna.platform.win32.Advapi32Util;

import static com.sun.jna.platform.win32.WinReg.HKEY_LOCAL_MACHINE;


import com.registry.RegistryKey;
import com.registry.RegistryValue;

public class LiveUpdate {
	static String BeforeDeltaversion="";
	static String AfterDeltaversion="";
	WebDriver wdriver;
	
	@Test
	public void liveupdate() {
		WebElement aboutMe;
		BeforeDeltaversion=Advapi32Util.registryGetStringValue(HKEY_LOCAL_MACHINE,"SOFTWARE\\Max Secure Total Security", "DatabaseVersionNo");
		System.out.println(BeforeDeltaversion);

		try {
			DesktopOptions option = new DesktopOptions();
			option.setApplicationPath("C:\\Program Files\\Max Secure Total Security\\MaxSDUI.exe");
			WiniumDriver driver=new WiniumDriver(new URL("http://localhost:9999"),option);

			driver.findElement(By.id("1014")).click();
			Thread.sleep(1000);
			driver.findElement(By.name("Update Now")).click();
			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(1300));	
			aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Finished"))); 
			String finish =driver.findElement(By.name("Finished")).getAttribute("Name");

			if(finish.equals("Finished"))
			{
				driver.findElement(By.id("1008")).click();
				driver.close();
				System.out.println("Update finished");
				System.out.println("Waiting for Merger to Merge the Deltas");
			}
			else
			{
				System.out.println("Update Error");
			}
			boolean flag=false;
			Thread.sleep(3000);
			do {
				File f = new File("C:\\Program Files\\Max Secure Total Security\\WaitingForMerge\\ServerVersionEx.txt");
				if(f.exists()){
					System.out.println("Waiting for Merger to Merge");
				}
				else{
					System.out.println("Update successfull");
					break;
				}
			}
			while(flag=true);

			Thread.sleep(3000);
			AfterDeltaversion=Advapi32Util.registryGetStringValue(HKEY_LOCAL_MACHINE,"SOFTWARE\\Max Secure Total Security", "DatabaseVersionNo");
			System.out.println(AfterDeltaversion);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("PreviousDeltaVersion" +BeforeDeltaversion);
		System.out.println("Updated Delta Version" +AfterDeltaversion);

	}


	@BeforeMethod
	public void beforeMethod() {

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Automation\\eclipse-workspace\\MTSWinium\\chromedriver\\chromedriver.exe");
		//driver = new ChromeDriver();
		//driver.manage().window().maximize(); 
		//driver.navigate().to("https://maxsecurecloud.com/"); 

}
}


//Ini ini = new Ini(new File("C:\\Program Files\\Max Secure Total Security\\WaitingForMerge\\DeltaServerVersion.txt"));
//System.out.println(ini.get("NewDeltaDBDetails", "Max_Ver"));
