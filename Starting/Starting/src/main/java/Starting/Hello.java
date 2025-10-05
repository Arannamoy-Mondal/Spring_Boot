package Starting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Hello {
    
    @GetMapping
    public String greet1(){
        return "Hello World";
    }
    

    @PostMapping
    public String greet2(){
        return "Ok";
    }
}
