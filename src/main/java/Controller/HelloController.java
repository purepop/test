package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Cars;
import po.CarsVo;
import po.TestDate;
import service.ICarService;
import tool.Bsgrid;
import tool.BsgridPage;

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

    @RequestMapping (value = "/toBsgrid")
    public @ResponseBody Bsgrid<CarsVo> toBsgridCars(BsgridPage bsgridPage) {
        List<CarsVo> cars = carService.selectCarData(bsgridPage.GetStartIndex(), bsgridPage.getPageSize());
        Bsgrid<CarsVo> bsgrid = new Bsgrid<>();
        bsgrid.setCurPage(bsgridPage.getCurPage());
        bsgrid.setSuccess(true);
        bsgrid.setTotalRows(carService.returnCount());
        bsgrid.setData(cars);

        return bsgrid;
    }

    @RequestMapping ("/toDate")
    public @ResponseBody TestDate toDate(TestDate test) {
        return test;
    }
}