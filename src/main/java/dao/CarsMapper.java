package dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import po.Cars;
import po.CarsExample;

@Repository
public interface CarsMapper {
    long countByExample(CarsExample example);

    int deleteByExample(CarsExample example);

    int deleteByPrimaryKey(Integer carid);

    int insert(Cars record);

    int insertSelective(Cars record);

    List<Cars> selectByExample(CarsExample example);

    Cars selectByPrimaryKey(Integer carid);

    int updateByExampleSelective(@Param("record") Cars record, @Param("example") CarsExample example);

    int updateByExample(@Param("record") Cars record, @Param("example") CarsExample example);

    int updateByPrimaryKeySelective(Cars record);

    int updateByPrimaryKey(Cars record);
}