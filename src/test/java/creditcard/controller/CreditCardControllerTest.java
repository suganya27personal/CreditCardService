package creditcard.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import creditcard.app.CreditCardServiceApplication;
import creditcard.service.entity.CreditCard;

@SpringBootTest(classes=CreditCardServiceApplication.class,webEnvironment = WebEnvironment.RANDOM_PORT)

public class CreditCardControllerTest {

	
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

    @Test
    public void testlistCreditCard() throws Exception {
        ResponseEntity<Object[]> response = this.restTemplate.getForEntity(
        		"http://localhost:" + port + "/creditcard",Object[].class);
        
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        		
    }
    
    @Test
    public void testAddCreditCard() throws Exception {
        ResponseEntity<String> response = this.restTemplate.postForEntity("http://localhost:" + port + "/creditcard",
        		new CreditCard("John", "100", "1000", "4111111111111111"), String.class);   
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        		
    }
	

}
