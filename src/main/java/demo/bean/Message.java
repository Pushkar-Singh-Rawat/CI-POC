
package demo.bean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Message {
    
    @Value("${app.message}")
    private String msg;
    
    public String get() {
		
        return msg;
    }
}