package Starting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")

@Componeny
public class ToDo {
    @GetMapping("/get")
    public String get(){
        return "Welcome";
    }

    public void details(){
    System.out.println("Ok");
    }

}
