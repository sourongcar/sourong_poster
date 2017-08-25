package com.sourongindex.banner.dao;

import com.sourongindex.banner.domain.BannerVO;
import com.sourongindex.banner.domain.BannerVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BannerVOMapper {
    int countByExample(BannerVOExample example);

    int deleteByExample(BannerVOExample example);

    int deleteByPrimaryKey(Integer bannerid);

    int insert(BannerVO record);

    int insertSelective(BannerVO record);

    List<BannerVO> selectByExample(BannerVOExample example);

    BannerVO selectByPrimaryKey(Integer bannerid);

    int updateByExampleSelective(@Param("record") BannerVO record, @Param("example") BannerVOExample example);

    int updateByExample(@Param("record") BannerVO record, @Param("example") BannerVOExample example);

    int updateByPrimaryKeySelective(BannerVO record);

    int updateByPrimaryKey(BannerVO record);
}