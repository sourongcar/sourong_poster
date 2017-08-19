package com.sourong.poster.dao;

import com.sourong.poster.domain.PosterVO;
import com.sourong.poster.domain.PosterVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PosterVOMapper {
    int countByExample(PosterVOExample example);

    int deleteByExample(PosterVOExample example);

    int deleteByPrimaryKey(Integer posterid);

    int insert(PosterVO record);

    int insertSelective(PosterVO record);

    List<PosterVO> selectByExample(PosterVOExample example);

    PosterVO selectByPrimaryKey(Integer posterid);

    int updateByExampleSelective(@Param("record") PosterVO record, @Param("example") PosterVOExample example);

    int updateByExample(@Param("record") PosterVO record, @Param("example") PosterVOExample example);

    int updateByPrimaryKeySelective(PosterVO record);

    int updateByPrimaryKey(PosterVO record);
}