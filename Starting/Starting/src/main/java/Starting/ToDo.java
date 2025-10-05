package Starting;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")

@Component
public class ToDo {

    
    public Computer laptop;

    public ToDo(Laptop laptop){
        this.laptop=laptop;
    }

    @GetMapping("/get")
    public String get(){
        return "Welcome";
    }


    public void setLaptop(Laptop laptop){
        this.laptop=laptop;
    }

    public void details(){
    laptop.compile();
    System.out.println("Ok");
    
    }

}
