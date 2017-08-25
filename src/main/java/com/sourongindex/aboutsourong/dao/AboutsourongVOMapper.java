package com.sourongindex.aboutsourong.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.sourongindex.aboutsourong.domain.AboutsourongVO;
import com.sourongindex.aboutsourong.domain.AboutsourongVOExample;

public interface AboutsourongVOMapper {
    int countByExample(AboutsourongVOExample example);

    int deleteByExample(AboutsourongVOExample example);

    int deleteByPrimaryKey(Integer sourongid);

    int insert(AboutsourongVO record);

    int insertSelective(AboutsourongVO record);

    List<AboutsourongVO> selectByExample(AboutsourongVOExample example);

    AboutsourongVO selectByPrimaryKey(Integer sourongid);

    int updateByExampleSelective(@Param("record") AboutsourongVO record, @Param("example") AboutsourongVOExample example);

    int updateByExample(@Param("record") AboutsourongVO record, @Param("example") AboutsourongVOExample example);

    int updateByPrimaryKeySelective(AboutsourongVO record);

    int updateByPrimaryKey(AboutsourongVO record);
}