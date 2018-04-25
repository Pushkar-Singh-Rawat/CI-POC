package demo.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import demo.bean.Message;
import demo.services.SalaryService;

@Controller
public class HelloController {

	private SalaryService salaryService;
	 String hostname;
	 String username;
	public HelloController(SalaryService salaryService){
		this.salaryService=salaryService;
	}
    @Autowired
    private Message message;

    @GetMapping(path = "/hello")
    @ResponseBody
    public String message() {

        return message.get();
    }
    
    @GetMapping({"/homepage"})
    public String salaryMessage(Model model,HttpServletRequest request){
    	
    	model.addAttribute("message",salaryService.showSalaryMessage());
    	System.out.println("------------------------"+request.getRemoteAddr());
    	 try {
			InetAddress inetAddr = InetAddress.getByName(request.getRemoteAddr());
			hostname = inetAddr.getHostName().split("corp")[0];
		
            
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	model.addAttribute("ipaddress","Welcome "+hostname);
    	System.out.println("--------Host name----------------"+hostname);
    	/*model.addAttribute("salarydays",salaryService.calculateDaysToGetSalary());*/
    	return "home";
    }
    
    
}