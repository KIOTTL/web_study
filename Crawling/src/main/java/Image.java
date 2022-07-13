

import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Image {
	private static WebDriver driver;
//	static JavascriptExecutor jse = (JavascriptExecutor)driver;
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";	// 크롬 드라이버
	public static final String WEB_DRIVER_PATH = "C://chromedriver.exe";
	
	public static void main(String[] args) throws InterruptedException {
		Image img = new Image();
		int rank = 0;	// 순서 주려고 선언
		
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);	// 운영체제 드라이버 설정
		ChromeOptions options = new ChromeOptions();	// 옵션 쓰려고 객체화
		options.addArguments("headless");
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		WebDriver driver = new ChromeDriver(options);
		
		try {
			String url = "https://kream.co.kr/search?category_id=34&sort=popular&per_page=40";
			driver.get(url);
			
//			List<WebElement> el = driver.findElements(By.className("name"));
			List<WebElement> el = driver.findElements(By.className("product"));

			var stTime = new Date().getTime(); //현재시간
	        
			while (new Date().getTime() < stTime + 5000) { //30초 동안 무한스크롤 지속
	            Thread.sleep(500); //리소스 초과 방지
	            //executeScript: 해당 페이지에 JavaScript 명령을 보내는 거
	            ((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)", el);

				for (WebElement element:el) {
					
					System.out.println(++rank+"."+element.findElement(By.tagName("img")).getAttribute("src"));
				}
			}
	        
		} finally {
			driver.close();
			driver.quit();
		}
	}

}
