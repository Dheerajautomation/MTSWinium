import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {
	
	public Logger logger;
	FileHandler fh;

	public Log(String filename) throws IOException {
	
		
		File f=new File(filename);
		if(!f.exists())
		{
			f.createNewFile();
		}
		
		fh = new FileHandler(filename ,true);
		logger=Logger.getLogger("test");
		logger.addHandler(fh);
		
		
		 System.setProperty("java.util.logging.SimpleFormatter.format", 
		            "%1$tF %1$tT %4$s %5$s%6$s%n");
		 SimpleFormatter formatter=new SimpleFormatter();
		
		fh.setFormatter(formatter);
		
	

	}
	public void loggerhandleclose()
	{
		if(fh != null)
		{
			fh.close();
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		Log mylog=new Log("C:\\Users\\Automation\\eclipse-workspace\\MTSWinium\\Logs\\Log1.txt");
		mylog.logger.info("-------------------------------------------------------------------------");
		mylog.logger.info("TEST PASSED");
		mylog.logger.info("-------------------------------------------------------------------------");
		mylog.logger.info("Created Directory");
		mylog.logger.info("Created Pattern");
		mylog.logger.info("Clicked on Applynow button");
		mylog.logger.info("Test Cleared");
		mylog.logger.warning("Test FAILED");
	}
}
