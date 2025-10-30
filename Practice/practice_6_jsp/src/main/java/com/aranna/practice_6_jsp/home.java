
package com.aranna.practice_6_jsp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class home {
    @RequestMapping("/")
    public String getHome(){
        System.out.println("getHome method called from home class");
        return "home.jsp";
    }
    
}
