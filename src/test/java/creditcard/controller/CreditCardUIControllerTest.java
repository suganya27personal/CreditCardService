package creditcard.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


public class CreditCardUIControllerTest {

	@RequestMapping(method = RequestMethod.GET, path = "/home",produces = MediaType.TEXT_HTML_VALUE)
	public String index() {
		
	    return "Home.html";
	}
}
