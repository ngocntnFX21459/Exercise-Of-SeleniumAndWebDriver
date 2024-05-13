package THLan1;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaiThucHanh {
/*
 * ● Gọi trình duyệt Google Chrome.
● Mở URL: https://www.google.com.vn/
● Cài đặt thời gian tải trang không vượt quá 15s.
● Nhấp vào hộp văn bản Tìm kiếm của Google.
● Nhập giá trị “selenium”
● Bấm vào nút Tìm kiếm.(“Tìm trên google”)
● Đóng trình duyệt.
 */
WebDriver driver;
String Text = "selenium";
@BeforeClass
public void openBrowser() {
	String pathDriver = "./driver/chromedriver.exe";
	System.setProperty("webdriver.chrome.driver", pathDriver);
	driver = new ChromeDriver();
	String URL = "https://www.google.com.vn/";
	driver.get(URL);
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
	
}
@Test
private void findSearchBox() throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("APjFqb")));
	searchBox.sendKeys(Text);
WebElement btnSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("btnK")));
btnSearch.click();
Thread.sleep(2000);
}
@AfterClass
private void closeBrowser() {
	driver.close();

}
}
