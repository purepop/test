package dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import po.CarsVo;
import po.CarsVoExample;

@Repository
public interface CarsVoMapper {
    long countByExample(CarsVoExample example);

    int deleteByExample(CarsVoExample example);

    int insert(CarsVo record);

    int insertSelective(CarsVo record);

    List<CarsVo> selectByExample(CarsVoExample example);

    int updateByExampleSelective(@Param("record") CarsVo record, @Param("example") CarsVoExample example);

    int updateByExample(@Param("record") CarsVo record, @Param("example") CarsVoExample example);
}