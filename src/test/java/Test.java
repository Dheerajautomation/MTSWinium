import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.io.FileUtils;  

public class Test {  
	
	 static Connection conn = null;  
		 public  Connection connect() throws ClassNotFoundException, IOException, InterruptedException {  
			
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

			 } catch (SQLException e) {  
				 System.out.println(e.getMessage());  
			 } 
			 
			return conn;
		 }
		 public  void selectAll() throws ClassNotFoundException, IOException, InterruptedException{  
		        String sql = " select * from idsip where FilterString='192.168.1.202'";  
		        ResultSet rs = null;
		        String ip="";
		        try {  
		            Connection conn = this.connect(); 
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
		 
		
	        
		 /** 
		  * select * from idsip where FilterString='192.168.1.201';
		  * @param args the command line arguments 
		 * @throws ClassNotFoundException 
		 * @throws InterruptedException 
		  */  
		  public static void main(String[] args) throws ClassNotFoundException, IOException, InterruptedException {  
				 
				 Test t1=new Test();
				// t1.connect();
				t1.selectAll();
				 
			 }  
		 }    


