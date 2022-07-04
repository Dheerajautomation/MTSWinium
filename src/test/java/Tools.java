import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Tools {


	int Hours;
	int minutes;
	String ampms="";
	//@org.testng.annotations.Test

	/*--------------------------------------------------------------------------------------------------------------------
	 *
	 * Module Name: Tools -Application Whitelist
	 * Created By:-Dheeraj Prajapati
	 *
	 * -------------------------------------------------------------------------------------------------------------------
	 */
	public void Appwhitelist() throws InterruptedException, IOException {

		int click;
		DesktopOptions option = new DesktopOptions();
		option.setApplicationPath("C:\\Program Files\\Max Secure Total Security\\MaxSDUI.exe");
		WiniumDriver driver=new WiniumDriver(new URL("http://localhost:9999"),option);
		Thread.sleep(3000);
		driver.findElement(By.name("Tools")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("9480")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("1015")).click();
		driver.findElement(By.name("Yes")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("1007")).click();
		driver.findElement(By.id("1007")).sendKeys("C:\\Users\\Automation\\eclipse-workspace\\MTSWinium\\Application\\PEview.exe");
		driver.findElement(By.name("Add")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("1007")).click();
		driver.findElement(By.id("1007")).sendKeys("C:\\Users\\Automation\\eclipse-workspace\\MTSWinium\\WiniumDriver\\Winium.Desktop.Driver.exe");
		driver.findElement(By.name("Add")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("1007")).click();
		driver.findElement(By.id("1007")).sendKeys(System.getProperty("user.home")+"\\.p2\\pool\\plugins\\org.eclipse.justj.openjdk.hotspot.jre.full.win32.x86_64_18.0.1.v20220515-1614\\jre\\bin\\javaw.exe");
		driver.findElement(By.name("Add")).click();
		driver.findElement(By.name("Apply")).click();
		Thread.sleep(2000);
		int loop;
		do {
			try {
				driver.findElement(By.name("Delete")).click();
				Thread.sleep(1000);
				Runtime.getRuntime().exec("TASKKILL /F /IM MaxSDUI.exe");
				Runtime.getRuntime().exec("TASKKILL /F /IM MaxAppWhitelist.exe");
				loop=0;
			}
			catch(Exception e)
			{
				loop=1;
			}
		}
		while(loop==1);
		Thread.sleep(2000);
		try {

			Process runtime = Runtime.getRuntime().exec("C:\\Users\\Automation\\eclipse-workspace\\MTSWinium\\Application\\PEview.exe");
			System.out.println("Whitelisted File Opened");
			Thread.sleep(1000);
			Runtime.getRuntime().exec("TASKKILL /F /IM PEview.exe");
		}
		catch(Exception e)
		{
			System.out.println("Unable to Whitelist");
		}

		try {

			Process runtime = Runtime.getRuntime().exec("C:\\Users\\Automation\\eclipse-workspace\\MTSWinium\\Application\\procexp.exe");
			System.out.println("Non whitelisted File is also opening");
		}
		catch(Exception e)
		{
			System.out.println("Non whitelisted file Blocked successfully");
		}



		System.out.println("=================Running Appwhitelist Remove======================");
		WiniumDriver driver2=new WiniumDriver(new URL("http://localhost:9999"),option);
		Thread.sleep(1000);
		do {
			try
			{
				driver.findElement(By.name("Tools")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("9450")).click(); //tools heading
				System.out.println("Clicking on Tool");
				click=0;

			}
			catch(Exception e)
			{
				System.out.println("Unable to click on Tool");
				click=1;
			}
		}while(click==1);

		Thread.sleep(2000);
		driver.findElement(By.id("9480")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("1015")).click();
		driver.findElement(By.id("1011")).click();
		driver.findElement(By.id("1013")).click();
		Thread.sleep(800);
		driver.findElement(By.id("1012")).click();
		driver.findElement(By.id("1014")).click();

		driver.findElement(By.name("Apply")).click();
		Thread.sleep(2000);
		int loop2;
		do {
			try {
				driver.findElement(By.name("Delete")).click();
				Thread.sleep(1000);
				Runtime.getRuntime().exec("TASKKILL /F /IM MaxSDUI.exe");
				Runtime.getRuntime().exec("TASKKILL /F /IM MaxAppWhitelist.exe");
				loop2=0;
			}
			catch(Exception e)
			{
				loop2=1;
			}
		}
		while(loop2==1);
		Thread.sleep(2000);
		try {

			Process runtime = Runtime.getRuntime().exec("C:\\Users\\Automation\\eclipse-workspace\\MTSWinium\\Application\\procexp.exe");
			System.out.println("Whitelist remove PASS");
			Thread.sleep(1000);
			Runtime.getRuntime().exec("TASKKILL /F /IM procexp.exe");
		}
		catch(Exception e)
		{
			System.out.println("Whitelistremove failed");
		}

	}
	/*--------------------------------------------------------------------------------------------------------------------
	 *
	 * Module Name: Tools -Max Backup Utility
	 * Created By:-Dheeraj Prajapati
	 *
	 * -------------------------------------------------------------------------------------------------------------------
	 */
	@Test
	public void backuputility() throws MalformedURLException, InterruptedException {

		DesktopOptions option = new DesktopOptions();
		option.setApplicationPath("C:\\Program Files\\Max Secure Total Security\\MaxSDUI.exe");
		WiniumDriver driver=new WiniumDriver(new URL("http://localhost:9999"),option);
		Thread.sleep(3000);
		driver.findElement(By.name("Tools")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("9558")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("Settings")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("9395")).click();    //Select All
		driver.findElement(By.id("9393")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("9393")).sendKeys("C");
		Thread.sleep(2000);
		driver.findElement(By.id("1090")).findElement(By.name("More")).click();


		//driver.findElement(By.id("1090")).sendKeys("{LEFT}");
		//driver.findElement(By.id("1090")).sendKeys("{ARROW_LEFT}");
		//	Actions act= new Actions(driver);
		//	act.sendKeys(Keys.ARROW_LEFT).build().perform();




		driver.findElement(By.id("1090")).sendKeys(Hours+minutes+ampms);





	}

	public void timecalculation()
	{

		int leftoverminute;

		String Hrs="";
		String Min="";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat hours = new SimpleDateFormat("HH");
		SimpleDateFormat minu = new SimpleDateFormat("mm");
		SimpleDateFormat ampm = new SimpleDateFormat("aa");

		Hrs=hours.format(cal.getTime());
		Min=minu.format(cal.getTime());
		ampms=ampm.format(cal.getTime());

		Hours=Integer.parseInt(Hrs);
		minutes=Integer.parseInt(Min);
		minutes = minutes+=4;
		while(minutes>=60 || Hours>=24)
		{
			if(minutes>=60)
			{
				Hours+=1;
				leftoverminute=minutes;
				leftoverminute-=60;
				minutes=leftoverminute;

			}
			if(Hours>=24)
			{
				int leftoverhrs=Hours;
				leftoverhrs-=24;
				Hours=leftoverhrs;
			}
		}

		System.out.println(Hours + ":" + minutes);
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
