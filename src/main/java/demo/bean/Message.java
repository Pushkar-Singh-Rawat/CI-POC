
package demo.bean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Message {
    
    @Value("${app.message}")
    private String msg;
    
    public String get() {
<<<<<<< HEAD
    	
=======
		
>>>>>>> 6f616950734598f833138b231271dbae44986c91
        return msg;
    }
}