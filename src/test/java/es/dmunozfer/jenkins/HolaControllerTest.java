import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class HolaControllerTest {

public static void main (String[] args) {

Selenium selenium = new DefaultSelenium("13.90.82.96", 4444, "*firefox", "http://www.b2mining.com/");
selenium.start();
selenium.open("/");

}
}
