package com.sourong.wxuser.dao;

import com.sourong.wxuser.domain.WxuserVO;
import com.sourong.wxuser.domain.WxuserVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxuserVOMapper {
    int countByExample(WxuserVOExample example);

    int deleteByExample(WxuserVOExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(WxuserVO record);

    int insertSelective(WxuserVO record);

    List<WxuserVO> selectByExample(WxuserVOExample example);

    WxuserVO selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") WxuserVO record, @Param("example") WxuserVOExample example);

    int updateByExample(@Param("record") WxuserVO record, @Param("example") WxuserVOExample example);

    int updateByPrimaryKeySelective(WxuserVO record);

    int updateByPrimaryKey(WxuserVO record);
}