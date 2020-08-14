package service;

import java.util.List;

import po.Cars;
import po.CarsVo;

public interface ICarService {
    Cars seleCarsByID(int id);

    List<CarsVo> selectCarData(int startIndex, int pageSize);

    int returnCount();
}