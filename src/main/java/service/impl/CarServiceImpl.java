package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CarsMapper;
import po.Cars;
import service.ICarService;

@Service(value="iCarService")
public class CarServiceImpl implements ICarService {
    @Autowired
    private CarsMapper carDao;

	@Override
	public Cars seleCarsByID(int id) {
		return carDao.selectByPrimaryKey(id);
	}
}