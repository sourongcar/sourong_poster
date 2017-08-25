package com.sourongindex.serviceidea.dao;

import com.sourongindex.serviceidea.domain.ServiceideaVO;
import com.sourongindex.serviceidea.domain.ServiceideaVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServiceideaVOMapper {
    int countByExample(ServiceideaVOExample example);

    int deleteByExample(ServiceideaVOExample example);

    int deleteByPrimaryKey(Integer serviceideaid);

    int insert(ServiceideaVO record);

    int insertSelective(ServiceideaVO record);

    List<ServiceideaVO> selectByExample(ServiceideaVOExample example);

    ServiceideaVO selectByPrimaryKey(Integer serviceideaid);

    int updateByExampleSelective(@Param("record") ServiceideaVO record, @Param("example") ServiceideaVOExample example);

    int updateByExample(@Param("record") ServiceideaVO record, @Param("example") ServiceideaVOExample example);

    int updateByPrimaryKeySelective(ServiceideaVO record);

    int updateByPrimaryKey(ServiceideaVO record);
}