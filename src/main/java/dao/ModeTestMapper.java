package dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;
import po.ModeTest;
import po.ModeTestExample;

@Repository
public interface ModeTestMapper {
    long countByExample(ModeTestExample example);

    int deleteByExample(ModeTestExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ModeTest record);

    int insertSelective(ModeTest record);

    List<ModeTest> selectByExampleWithRowbounds(ModeTestExample example, RowBounds rowBounds);

    List<ModeTest> selectByExample(ModeTestExample example);

    ModeTest selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ModeTest record, @Param("example") ModeTestExample example);

    int updateByExample(@Param("record") ModeTest record, @Param("example") ModeTestExample example);

    int updateByPrimaryKeySelective(ModeTest record);

    int updateByPrimaryKey(ModeTest record);
}