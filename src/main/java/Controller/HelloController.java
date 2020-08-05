package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/Hello")
public class HelloController {
    @RequestMapping ("/toHello")
    public String helloString() {
        return "/HelloSpringMVC";
    }
}