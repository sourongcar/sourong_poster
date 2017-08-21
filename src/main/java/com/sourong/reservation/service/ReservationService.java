package com.sourong.reservation.service;

import com.base.datatables.domain.DataTablesRequest;
import com.base.datatables.domain.DataTablesResponse;
import com.sourong.reservation.domain.ReservationVO;

public interface ReservationService {
    /**
	 * 新增
	 * @param entity
	 * @return
	 */
	public int add(ReservationVO entity);
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public int delete(Integer id);
	/**
	 * 修改
	 * @param entity
	 * @return
	 */
	public int update(ReservationVO entity);
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public ReservationVO get(Integer id);
	
	/**
	 * 使用datatables的分页查询
	 * @param request
	 * @return
	 */
	public DataTablesResponse<ReservationVO> listByPage(DataTablesRequest request) throws Throwable;
	/**
	 * 标记为已咨询
	 * @param id
	 * @return
	 */
	public int changDisposal(ReservationVO entity);
	
}
