package es.dmunozfer.jenkins;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.Assert;


public class HolaControllerTest {

  
	private Selenium selenium;
    
    @Before
    public void setUp() throws Exception {
		selenium = new DefaultSelenium("13.90.82.96", 4444, "*firefox", "http://www.adictosaltrabajo.com/");
		selenium.start();
	}

    @Test
	public void findTutorial() throws Exception {
		selenium.open("/");
		selenium.type("sbi", "selenium remote control");
		selenium.click("sb");
		selenium.waitForPageToLoad("30000");
		
		Assert.assertEquals("Adictos al Trabajo. Formación y desarrollo | JAVA, JEE, UML, XML |. Tutoriales sobre nuevas tecnologías.", selenium.getTitle());
		selenium.selectFrame("googleSearchFrame");
		selenium.click("//div[@id='res']/div[1]/ol/li[1]/div/h2/a/em");
		selenium.waitForPageToLoad("30000");
	}
	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
 

}
