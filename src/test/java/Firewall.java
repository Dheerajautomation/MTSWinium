import static com.sun.jna.platform.win32.WinReg.HKEY_LOCAL_MACHINE;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sun.jna.platform.win32.Advapi32Util;

public class Firewall {

	WebDriver wdriver;
	String timetobeselectedweedays="";
	String timetobeselectedweekends="";
	String IPAddress="192.168.1.201";
	String Application_RuleEXEName ="chrome.exe";
	String sitetobeblocked="https://www.snapdeal.com";
	//@Test(priority = -1)
	public void Allow_All_BlockWebsite() throws InterruptedException, IOException {
		Log logger1=new Log("C:\\Users\\Automation\\eclipse-workspace\\MTSWinium\\Logs\\Firewall\\Allow_All_BlockWebsite.txt");
		DesktopOptions option = new DesktopOptions();
		logger1.logger.info("Started Firewall Allow All Block Website Test");
		option.setApplicationPath("C:\\Program Files\\Max Secure Total Security\\MaxSDUI.exe");
		WiniumDriver driver=new WiniumDriver(new URL("http://localhost:9999"),option);
		logger1.logger.info("Started UI");
		driver.findElement(By.name("Protection Center")).click();
		driver.findElement(By.name("Blocked List")).click();
		logger1.logger.info("Successfully Clicked On Blocked List");
		driver.findElement(By.name("Add")).click();
		driver.findElement(By.id("5208")).sendKeys(sitetobeblocked);
		logger1.logger.info("Added Site to be Blocked\t"+sitetobeblocked);
		driver.findElement(By.name("OK")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("OK")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("5026")).click();
		driver.findElement(By.name("OK")).click();
		logger1.logger.info("Successfully saved the Setting");
		driver.close();
		
		Thread.sleep(2000);
		wdriver = new ChromeDriver();
		wdriver.manage().window().maximize(); 
		wdriver.navigate().to(sitetobeblocked); 
		
		try {
			String blocked = wdriver.findElement(By.xpath("//span[contains(text(),'This Content is blocked by')]")).getText();
			System.out.println(blocked);
			logger1.logger.info("----------------------------------------------------------");
			logger1.logger.info("#TEST-CASE NAME#:-FIREWALL ALLOW ALL BLOCK WEBSITE ");
			logger1.logger.info("----------------------------------------------------------");
			logger1.logger.info("Website\t"+sitetobeblocked+ "\tis Sucessfully Blocked By Antivirus");
			logger1.logger.info("#TEST CASE STATUS# :- PASSED");
		}
		catch(Exception e)
		{
			logger1.logger.info("------------------------------------------------------------");
			logger1.logger.info("#TEST-CASE NAME#:-FIREWALL ALLOW ALL BLOCK WEBSITE");
			logger1.logger.info("-------------------------------------------------------------");
			logger1.logger.info("Website\t"+sitetobeblocked+ "\\tis Not Blocked By Antivirus\"");
			logger1.logger.info("#TEST CASE STATUS# :-FAILED");
			wdriver.close();
		}
	
		wdriver.close();
		wdriver.quit();
		
		Allow_All_BlockWebsite_Remove();
		logger1.logger.info("Running Allow_All_BlockWebsite_Remove Function ");
		wdriver = new ChromeDriver();
		wdriver.manage().window().maximize(); 
		wdriver.navigate().to(sitetobeblocked); 
		
		try {
			String blocked = wdriver.findElement(By.xpath("//span[contains(text(),'This Content is blocked by')]")).getText();
			System.out.println(blocked);
			logger1.logger.info("-----------------------------------------------------------------");
			logger1.logger.info("#TEST-CASE NAME#:-FIREWALL ALLOW ALL BLOCK WEBSITE REMOVE ");
			logger1.logger.info("-----------------------------------------------------------------");
			logger1.logger.info("Website "+sitetobeblocked +"\tis Sucessfully Blocked By Antivirus");
			logger1.logger.info("#TEST CASE STATUS# :- FAILED");
			logger1.loggerhandleclose();
			
		}
		catch(Exception e)
		{
			logger1.logger.info("--------------------------------------------------------------");
			logger1.logger.info("#TEST-CASE NAME#:-FIREWALL ALLOW ALL BLOCK WEBSITE REMOVE");
			logger1.logger.info("---------------------------------------------------------------");
			logger1.logger.info("Website"+sitetobeblocked+ "\tis Unblocked By Antivirus\"");
			logger1.logger.info("#TEST CASE STATUS# :-PASSED");
			logger1.loggerhandleclose();
			wdriver.close();
		}
		
		wdriver.close();
		wdriver.quit();
		
		Thread.sleep(2000);
		driver.close();
		
	}

	
	public void Allow_All_BlockWebsite_Remove() throws IOException {
		
	
		DesktopOptions option = new DesktopOptions();
		option.setApplicationPath("C:\\Program Files\\Max Secure Total Security\\MaxSDUI.exe");
		WiniumDriver driver=new WiniumDriver(new URL("http://localhost:9999"),option);	
		driver.findElement(By.name("Protection Center")).click();
		driver.findElement(By.name("Blocked List")).click();
		driver.findElement(By.id("5142")).click();
		driver.findElement(By.name("Delete")).click();
		driver.findElement(By.name("Yes")).click();
		driver.findElement(By.name("Save")).click();
		driver.findElement(By.name("OK")).click();
		driver.close();
		
	}
	
	//Testing is Remaining Blocker Bug
	public void Block_All_AllowWebsite() throws MalformedURLException, InterruptedException {
		
		String Whitelistsite="https://www.amazon.com";
		String ALLOtherBlockedSiteSample="https://www.flipkart.com";
		
		DesktopOptions option = new DesktopOptions();
		option.setApplicationPath("C:\\Program Files\\Max Secure Total Security\\MaxSDUI.exe");
		WiniumDriver driver=new WiniumDriver(new URL("http://localhost:9999"),option);

		driver.findElement(By.name("Protection Center")).click();
		driver.findElement(By.id("5005")).click();
		driver.findElement(By.id("5007")).click();
		driver.findElement(By.name("Allowed List")).click();
		driver.findElement(By.name("Add")).click();
		driver.findElement(By.id("5208")).sendKeys(Whitelistsite);
		driver.findElement(By.name("OK")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("OK")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("5026")).click();
		driver.findElement(By.name("OK")).click();
		driver.close();
		
		Thread.sleep(2000);
		wdriver = new ChromeDriver();
		wdriver.manage().window().maximize(); 
		wdriver.navigate().to(Whitelistsite); 
		
		try {
			String title_of_White_site=wdriver.getCurrentUrl();
			
			if(title_of_White_site.equals("https://www.amazon.com/"))
			{
				System.out.println("Website"+Whitelistsite+ "\tis Sucessfully Whitelisted By Antivirus");
			}
			else
			{
				System.out.println("Website"+Whitelistsite+ "\twas unable to Whitelist By Antivirus");
					
			}
			wdriver.switchTo().newWindow(WindowType.TAB);
			wdriver.navigate().to(ALLOtherBlockedSiteSample);
			
			try {
				
				String Block = wdriver.findElement(By.xpath("//span[contains(text(),'This Content is blocked by')]")).getText();
				System.out.println(Block);
			}
			catch(Exception d)
			{
				System.out.println("Block All is Not Working");
			}
			
			
		}
		catch(Exception e)
		{
			
			wdriver.close();
		}
		Thread.sleep(2000);
	 }
	//@Test(priority = 1)
	public void portblocker() throws InterruptedException, IOException {
		
		Log logger2=new Log("C:\\Users\\Automation\\eclipse-workspace\\MTSWinium\\Logs\\Firewall\\PortBlocker.txt");
		DesktopOptions option = new DesktopOptions();
		option.setApplicationPath("C:\\Program Files\\Max Secure Total Security\\MaxSDUI.exe");
		logger2.logger.info("Started Firewall Port Blocker Test");
		WiniumDriver driver=new WiniumDriver(new URL("http://localhost:9999"),option);
		logger2.logger.info("Opened UI");
		driver.findElement(By.name("Protection Center")).click();
		driver.findElement(By.id("10017")).click();
		driver.findElement(By.id("5141")).click();
		logger2.logger.info("Successfully Clicked On PortBlocker");
		Thread.sleep(1000);
		try {
			
		driver.findElement(By.name("Add")).click();
		logger2.logger.info("Clicked on ADD Button");
		}
		catch(Exception e){
			
			logger2.logger.info("Unable to Click on ADD Button..Retrying");
			driver.findElement(By.id("5141")).click();
			driver.findElement(By.name("Add")).click();
			logger2.logger.info("Clicked on ADD Button");
		}
		WebElement nextWindow = driver.findElement(By.name("Block Computers"));
		nextWindow.click();
		driver.findElement(By.id("5199")).sendKeys(IPAddress);
		logger2.logger.info("Added IP Address");
		driver.findElement(By.id("5191")).sendKeys("0");
		logger2.logger.info("Added Port Number");
		driver.findElement(By.name("OK")).click();
		driver.findElement(By.name("OK")).click();
		driver.findElement(By.name("Save")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("OK")).click();
		logger2.logger.info("Successfully saved the Setting");
		driver.close();
        Thread.sleep(3000);
        check();
        boolean bSStatus =check();
        if(bSStatus == true) {
        	logger2.logger.info("---------------------------------------------------");
        	logger2.logger.info("#TEST-CASE NAME#:- ADD IP,PORT TO BLOCK ");
        	logger2.logger.info("---------------------------------------------------");
        	logger2.logger.info("IP Port Blocked Successfully ");
        	logger2.logger.info("#TEST CASE STATUS# :- PASSED");
        }
        else if(bSStatus==false)
        {
        	logger2.logger.info("---------------------------------------------------");
        	logger2.logger.info("#TEST-CASE NAME#:- ADD IP,PORT TO BLOCK");
        	logger2.logger.info("---------------------------------------------------");
        	logger2.logger.info("Unable To Block IP Port ");
        	logger2.logger.info("#TEST CASE STATUS# :-FAILED");
        }
        Thread.sleep(2000);
        delete();
        Thread.sleep(2000);
        boolean bStatus =check();
        if(bStatus==true)
        {
        	logger2.logger.info("---------------------------------------------------");
        	logger2.logger.info("#TEST-CASE NAME#:- DELETE IP TO UNBLOCK IT ");
        	logger2.logger.info("---------------------------------------------------");
        	logger2.logger.info("Unable to UnBlocked IP Port ");
        	logger2.logger.info("#TEST CASE STATUS# :-FAILED");
        }
        else if(bStatus==false)
        {
        	logger2.logger.info("---------------------------------------------------");
        	logger2.logger.info("#TEST-CASE NAME#:- DELETE IP TO UNBLOCK IT ");
        	logger2.logger.info("---------------------------------------------------");
        	logger2.logger.info("IP Port UnBlocked Successfully ");
        	logger2.logger.info("#TEST CASE STATUS# :- PASSED");
        }
        logger2.loggerhandleclose();
        Thread.sleep(2000);	
	}
	
	public boolean check()
	
	{
        try {
            
        String ftpUrl = "ftp://"+ IPAddress;
		URL url = new URL(ftpUrl);

		URLConnection conn = url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null) ;
		in.close();

        }
        catch(Exception e) {
        	return true;
        	
        }
    	
        return false;
	}
	
	public void delete() throws MalformedURLException, InterruptedException
	{
		DesktopOptions option = new DesktopOptions();
		option.setApplicationPath("C:\\Program Files\\Max Secure Total Security\\MaxSDUI.exe");
		WiniumDriver driver=new WiniumDriver(new URL("http://localhost:9999"),option);
		driver.findElement(By.name("Protection Center")).click();
		driver.findElement(By.id("10017")).click();
		driver.findElement(By.id("5141")).click();
		Thread.sleep(1000);
		try {
		driver.findElement(By.name("Delete")).click();
		}
		catch(Exception e){
			
			driver.findElement(By.id("5141")).click();
			driver.findElement(By.name(IPAddress)).click();
			driver.findElement(By.name("Delete")).click();
		}
	
		  driver.findElement(By.name("Yes")).click();
		  driver.findElement(By.name("OK")).click();
		  driver.findElement(By.name("Save")).click();
		  driver.findElement(By.name("OK")).click();
		  driver.findElement(By.id("5141")).click();
		  driver.findElement(By.name("Save")).click();
		  driver.findElement(By.name("OK")).click(); 
		  driver.close();
		  Thread.sleep(2000);
		
	}
	//@Test(priority = 2)
	public void Application_Rule() throws InterruptedException, IOException
	{
		
		Log logger3=new Log("C:\\Users\\Automation\\eclipse-workspace\\MTSWinium\\Logs\\Firewall\\ApplicationRule.txt");
		DesktopOptions option = new DesktopOptions();
		logger3.logger.info("Started Application Rule Test");
		option.setApplicationPath("C:\\Program Files\\Max Secure Total Security\\MaxSDUI.exe");
		logger3.logger.info("Successfully Configured MaxSDUI.exe");
		WiniumDriver driver=new WiniumDriver(new URL("http://localhost:9999"),option);
		logger3.logger.info("Initialization of Driver");
		logger3.logger.info("Successfully Opened the Application");
		driver.findElement(By.name("Protection Center")).click();
		logger3.logger.info("Successfully Clicked on Protection Center");
		driver.findElement(By.name("Application Rules")).click();
		logger3.logger.info("Successfully Clicked on Application Rules");
		driver.findElement(By.id("5141")).click();
		logger3.logger.info("Successfully Clicked on CheckBox for Internet Blocking");
		driver.findElement(By.id("5027")).click();
		logger3.logger.info("Successfully Clicked on Textbox");
		driver.findElement(By.id("5027")).sendKeys(Application_RuleEXEName);
		logger3.logger.info("Successfully Entered the exe Name");
		driver.findElement(By.name("Add")).click();
		logger3.logger.info("Successfully Added ");
		driver.findElement(By.name("Save")).click();
		logger3.logger.info("Successfully Saved ");
		driver.findElement(By.name("OK")).click();
		driver.close();
		Thread.sleep(1000);
		boolean status=apprulechecker();
		if(status==true)
		{
			logger3.logger.info("---------------------------------------------------");
			logger3.logger.info("#TEST-CASE NAME#:- APPLICATION RULE APP INTERNET BLOCK ");
			logger3.logger.info("---------------------------------------------------");
			logger3.logger.info(Application_RuleEXEName +"\tInternet Blocked Sucessfull");
			logger3.logger.info("#TEST CASE STATUS# :- PASSED");
		}
		else if(status==false)
		{
			logger3.logger.info("---------------------------------------------------");
			logger3.logger.info("#TEST-CASE NAME#:- APPLICATION RULE APP INTERNET BLOCK ");
			logger3.logger.info("---------------------------------------------------");
			logger3.logger.info(Application_RuleEXEName +"\tInternet Blocked Unsucessfull");
			logger3.logger.info("#TEST CASE STATUS# :-FAILED");
		}
		Thread.sleep(1000);
		appruledeletechecker();
		boolean deletestatus=apprulechecker();
		if(deletestatus==true)
		{
			logger3.logger.info("---------------------------------------------------");
			logger3.logger.info("#TEST-CASE NAME#:- APPLICATION RULE APP INTERNET BLOCK REMOVE ");
			logger3.logger.info("---------------------------------------------------");
			logger3.logger.info(Application_RuleEXEName +"\tInternet Un-Blocked UnSucessfull");
			logger3.logger.info("#TEST CASE STATUS# :-FAILED");
		}
		else if(deletestatus==false)
		{
			logger3.logger.info("---------------------------------------------------");
			logger3.logger.info("#TEST-CASE NAME#:- APPLICATION RULE APP INTERNET BLOCK REMOVE");
			logger3.logger.info("---------------------------------------------------");
			logger3.logger.info(Application_RuleEXEName +"\tInternet Un-Blocked Sucessfull");
			logger3.logger.info("#TEST CASE STATUS# :- PASSED");
		}
		logger3.loggerhandleclose();
		Thread.sleep(2000);
	}
	
	
	public boolean apprulechecker()
	{
		wdriver = new ChromeDriver();
		wdriver.manage().window().maximize(); 
		try {
		wdriver.navigate().to("http://www.google.com"); 
		String title = wdriver.getTitle();
		}
		catch(Exception e)
		{
			wdriver.close();
			return true;
			
		}
		wdriver.close();
		
		return false;
	}
	
	
	public void appruledeletechecker() throws MalformedURLException, InterruptedException
	{
		DesktopOptions option = new DesktopOptions();
		option.setApplicationPath("C:\\Program Files\\Max Secure Total Security\\MaxSDUI.exe");
		WiniumDriver driver=new WiniumDriver(new URL("http://localhost:9999"),option);
		driver.findElement(By.name("Protection Center")).click();
		driver.findElement(By.name("Application Rules")).click();
		driver.findElement(By.id("5141")).click();
		try {
		driver.findElement(By.name("Delete")).click();
		}
		catch(Exception e)
		{
			driver.findElement(By.id("5141")).click();
			try {
			driver.findElement(By.id("5142")).click();
			driver.findElement(By.name("Delete")).click();
			driver.findElement(By.name("Yes")).click();
			driver.findElement(By.name("Save")).click();
			driver.findElement(By.name("OK")).click();
			driver.findElement(By.id("5141")).click();
			}
			catch(Exception en)
			{
				driver.close();
			}
			
			
		}
		
		driver.close();
		Thread.sleep(2000);
	}
	//@Test(priority = 0)
public void parentalcontrol() throws InterruptedException, IOException {
		 
	Log logger4=new Log("C:\\Users\\Automation\\eclipse-workspace\\MTSWinium\\Logs\\Firewall\\ParentalControl.txt");
	logger4.logger.info("********************************* STARTING PARENTAL CONTROL TEST********************************************");
	DesktopOptions option = new DesktopOptions();
	option.setApplicationPath("C:\\Users\\Automation\\eclipse-workspace\\MTSWinium\\AutoITScript\\RegParentalCntrl.exe");
	WiniumDriver driver=new WiniumDriver(new URL("http://localhost:9999"),option);
	Thread.sleep(15000);
	
	logger4.logger.info("******************* STARTING CATEGORY BLOCK TEST *******************");
	driver.findElement(By.name("Categories")).click();
	driver.findElement(By.id("5106")).click();
	try {
	driver.findElement(By.id("5107")).click();//social site
	}
	catch(Exception e)
	{
		driver.findElement(By.id("5106")).click();
		driver.findElement(By.id("5107")).click();//social site
	}
	Thread.sleep(1000);
	driver.findElement(By.id("5118")).click(); //online store
	Thread.sleep(1000);
	driver.findElement(By.name("OK")).click();
	Thread.sleep(1000);
	driver.findElement(By.name("OK")).click();
	logger4.logger.info("Entered Website and Saved the Setting");
	Runtime.getRuntime().exec("TASKKILL /F /IM MaxSDUI.exe");
	logger4.logger.info("Checking Whether Website is Blocked or Not");
	wdriver = new ChromeDriver();
	wdriver.manage().window().maximize();
	wdriver.navigate().to("https://www.flipkart.com");
	String title=wdriver.getCurrentUrl();
	
	try {
		String blocked = wdriver.findElement(By.xpath("//span[contains(text(),'This Content is blocked by')]")).getText();
		System.out.println(blocked);
		logger4.logger.info("--------------------------------------------------------------------------");
		logger4.logger.info("#TEST-CASE NAME#:-FIREWALL PARENTAL CONTROL CATEGORY(SHOPPING) BLOCK ");
		logger4.logger.info("--------------------------------------------------------------------------");
		logger4.logger.info("Website is Sucessfully Blocked By Antivirus");
		logger4.logger.info("#TEST CASE STATUS# :- PASSED");
		wdriver.close();
		
	}
	catch(Exception e)
	{
		logger4.logger.info("------------------------------------------------------------------------");
		logger4.logger.info("#TEST-CASE NAME#:-FIREWALL PARENTAL CONTROL CATEGORY(SHOPPING) BLOCK");
		logger4.logger.info("------------------------------------------------------------------------");
		logger4.logger.info("Unable to Block Website By Antivirus");
		logger4.logger.info("#TEST CASE STATUS# :-FAILED");
		
		wdriver.close();
	}
		
		
		wdriver = new ChromeDriver();
		wdriver.manage().window().maximize(); 
		wdriver.navigate().to("https://www.twitter.com");
		String title1=wdriver.getCurrentUrl();
	
		try {
			String blocked = wdriver.findElement(By.xpath("//span[contains(text(),'This Content is blocked by')]")).getText();
			System.out.println(blocked);
			logger4.logger.info("--------------------------------------------------------------------------------");
			logger4.logger.info("#TEST-CASE NAME#:-FIREWALL PARENTAL CONTROL CATEGORY(SOCIAL NETWORK) BLOCK");
			logger4.logger.info("--------------------------------------------------------------------------------");
			logger4.logger.info("Website is Sucessfully Blocked By Antivirus");
			logger4.logger.info("#TEST CASE STATUS# :- PASSED");
			wdriver.close();
			
		}
		catch(Exception e)
		{
			logger4.logger.info("-------------------------------------------------------------------------------");
			logger4.logger.info("#TEST-CASE NAME#:-FIREWALL PARENTAL CONTROL CATEGORY(SOCIAL NETWORK) BLOCK");
			logger4.logger.info("-------------------------------------------------------------------------------");
			logger4.logger.info("Unable to Block Website By Antivirus");
			logger4.logger.info("#TEST CASE STATUS# :-FAILED");
			
			wdriver.close();
		}
		
		
		//DesktopOptions option1 = new DesktopOptions();
		option.setApplicationPath("C:\\Users\\Automation\\eclipse-workspace\\MTSWinium\\AutoITScript\\OpenFirewall.exe");
		WiniumDriver driver6=new WiniumDriver(new URL("http://localhost:9999"),option);
		Thread.sleep(15000);
		logger4.logger.info("******************* STARTING CATEGORY UNBLOCK TEST *******************");
		driver6.findElement(By.name("Categories")).click();
		driver6.findElement(By.id("5106")).click();
		Thread.sleep(1000);
		driver6.findElement(By.name("OK")).click();
		Thread.sleep(1000);
		driver6.findElement(By.name("OK")).click();
		Runtime.getRuntime().exec("TASKKILL /F /IM MaxSDUI.exe");
		
		
		wdriver = new ChromeDriver();
		wdriver.manage().window().maximize();
		wdriver.navigate().to("https://www.flipkart.com");
		
		
		try {
			String blocked = wdriver.findElement(By.xpath("//span[contains(text(),'This Content is blocked by')]")).getText();
			System.out.println(blocked);
			logger4.logger.info("--------------------------------------------------------------------------");
			logger4.logger.info("#TEST-CASE NAME#:-FIREWALL PARENTAL CONTROL CATEGORY UNBLOCK ");
			logger4.logger.info("--------------------------------------------------------------------------");
			logger4.logger.info("Unable to Unblock The Website  By Antivirus");
			logger4.logger.info("#TEST CASE STATUS# :- FAILED");
			wdriver.close();
			
		}
		catch(Exception e)
		{
			logger4.logger.info("------------------------------------------------------------------------");
			logger4.logger.info("#TEST-CASE NAME#:-FIREWALL PARENTAL CONTROL CATEGORY UNBLOCK");
			logger4.logger.info("------------------------------------------------------------------------");
			logger4.logger.info("UnBlocked Website By Antivirus");
			logger4.logger.info("#TEST CASE STATUS# :-PASSED");	
			wdriver.close();
		}
		
		
		
		DesktopOptions option1 = new DesktopOptions();
		option1.setApplicationPath("C:\\Users\\Automation\\eclipse-workspace\\MTSWinium\\AutoITScript\\OpenFirewall.exe");
		WiniumDriver driver1=new WiniumDriver(new URL("http://localhost:9999"),option);
		Thread.sleep(10000);
		logger4.logger.info("******************* STARTING WEBSITE BLOCK TEST *******************");
		driver1.findElement(By.name("Block Sites")).click();
		driver1.findElement(By.id("5206")).click();
		driver1.findElement(By.name("Add")).click();
		driver1.findElement(By.id("5208")).click();
		driver1.findElement(By.id("5208")).sendKeys("https://irctc.com");
		driver1.findElement(By.name("OK")).click();
		driver1.findElement(By.name("OK")).click();
		driver1.findElement(By.name("Save")).click();
		driver1.findElement(By.name("OK")).click();
		
		Runtime.getRuntime().exec("TASKKILL /F /IM MaxSDUI.exe");
		
		Thread.sleep(2000);
		wdriver = new ChromeDriver();
		wdriver.manage().window().maximize(); 
		wdriver.navigate().to("https://irctc.com");
		
		try {
			String blocked = wdriver.findElement(By.xpath("//span[contains(text(),'This Content is blocked by')]")).getText();
			System.out.println(blocked);
			logger4.logger.info("-----------------------------------------------------------------");
			logger4.logger.info("#TEST-CASE NAME#:-FIREWALL PARENTAL CONTROL BLOCK SITES");
			logger4.logger.info("-----------------------------------------------------------------");
			logger4.logger.info("Website is Sucessfully Blocked By Antivirus");
			logger4.logger.info("#TEST CASE STATUS# :- PASSED");
			wdriver.close();
			
		}
		catch(Exception e)
		{
			logger4.logger.info("--------------------------------------------------------------");
			logger4.logger.info("#TEST-CASE NAME#:-FIREWALL PARENTAL CONTROL BLOCK SITES");
			logger4.logger.info("---------------------------------------------------------------");
			logger4.logger.info("Unable to Block Website By Antivirus");
			logger4.logger.info("#TEST CASE STATUS# :-FAILED");
			
			wdriver.close();
		}
	
		
		//DesktopOptions option = new DesktopOptions();
		option.setApplicationPath("C:\\Users\\Automation\\eclipse-workspace\\MTSWinium\\AutoITScript\\OpenFirewall.exe");
		WiniumDriver driver7=new WiniumDriver(new URL("http://localhost:9999"),option);
		Thread.sleep(10000);
		logger4.logger.info("******************* STARTING WEBSITE UNBLOCK TEST *******************");
		driver7.findElement(By.name("Block Sites")).click();
		driver7.findElement(By.id("5142")).click();
		driver7.findElement(By.name("Delete")).click();
		driver7.findElement(By.name("Yes")).click();
		driver7.findElement(By.name("Save")).click();
		driver7.findElement(By.name("OK")).click();
		driver7.findElement(By.id("5206")).click();
		Thread.sleep(1000);
		Runtime.getRuntime().exec("TASKKILL /F /IM MaxSDUI.exe");
		
		Thread.sleep(2000);
		wdriver = new ChromeDriver();
		wdriver.manage().window().maximize(); 
		wdriver.navigate().to("https://irctc.com");
		
		try {
			String blocked = wdriver.findElement(By.xpath("//span[contains(text(),'This Content is blocked by')]")).getText();
			System.out.println(blocked);
			logger4.logger.info("-----------------------------------------------------------------");
			logger4.logger.info("#TEST-CASE NAME#:-FIREWALL PARENTAL CONTROL UNBLOCK SITES");
			logger4.logger.info("-----------------------------------------------------------------");
			logger4.logger.info("Unable to Unblock Website By Antivirus");
			logger4.logger.info("#TEST CASE STATUS# :- FAILED");
			wdriver.close();
			
		}
		catch(Exception e)
		{
			logger4.logger.info("--------------------------------------------------------------");
			logger4.logger.info("#TEST-CASE NAME#:-FIREWALL PARENTAL CONTROL UNBLOCK SITES");
			logger4.logger.info("---------------------------------------------------------------");
			logger4.logger.info("UnBlocked Website By Antivirus");
			logger4.logger.info("#TEST CASE STATUS# :-PASSED");
			
			wdriver.close();
		}
		
	
	
		
		logger4.logger.info("******************* STARTING INTERNET USAGE BLOCK TEST *******************");
		option.setApplicationPath("C:\\Users\\Automation\\eclipse-workspace\\MTSWinium\\AutoITScript\\OpenFirewall.exe");
		WiniumDriver driver2=new WiniumDriver(new URL("http://localhost:9999"),option);
		Thread.sleep(10000);
		
		driver2.findElement(By.name("Internet Usage")).click();
		Thread.sleep(800);
		driver2.findElement(By.name("Enable Internet Usage Blocking")).click();
		Thread.sleep(800);
		
		Format f = new SimpleDateFormat("HH.mm.ss Z"); 
        f = new SimpleDateFormat("EEEE");
        String day = f.format(new Date());
       
        if(day.equals("Monday")||day.equals("Tuesday")||day.equals("Wednesday")||day.equals("Thursday")||day.equals("Friday"))
        {
        	driver2.findElement(By.id("5093")).click();
        	Thread.sleep(2000);
        	selecttime();
            driver2.findElement(By.id(timetobeselectedweedays)).click();
            driver2.findElement(By.name("OK")).click();
            Thread.sleep(3000);
            Runtime.getRuntime().exec("TASKKILL /F /IM MaxSDUI.exe"); 
            Thread.sleep(1000);
            Runtime runTime = Runtime.getRuntime();
            String executablePath = "C:\\Users\\Automation\\eclipse-workspace\\MTSWinium\\AutoITScript\\intblockparental.exe";
            Process process = runTime.exec(executablePath);
            Thread.sleep(1000);
            Thread.sleep(23000);
            Runtime.getRuntime().exec("TASKKILL /F /IM MaxSDUI.exe");
            blockchecker();
            
           boolean Bstatus=blockchecker();
           if(Bstatus==true)
           {
        	logger4.logger.info("-----------------------------------------------------------------");
   			logger4.logger.info("#TEST-CASE NAME#:-FIREWALL PARENTAL CONTROL INTERNET BLOCK");
   			logger4.logger.info("-----------------------------------------------------------------");
   			logger4.logger.info("INTERNET Blocked By Antivirus");
   			logger4.logger.info("#TEST CASE STATUS# :- PASSED");
   			
   			
           }
           else if(Bstatus==false)
           {
        	   
        	   logger4.logger.info("-----------------------------------------------------------------");
        	   logger4.logger.info("#TEST-CASE NAME#:-FIREWALL PARENTAL CONTROL INTERNET BLOCK");
        	   logger4.logger.info("-----------------------------------------------------------------");
        	   logger4.logger.info("INTERNET Not Blocked By Antivirus");
        	   logger4.logger.info("#TEST CASE STATUS# :- FAILED");
        	 
        	   
           }
            		
        }
        else if(day.equals("Saturday")||day.equals("Sunday"))
        {
        	driver2.findElement(By.id("5096")).click();
        	Thread.sleep(2000);
        	selecttime();
        	driver2.findElement(By.id(timetobeselectedweekends)).click();
        	driver2.findElement(By.name("OK")).click();
        	Thread.sleep(3000);
            Runtime.getRuntime().exec("TASKKILL /F /IM MaxSDUI.exe"); 
            Runtime runTime = Runtime.getRuntime();
            String executablePath = "C:\\Users\\Automation\\eclipse-workspace\\MTSWinium\\AutoITScript\\intblockparental.exe";
            Process process = runTime.exec(executablePath);
            Thread.sleep(1000);
            Runtime.getRuntime().exec("TASKKILL /F /IM MaxSDUI.exe"); 
            Thread.sleep(19000);
        	blockchecker();
        	
        	 boolean Bstatus=blockchecker();
             if(Bstatus==true)
             {
            	 logger4.logger.info("-----------------------------------------------------------------");
     			logger4.logger.info("#TEST-CASE NAME#:-FIREWALL PARENTAL CONTROL INTERNET BLOCK");
     			logger4.logger.info("-----------------------------------------------------------------");
     			logger4.logger.info("INTERNET Blocked By Antivirus");
     			logger4.logger.info("#TEST CASE STATUS# :- PASSED");
     		
     			
             }
             else if(Bstatus==false)
             {
          	   logger4.logger.info("-----------------------------------------------------------------");
          	   logger4.logger.info("#TEST-CASE NAME#:-FIREWALL PARENTAL CONTROL INTERNET BLOCK");
          	   logger4.logger.info("-----------------------------------------------------------------");
          	   logger4.logger.info("INTERNET Not Blocked By Antivirus");
          	   logger4.logger.info("#TEST CASE STATUS# :- FAILED");
          	  
          	   
             }
             
        }
        logger4.logger.info("******************* STARTING INTERNET USAGE UNBLOCK TEST *******************");
        Runtime runTime = Runtime.getRuntime();
        String executablePath = "C:\\Users\\Automation\\eclipse-workspace\\MTSWinium\\AutoITScript\\intblockparentalRemove.exe";
        Process process = runTime.exec(executablePath);
        Thread.sleep(20000);
        Runtime.getRuntime().exec("TASKKILL /F /IM MaxSDUI.exe");
        blockchecker();
    	
      	 boolean Bstatus=blockchecker();
           if(Bstatus==true)
           {
          	 logger4.logger.info("--------------------------------------------------------------------");
   			logger4.logger.info("#TEST-CASE NAME#:-FIREWALL PARENTAL CONTROL INTERNET BLOCK REMOVE");
   			logger4.logger.info("-----------------------------------------------------------------");
   			logger4.logger.info("Unable to Unblock INTERNET By Antivirus");
   			logger4.logger.info("#TEST CASE STATUS# :- FAILED");
   			
   			
           }
           else if(Bstatus==false)
           {
        	   logger4.logger.info("-----------------------------------------------------------------");
        	   logger4.logger.info("#TEST-CASE NAME#:-FIREWALL PARENTAL CONTROL INTERNET BLOCK REMOVE");
        	   logger4.logger.info("-----------------------------------------------------------------");
        	   logger4.logger.info("INTERNET UNBlocked By Antivirus");
        	   logger4.logger.info("#TEST CASE STATUS# :- PASSED");
        	    
        	   
           }
		
           logger4.logger.info("******************* STARTING COMPUTER USAGE BLOCK TEST *******************");
           option.setApplicationPath("C:\\Users\\Automation\\eclipse-workspace\\MTSWinium\\AutoITScript\\OpenFirewall.exe");
           WiniumDriver driver9=new WiniumDriver(new URL("http://localhost:9999"),option); 
           Thread.sleep(10000);

           driver9.findElement(By.name("PC Usage")).click();
           Thread.sleep(800);
           driver9.findElement(By.name("Enable Computer usage blocking")).click();
           Thread.sleep(800);

           Format f1 = new SimpleDateFormat("HH.mm.ss Z"); 
           f1 = new SimpleDateFormat("EEEE");
           String day1 = f.format(new Date());

           if(day1.equals("Monday")||day1.equals("Tuesday")||day1.equals("Wednesday")||day1.equals("Thursday")||day1.equals("Friday"))
           {
        	   driver9.findElement(By.id("5093")).click();
        	   Thread.sleep(2000);
        	   selecttime();
        	   driver9.findElement(By.id(timetobeselectedweedays)).click();
        	   driver9.findElement(By.name("OK")).click();
        	   Thread.sleep(3000); 
        	   driver9.findElement(By.name("OK")).click();
        	   Runtime.getRuntime().exec("TASKKILL /F /IM MaxSDUI.exe");
        	   Thread.sleep(10000);
        	   try {
        		   driver9.findElement(By.name("Disable user control")).click();
        		   driver9.findElement(By.id("1094")).click();
        		   driver9.findElement(By.id("1094")).sendKeys("123456");
        		   driver9.findElement(By.name("Enter")).click();
        		   logger4.logger.info("-----------------------------------------------------------------");
            	   logger4.logger.info("#TEST-CASE NAME#:-FIREWALL PARENTAL CONTROL COMPUTER USAGE BLOCK");
            	   logger4.logger.info("-----------------------------------------------------------------");
            	   logger4.logger.info("Usage Blocked By Antivirus");
            	   logger4.logger.info("#TEST CASE STATUS# :- PASSED");
        		   
        	   }
        	   catch(Exception e)
        	   {
        		
        		   logger4.logger.info("-----------------------------------------------------------------");
            	   logger4.logger.info("#TEST-CASE NAME#:-FIREWALL PARENTAL CONTROL COMPUTER USAGE BLOCK");
            	   logger4.logger.info("-----------------------------------------------------------------");
            	   logger4.logger.info("Usage Did Not Blocked By Antivirus");
            	   logger4.logger.info("#TEST CASE STATUS# :- FAILED");
        	   }
           }
           else if(day1.equals("Saturday")||day1.equals("Sunday"))
           {
        	   driver9.findElement(By.id("5096")).click();
        	   Thread.sleep(2000);
        	   selecttime();
        	   driver9.findElement(By.id(timetobeselectedweekends)).click();
        	   driver9.findElement(By.name("OK")).click();
        	   driver9.findElement(By.name("OK")).click();
        	   Runtime.getRuntime().exec("TASKKILL /F /IM MaxSDUI.exe");
        	   Thread.sleep(10000);
        	   try {
        		   driver9.findElement(By.name("Disable user control")).click();
        		   driver9.findElement(By.id("1094")).click();
        		   driver9.findElement(By.id("1094")).sendKeys("123456");
        		   driver9.findElement(By.name("Enter")).click();
        		   logger4.logger.info("-----------------------------------------------------------------");
            	   logger4.logger.info("#TEST-CASE NAME#:-FIREWALL PARENTAL CONTROL COMPUTER USAGE BLOCK");
            	   logger4.logger.info("-----------------------------------------------------------------");
            	   logger4.logger.info("Usage Blocked By Antivirus");
            	   logger4.logger.info("#TEST CASE STATUS# :- PASSED");
        	   }
        	   catch(Exception e)
        	   {
        		   logger4.logger.info("-----------------------------------------------------------------");
            	   logger4.logger.info("#TEST-CASE NAME#:-FIREWALL PARENTAL CONTROL COMPUTER USAGE BLOCK");
            	   logger4.logger.info("-----------------------------------------------------------------");
            	   logger4.logger.info("Usage Did Not Blocked By Antivirus");
            	   logger4.logger.info("#TEST CASE STATUS# :- FAILED");
        	   }
           }
           
           option.setApplicationPath("C:\\Users\\Automation\\eclipse-workspace\\MTSWinium\\AutoITScript\\ParentalPassRemove.exe");
           WiniumDriver driver11=new WiniumDriver(new URL("http://localhost:9999"),option); 
           Thread.sleep(15000);
           Runtime.getRuntime().exec("TASKKILL /F /IM MaxSDUI.exe");
           logger4.logger.info("-----------------------------------------------------------------");
    	   logger4.logger.info("#TEST-CASE NAME#:-FIREWALL PARENTAL CONTROL COMPUTER USAGE BLOCK REMOVE AND REMOVE FIRWALL PASSWORD");
    	   logger4.logger.info("-----------------------------------------------------------------");
    	   logger4.logger.info("Removed Password From Parental Control");
    	   logger4.logger.info("#TEST CASE STATUS# :- PASSED");
    	   
    	   logger4.logger.info("********************************* ENDING PARENTAL CONTROL TEST********************************************");
	}
@Test
	 public Connection IDS() throws InterruptedException, IOException, ClassNotFoundException
	 {
		  Connection conn = null;  
		 	DesktopOptions option = new DesktopOptions();
			option.setApplicationPath("C:\\Program Files\\Max Secure Total Security\\MaxSDUI.exe");
			WiniumDriver driver=new WiniumDriver(new URL("http://localhost:9999"),option);
			driver.findElement(By.name("Protection Center")).click();
			Thread.sleep(2000);
			driver.findElement(By.name("Max IDS")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("5141")).click();
			driver.findElement(By.name("Add")).click();	
			driver.findElement(By.id("5199")).sendKeys("192.168.1.201");
			driver.findElement(By.name("OK")).click();	
			driver.findElement(By.name("Save")).click();	
			Thread.sleep(2000);
			driver.findElement(By.name("OK")).click();	
			Runtime.getRuntime().exec("TASKKILL /F /IM MaxSDUI.exe");
			Thread.sleep(2000);
			Runtime runTime = Runtime.getRuntime();
		    String executablePath = "C:\\Users\\Automation\\eclipse-workspace\\MTSWinium\\AutoITScript\\RunProctectionPause.exe";
		    Process process = runTime.exec(executablePath);
		    Thread.sleep(4000);
			 
			 File source = new File("C://Program Files/Max Secure Total Security/MaxPnP");
			 File dest = new File("C:\\Windows\\Temp\\pnp");
			 try {
			     FileUtils.copyDirectory(source, dest);
			     System.out.println("File Copied to Temp");
			 } catch (IOException e) {
			     e.printStackTrace();
			     System.out.println("Unable to copy to Temp");
			 }
			  
			
			 try {  
				 // db parameters  
				 String url = "jdbc:sqlite:C:\\Windows\\Temp\\pnp\\PnpFirewall.DB";  
				
				 Class.forName("org.sqlite.JDBC");
				 conn = DriverManager.getConnection(url);  

				 System.out.println("Connection to SQLite has been established."); 
				 selectAll();

			 } catch (SQLException e) {  
				 System.out.println(e.getMessage());  
			 } 
			 
			return conn;
			
		 }
	
	
	public void selectAll() throws ClassNotFoundException, IOException, InterruptedException{  
		        String sql = " select * from idsip where FilterString='192.168.1.202'";  
		        ResultSet rs = null;
		        String ip="";
		        try {  
		            Connection conn = this.IDS(); 
		            Statement stmt  = conn.createStatement();  
		            rs= stmt.executeQuery(sql);  
		                while (rs.next()) {  
		            
		                ip=rs.getString("FilterString");
		            	
		            }  
		        } catch (SQLException e) {  
		            System.out.println(e.getMessage()); 
		            
		        }  
		        if(ip.equals("192.168.1.201"))
            	{
            		System.out.println("String Found"+ "\t" +ip);
            		
            	}
            	else {
            		System.out.println("String Not Found");
				}
		       
		        Runtime runTime = Runtime.getRuntime();
		        String executablePath = "C:\\Users\\Automation\\eclipse-workspace\\MTSWinium\\AutoITScript\\ProtectionResume.exe";
		        Process process1 = runTime.exec(executablePath);
		    }  
		 
			
		 
	 
	public void selecttime() throws MalformedURLException { 
		
		String time="";
		Calendar cal = Calendar.getInstance(); 
		SimpleDateFormat sdf = new SimpleDateFormat("HH"); 
		time=sdf.format(cal.getTime()); 
		int Hrs=Integer.parseInt(time); //converting string time to integer
		int weekdaytime =101; //By Default id for weekdays of the date in UI int
		int weekendsdaytime =201;//By Default id for weekendsdays of the date in UI
		int timeintweek = Hrs; 
		int timeintweekends = Hrs; 
		timeintweek +=weekdaytime; //creating button id to be clicked on UI by adding hr for Weekday
		timeintweekends +=weekendsdaytime;//creating button id to be clicked on UI by adding hr for Weekends
		timetobeselectedweedays=String.valueOf(timeintweek); //creating string from int
		timetobeselectedweekends=String.valueOf(timeintweekends);

	}
	public boolean blockchecker() {
		
		try {
		    URL yahoo = new URL("http://www.google.com/");
	        URLConnection yc = yahoo.openConnection();
	        BufferedReader in = new BufferedReader( new InputStreamReader( yc.getInputStream()));
	        String inputLine;

	        while ((inputLine = in.readLine()) != null) ;
	        in.close();
	        return false;
			}
			catch(Exception e)
			{
				
				return true;
			}
	}
	 
	@BeforeMethod
	public void beforeMethod() throws IOException {

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Automation\\eclipse-workspace\\MTSWinium\\chromedriver\\chromedriver.exe");
		

	}
}
	

	
