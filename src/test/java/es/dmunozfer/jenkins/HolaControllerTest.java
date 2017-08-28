package es.dmunozfer.jenkins;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
public class HolaControllerTest {

    @Autowired
	private Selenium selenium;
    
    @Before
    public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://www.adictosaltrabajo.com/");
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
