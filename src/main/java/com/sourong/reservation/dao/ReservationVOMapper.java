package com.sourong.reservation.dao;

import com.sourong.reservation.domain.ReservationVO;
import com.sourong.reservation.domain.ReservationVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReservationVOMapper {
    int countByExample(ReservationVOExample example);

    int deleteByExample(ReservationVOExample example);

    int deleteByPrimaryKey(Integer reservationid);

    int insert(ReservationVO record);

    int insertSelective(ReservationVO record);

    List<ReservationVO> selectByExample(ReservationVOExample example);

    ReservationVO selectByPrimaryKey(Integer reservationid);

    int updateByExampleSelective(@Param("record") ReservationVO record, @Param("example") ReservationVOExample example);

    int updateByExample(@Param("record") ReservationVO record, @Param("example") ReservationVOExample example);

    int updateByPrimaryKeySelective(ReservationVO record);

    int updateByPrimaryKey(ReservationVO record);
}