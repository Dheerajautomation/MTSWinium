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
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Test {
	Log ids;
	Connection conn = null; 
@org.testng.annotations.Test

public void IDSRun() throws InterruptedException, IOException, ClassNotFoundException {
	
	ids=new Log("C:\\Users\\Automation\\eclipse-workspace\\MTSWinium\\Logs\\Firewall\\MaxIDS.txt");
	ids.logger.info("********************************* STARTING MAX IDS TEST********************************************");
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
	ids.logger.info("Added IP and Saved successfully");
	Thread.sleep(2000);
	driver.findElement(By.name("OK")).click();	
	Runtime.getRuntime().exec("TASKKILL /F /IM MaxSDUI.exe");
	Thread.sleep(2000);
	
	Runtime runTime = Runtime.getRuntime();
    String executablePath = "C:\\Users\\Automation\\eclipse-workspace\\MTSWinium\\AutoITScript\\RunProctectionPause.exe";
    Process process = runTime.exec(executablePath);
    ids.logger.info("Paused The Protection");
    Thread.sleep(4000);
    filecopy();
	/*
	 * findipinDB(); { String fl= findipinDB();
	 * 
	 * if(fl.equals("192.168.1.201")) {
	 * ids.logger.info("----------------------------------------------------------")
	 * ; ids.logger.info("#TEST-CASE NAME#:-FIREWALL MAX IDS ");
	 * ids.logger.info("----------------------------------------------------------")
	 * ; ids.logger.info("IP Address  \t"+fl+ "\t Successfully added");
	 * ids.logger.info("#TEST CASE STATUS# :- PASSED");
	 * 
	 * 
	 * } else {
	 * ids.logger.info("----------------------------------------------------------")
	 * ; ids.logger.info("#TEST-CASE NAME#:-FIREWALL MAX IDS ");
	 * ids.logger.info("----------------------------------------------------------")
	 * ; ids.logger.info("Unable to Add IP Address  \t"+fl+ "\t");
	 * ids.logger.info("#TEST CASE STATUS# :- FAILED"); } Thread.sleep(2000);
	 * IDSRunRemove(); }
	 */
}
	
	 public Connection IDS() throws InterruptedException, IOException, ClassNotFoundException
	 {
		 Connection conn = null; 
			 try {  
				  
				 String url = "jdbc:sqlite:C:\\Windows\\Temp\\pnp\\PnpFirewall.DB";  
				
				 Class.forName("org.sqlite.JDBC");
				 conn = DriverManager.getConnection(url);  

				 ids.logger.info("DB Connection Sucessfull");
				 
				 

			 } catch (SQLException e) {  
				 System.out.println(e.getMessage());  
				 ids.logger.info("DB Connection UnSucessfull");
			 } 
			 
			return conn;
			
		 }
	
	
	public String findipinDB() throws ClassNotFoundException, IOException, InterruptedException{  
		
		        String sql = " select * from idsip where FilterString='192.168.1.201'";  
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
		        
		     Runtime runTime = Runtime.getRuntime();
		        String executablePath = "C:\\Users\\Automation\\eclipse-workspace\\MTSWinium\\AutoITScript\\ProtectionResume.exe";
		        Process process1 = runTime.exec(executablePath);
		        ids.logger.info("Protection Resumed");
		        
		        return ip;
		    }  
		 
public void IDSRunRemove() throws InterruptedException, IOException, ClassNotFoundException {
		
		ids.logger.info("****************** STARTING MAX IDS REMOVE TEST*************************");
		DesktopOptions option = new DesktopOptions();
		option.setApplicationPath("C:\\Program Files\\Max Secure Total Security\\MaxSDUI.exe");
		WiniumDriver driver=new WiniumDriver(new URL("http://localhost:9999"),option);
		driver.findElement(By.name("Protection Center")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("Max IDS")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("5141")).click();
		driver.findElement(By.id("5206")).click();
		driver.findElement(By.name("Delete")).click();
		Thread.sleep(800);
		driver.findElement(By.name("Yes")).click();
		Thread.sleep(800);
		driver.findElement(By.name("OK")).click();
		Runtime.getRuntime().exec("TASKKILL /F /IM MaxSDUI.exe");
		Thread.sleep(2000);
		Runtime runTime = Runtime.getRuntime();
	    String executablePath = "C:\\Users\\Automation\\eclipse-workspace\\MTSWinium\\AutoITScript\\RunProctectionPause.exe";
	    Process process = runTime.exec(executablePath);
	    ids.logger.info("Paused The Protection");
	    Thread.sleep(4000);
	    filecopy();
	    findipinDB();
	
	    
	    ids.logger.info("********************************* END MAX IDS TEST********************************************");
	}
			
		public void filecopy() {
			
			File source = new File("C://Program Files/Max Secure Total Security/MaxPnP");
			 File dest = new File("C:\\Windows\\Temp\\pnp");
			 try {
			     FileUtils.copyDirectory(source, dest);
			     
			     ids.logger.info("Copied MAXPNP.db to Temp Folder");
			 } catch (IOException e) {
			     e.printStackTrace();
			    
			     ids.logger.info("Unable to Copy MAXPNP.db to Temp Folder");
			 }
		} 
	 

	 
	@BeforeMethod
	public void beforeMethod() throws IOException {

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Automation\\eclipse-workspace\\MTSWinium\\chromedriver\\chromedriver.exe");
		

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
	

		 