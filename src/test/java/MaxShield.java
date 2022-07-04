import static com.sun.jna.platform.win32.WinReg.HKEY_LOCAL_MACHINE;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import com.sun.jna.platform.win32.Advapi32Util;

public class MaxShield {


	int HomepageProtection;
	int trackingcookies;
	int activemonitor;
	int fileassociation;
	int windowsrestriction;
	int IERestriction;

	//@org.testng.annotations.Test
	public void Alloff() throws InterruptedException, IOException {
		Log logger1=new Log("C:\\Users\\Automation\\eclipse-workspace\\MTSWinium\\Logs\\Firewall\\Allow_All_BlockWebsite.txt");
		//ProcessBuilder bd = new ProcessBuilder("C:\\Users\\Automation\\eclipse-workspace\\MTSWinium\\AutoITScript\\MaxShield\\shieldAllOFF.exe");
		//bd.start();
		//Thread.sleep(20000);
		//Runtime.getRuntime().exec("TASKKILL /F /IM MaxSDUI.exe");

		HomepageProtection=Advapi32Util.registryGetIntValue(HKEY_LOCAL_MACHINE,"SOFTWARE\\Max Secure Total Security\\Active Protection", "HomePage");
		trackingcookies=Advapi32Util.registryGetIntValue(HKEY_LOCAL_MACHINE,"SOFTWARE\\Max Secure Total Security\\Active Protection", "TrackingCookie");
		activemonitor=Advapi32Util.registryGetIntValue(HKEY_LOCAL_MACHINE,"SOFTWARE\\Max Secure Total Security\\Active Protection", "ProcessMonitor");
		fileassociation=Advapi32Util.registryGetIntValue(HKEY_LOCAL_MACHINE,"SOFTWARE\\Max Secure Total Security\\Active Protection", "FileAssocMonitor");
		windowsrestriction=Advapi32Util.registryGetIntValue(HKEY_LOCAL_MACHINE,"SOFTWARE\\Max Secure Total Security\\Active Protection", "WinRestrictionMonitor");
		IERestriction=Advapi32Util.registryGetIntValue(HKEY_LOCAL_MACHINE,"SOFTWARE\\Max Secure Total Security\\Active Protection", "IERestrictionMonitor");

		System.out.println("Homepage Protection \t"+HomepageProtection);
		System.out.println("Tracking Cookies \t "+trackingcookies);
		System.out.println("Active Monitor \t"+activemonitor);
		System.out.println("File Association \t"+fileassociation);
		System.out.println("Windows Restriction \t"+windowsrestriction);
		System.out.println("IE Restriction \t"+IERestriction);


	}
	@org.testng.annotations.Test
	public void HomepageProtection() throws InterruptedException, IOException {

		ProcessBuilder bd = new ProcessBuilder("C:\\Users\\Automation\\eclipse-workspace\\MTSWinium\\AutoITScript\\MaxShield\\shieldIE.exe");
		bd.start();
		Thread.sleep(10000);
		Runtime.getRuntime().exec("TASKKILL /F /IM MaxSDUI.exe");

		//Process runtime = Runtime.getRuntime().exec("cmd /c inetcpl.cpl");
		DesktopOptions option = new DesktopOptions();
		Thread.sleep(3000);
		option.setApplicationPath("C:\\Windows\\System32\\inetcpl.cpl");
		WiniumDriver driver=new WiniumDriver(new URL("http://localhost:9999"),option);
		driver.findElement(By.id("1487")).click();
		driver.findElement(By.id("1487")).sendKeys("www");
		driver.findElement(By.id("12321")).click();
		Thread.sleep(3000);

		//ProcessBuilder openie = new ProcessBuilder("cmd.exe","inetcpl.cpl");
		//openie.start();
	}



}
