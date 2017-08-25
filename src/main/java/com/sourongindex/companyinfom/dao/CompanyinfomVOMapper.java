package com.sourongindex.companyinfom.dao;

import com.sourongindex.companyinfom.domain.CompanyinfomVO;
import com.sourongindex.companyinfom.domain.CompanyinfomVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyinfomVOMapper {
    int countByExample(CompanyinfomVOExample example);

    int deleteByExample(CompanyinfomVOExample example);

    int deleteByPrimaryKey(Integer companyid);

    int insert(CompanyinfomVO record);

    int insertSelective(CompanyinfomVO record);

    List<CompanyinfomVO> selectByExample(CompanyinfomVOExample example);

    CompanyinfomVO selectByPrimaryKey(Integer companyid);

    int updateByExampleSelective(@Param("record") CompanyinfomVO record, @Param("example") CompanyinfomVOExample example);

    int updateByExample(@Param("record") CompanyinfomVO record, @Param("example") CompanyinfomVOExample example);

    int updateByPrimaryKeySelective(CompanyinfomVO record);

    int updateByPrimaryKey(CompanyinfomVO record);
}