package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CarsMapper;
import dao.CarsVoMapper;
import po.Cars;
import po.CarsVo;
import po.CarsVoExample;
import service.ICarService;

@Service(value = "iCarService")
public class CarServiceImpl implements ICarService {
	@Autowired
	private CarsMapper carDao;
	@Autowired
	private CarsVoMapper carsDao;

	@Override
	public Cars seleCarsByID(int id) {
		return carDao.selectByPrimaryKey(id);
	}

	@Override
	public List<CarsVo> selectCarData(int startIndex, int pageSize) {
		CarsVoExample example = new CarsVoExample();

		return carsDao.selectByExample(example);
	}

	@Override
	public int returnCount() {
		CarsVoExample example = new CarsVoExample();

		return (int)carsDao.countByExample(example);
	}
}