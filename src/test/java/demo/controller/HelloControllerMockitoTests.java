package demo.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import demo.services.SalaryService;

public class HelloControllerMockitoTests {

	@Mock 
	private SalaryService salaryService;
	@Mock
	Model model;
	@Mock
	HttpServletRequest request;
	
	private HelloController helloController;
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		helloController=new HelloController(salaryService);
	}
	
	@Test
	public void testSalaryMessage(){
		
		String expectedViewName="home";
		String actualViewName=helloController.salaryMessage(model,request);
		String mockedMessage="Hello!";
		
		Mockito.when(salaryService.showSalaryMessage()).thenReturn(mockedMessage);
		
		assertEquals(expectedViewName,actualViewName);
		//verify service invocation count and the method with which it was invoked.
		verify(salaryService,Mockito.times(1)).showSalaryMessage();
	}
}
