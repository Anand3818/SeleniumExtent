package coatsDigital;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SystemProperties {
	public static Properties sys; 
//	public static int LONG_WAIT_TIMEOUT_MILLIS;
	
	public SystemProperties() throws IOException {
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"//system.property");
		sys = new Properties();
		sys.load(fs);
	}
	
	public static int LONG_WAIT_TIMEOUT_MILLIS = Integer.parseInt(sys.getProperty("LONG_WAIT_TIMEOUT_MILLIS"));
	public static int SHORT_WAIT_TIMEOUT_MILLIS = Integer.parseInt(sys.getProperty("SHORT_WAIT_TIMEOUT_MILLIS"));
	public static int GENERIC_PAGE_WAIT_TIMEOUT_MILLIS = Integer.parseInt(sys.getProperty("GENERIC_PAGE_WAIT_TIMEOUT_MILLIS"));
}
