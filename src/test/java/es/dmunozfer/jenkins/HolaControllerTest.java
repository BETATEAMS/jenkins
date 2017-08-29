import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class HolaControllerTest {

public static void main (String[] args) {

Selenium selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://www.b2mining.com/");
selenium.start();
selenium.open("/");

}
}
