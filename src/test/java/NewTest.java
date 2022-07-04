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
import org.openqa.selenium.Point;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class NewTest{


	@org.testng.annotations.Test
	public void new1() throws IOException, InterruptedException
	{
		int Hours;
		int minutes;
		int leftoverminute;
		String Hrs="";
		String Min="";
		String ampms="";
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

		System.out.println(Hours + ":" + minutes +":"+ampms);
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


