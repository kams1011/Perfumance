package Kams.Perfumance.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Selenium {

    //Properties 설정
    public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static String WEB_DRIVER_PATH = "C:\\Users\\김세훈\\Desktop\\chromedriver.exe";
    public static String listUrl = "https://www.fragrantica.com/search/?";  //전체 목록이 있는 url


    public static void main(String[] args) {
//드라이버 설정
        try {
            System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        } catch (Exception e) {
            e.printStackTrace();
        }


        //크롬 설정을 담은 객체 생성
        ChromeOptions options = new ChromeOptions();
        //브라우저가 눈에 보이지 않고 내부적으로 돈다.
        //설정하지 않을 시 실제 크롬 창이 생성되고, 어떤 순서로 진행되는지 확인할 수 있다.
        options.addArguments("headless");

        //위에서 설정한 옵션은 담은 드라이버 객체 생성
        //옵션을 설정하지 않았을 때에는 생략 가능하다.
        //WebDriver객체가 곧 하나의 브라우저 창이라 생각한다.
        WebDriver driver = new ChromeDriver(options);
        //WebDriver을 해당 url로 이동한다.
        driver.get(listUrl);

        //브라우저 이동시 생기는 로드시간을 기다린다.
        //HTTP응답속도보다 자바의 컴파일 속도가 더 빠르기 때문에 임의적으로 1초를 대기한다.
        try {Thread.sleep(2000);} catch (InterruptedException e) {}

        List<WebElement> containers = driver.findElements(By.className("card-section"));
        List<WebElement> button = driver.findElements(By.className("button"));


        while(containers.size()<300){
            button.get(1).click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            containers = driver.findElements(By.className("card-section"));
        }



        //WebElement는 html의 태그를 가지는 클래스이다.
        Map<String, Object> perfumeList = new HashMap<>();

        ArrayList perfumeNameArr = new ArrayList<>();
        ArrayList perfumeMakerArr = new ArrayList<>();
        ArrayList detailUrl = new ArrayList<>(); // 향수 정보 url



        perfumeNameArr.clear(); // 테스트 중 계속 인덱스에 쌓이는걸 막기 위해
        perfumeMakerArr.clear();
        detailUrl.clear();


        for(int i=0; i<containers.size()/2; i++) {
            perfumeNameArr.add(containers.get(2*i+1).findElements(By.tagName("a")).get(0).getText());    //향수 이름을 ArrayList에 담는다
            perfumeMakerArr.add(containers.get(2*i+1).findElements(By.tagName("small")).get(0).getText()); //향수 메이커를 ArrayList에 담는다.
            detailUrl.add(containers.get(2*i+1).findElements(By.tagName("a")).get(0).getAttribute("href"));
            System.out.println(perfumeNameArr.get(i).toString());
            System.out.println(perfumeMakerArr.get(i).toString());
            System.out.println(detailUrl.get(i).toString());

        }

//
//        perfumeList.put("perfumeName", perfumeNameArr);
//        perfumeList.put("manufacturer", perfumeMakerArr);  //ArrayList를 map에 담는다.
//        perfumeList.put("detailUrl", detailUrl);

//        System.out.println(detailUrl);



        try {
            //드라이버가 null이 아니라면
            if(driver != null) {
                //드라이버 연결 종료
                driver.close(); //드라이버 연결 해제

                //프로세스 종료
                driver.quit();
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}