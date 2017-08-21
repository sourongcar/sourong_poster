package com.sourong.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.base.common.util.SearchConditionUtils;
import com.base.datatables.domain.DataTablesRequest;
import com.base.datatables.domain.DataTablesResponse;
import com.sourong.reservation.dao.ReservationVOMapper;
import com.sourong.reservation.domain.ReservationVO;
import com.sourong.reservation.domain.ReservationVOExample;


@Service
public class ReservationServiceImp implements ReservationService {
	@Autowired
	private ReservationVOMapper mapper;
	/**
	 * 新增
	 * @param entity
	 * @return
	 */
	@Override
	public int add(ReservationVO entity) {
		return mapper.insertSelective(entity);
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@Override
	public int delete(Integer id) {
		return mapper.deleteByPrimaryKey(id);
	}
	/**
	 * 修改
	 * @param entity
	 * @return
	 */
	@Override
	public int update(ReservationVO entity) {
		return mapper.updateByPrimaryKeySelective(entity);
	}
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	@Override
	public ReservationVO get(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public DataTablesResponse<ReservationVO> listByPage(DataTablesRequest request)
			throws Throwable {
		ReservationVOExample example = new ReservationVOExample();
		DataTablesResponse<ReservationVO> response = new DataTablesResponse<ReservationVO>();
		SearchConditionUtils.wrapperAndCondition(example, request);// 封装查询条件
		response.setDraw(request.getDraw());
		response.setRecordsTotal(mapper.countByExample(example));
		response.setData(mapper.selectByExample(example));
		return response;
		
	}
	@Override
	public int changDisposal(ReservationVO entity) {
		entity.setDisposal(1);
		return mapper.updateByPrimaryKeySelective(entity);
	}

}
