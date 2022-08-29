package coatsDigital;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportUtility {
	public static ExtentReports report = reportsConfig();
	public static ExtentHtmlReporter htmlReporter;

	// = new
	// ExtentHtmlReporter(System.getProperty("user.dir")+"\\reports\\AutomationResult.html");
	/**
	 * @return
	 */
	public static ExtentHtmlReporter htmlConfiguration() {
		// ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(dynamicPath() +
		// "\\AutomationResult.html");
		File reportPath = new File(System.getProperty("user.dir") + "/target/extentReports");
		
		 if (!reportPath.exists()) {
			reportPath.mkdir();
		}
		htmlReporter = new ExtentHtmlReporter(
				reportPath + "_AutomationResult.html");
		htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
		htmlReporter.config().setReportName("Functional Testing"); // Name of the report
		htmlReporter.config().setTheme(Theme.DARK);
		return htmlReporter;
	}

	/**
	 * @param element
	 */
	// highlightText on screen
	public static void highlightText(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// use executeScript() method and pass the arguments
		// Here i pass values based on css style. Yellow background color with solid red
		// color border.
		js.executeScript("arguments[0].setAttribute('style', 'background: gray; border: 2px solid black;');", element);
	}

	/**
	 * @return
	 */
	public static ExtentReports reportsConfig() {
		report = new ExtentReports();
		report.attachReporter(htmlConfiguration());
		return report;
	}
}