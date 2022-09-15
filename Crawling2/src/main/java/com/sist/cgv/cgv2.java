package com.sist.cgv;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class cgv2 {
	private static WebDriver driver;
//	static JavascriptExecutor jse = (JavascriptExecutor)driver;
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";	// 크롬 드라이버
	public static final String WEB_DRIVER_PATH = "C://chromedriver.exe";
	
	public static void main(String[] args) throws InterruptedException {
		cgv2 cgv = new cgv2();
		int rank = 0;	// 순서 주려고 선언
//		WebElement movieDiv=null;	// 계속 쓸거라 선언
//		WebDriverManager.chromedriver().setup();
		
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);	// 운영체제 드라이버 설정
		ChromeOptions options = new ChromeOptions();	// 옵션 쓰려고 객체화
		options.addArguments("headless");	// 눈에 안보이고 내부적으로 도는 옵션
		cgv.driver = new ChromeDriver(options);	// 기본 생성자 (옵션 사용하려고 options 전달)
//		cgv.driver = new ChromeDriver();	// 기본 생성자
		
		String url = "https://kream.co.kr/search?category_id=34&sort=popular&per_page=40";
		
		
		cgv.driver.get(url);	// 서버 열어서 url 열기
//		JavascriptExecutor je = (JavascriptExecutor) driver;
//		je.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		try {Thread.sleep(2000);} catch(InterruptedException e) {;}	// 열리자마자 닫혀서 시간 확인용
//		Wait<WebDriver> wait = new WebDriverWait(driver, null);
//		Thread.sleep(2000);
		
		
//		// btn-more-fontbold(더보기 버튼 클래스명)
//		cgv.driver.findElement(By.className("btn-more-fontbold")).click();	// 버튼을 객체로 가져온 후 클릭
//		try {Thread.sleep(2000);} catch(InterruptedException e) {;}
		
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		
		// sect-movie-chart(영화목록 담고 있는 div태그 클래스명)
		List<WebElement> el = driver.findElements(By.className("name"));
//		scrollDownToBottom(driver);

		var stTime = new Date().getTime(); //현재시간
        while (new Date().getTime() < stTime + 15000) { //30초 동안 무한스크롤 지속
            Thread.sleep(500); //리소스 초과 방지
            //executeScript: 해당 페이지에 JavaScript 명령을 보내는 거
            ((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)", el);
        }
		
//		je.executeScript("arguments[0].scrollIntoView(true);", el);	
//		je.executeScript("window.scrollTo(0,document.body.scrollHeight)");
//		je.executeScript("window.scrollTo(0,document.body.scrollHeight)");
//		while(true) {
//			for (int i=0; i<el.size(); i++) {
//				// 각각의 <strong class="title"...> 태그를 el에 순서대로 담아준다
//				System.out.println(++rank+"."+el.get(i).getText());
//				// 가져온 태그 안에 있는 내용을 getText()로 가져온다
//			}
//		}
		
//		WebElement el = driver.findElement(By.className("name"));
//		var stTime = new Date().getTime();	// 현재 시간
//		while(new Date().getTime() <stTime + 30000) {	// 30초 동안 무한 스크록
//			Thread.sleep(500);	//리소스 초과 방지
//			//executeScript : 해당 페이지에 JavaScript 명령 보내기
//			((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight", el);
//		}
//		
		cgv.driver.close();	// 연 서버 닫기
		cgv.driver.quit(); // 브라우저 닫기
	}
	
	public static void scrollDownToBottom(WebDriver webDriver) {
		((JavascriptExecutor)webDriver).executeScript("window.scrollTo(0,documnet.body.scrollHeight)");
	}
}
