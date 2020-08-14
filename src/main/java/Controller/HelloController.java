package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Cars;
import service.ICarService;

@Controller
@RequestMapping ("/Hello")
public class HelloController {
    @Autowired
    ICarService carService;

    @RequestMapping ("/toHello")
    public @ResponseBody Cars helloString() {
        //ModelAndView mv = new ModelAndView("/HelloSpringMVC");

        Cars cars = carService.seleCarsByID(1);
        //mv.addObject("cars", cars);

        return cars;
    }
}