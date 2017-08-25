package com.sourongindex.consultant.dao;

import com.sourongindex.consultant.domain.ConsultantVO;
import com.sourongindex.consultant.domain.ConsultantVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConsultantVOMapper {
    int countByExample(ConsultantVOExample example);

    int deleteByExample(ConsultantVOExample example);

    int deleteByPrimaryKey(Integer consultantid);

    int insert(ConsultantVO record);

    int insertSelective(ConsultantVO record);

    List<ConsultantVO> selectByExample(ConsultantVOExample example);

    ConsultantVO selectByPrimaryKey(Integer consultantid);

    int updateByExampleSelective(@Param("record") ConsultantVO record, @Param("example") ConsultantVOExample example);

    int updateByExample(@Param("record") ConsultantVO record, @Param("example") ConsultantVOExample example);

    int updateByPrimaryKeySelective(ConsultantVO record);

    int updateByPrimaryKey(ConsultantVO record);
}