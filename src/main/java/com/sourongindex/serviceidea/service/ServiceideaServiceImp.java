package com.sourongindex.serviceidea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.common.util.SearchConditionUtils;
import com.base.datatables.domain.DataTablesRequest;
import com.base.datatables.domain.DataTablesResponse;
import com.sourongindex.serviceidea.dao.ServiceideaVOMapper;
import com.sourongindex.serviceidea.domain.ServiceideaVO;
import com.sourongindex.serviceidea.domain.ServiceideaVOExample;


@Service
public class ServiceideaServiceImp implements ServiceideaService {
	@Autowired
	private ServiceideaVOMapper mapper;
	/**
	 * 新增
	 * @param entity
	 * @return
	 */
	@Override
	public int add(ServiceideaVO entity) {
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
	public int update(ServiceideaVO entity) {
		return mapper.updateByPrimaryKeySelective(entity);
	}
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	@Override
	public ServiceideaVO get(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public DataTablesResponse<ServiceideaVO> listByPage(DataTablesRequest request)
			throws Throwable {
		ServiceideaVOExample example = new ServiceideaVOExample();
		DataTablesResponse<ServiceideaVO> response = new DataTablesResponse<ServiceideaVO>();
		SearchConditionUtils.wrapperAndCondition(example, request);// 封装查询条件
		response.setDraw(request.getDraw());
		response.setRecordsTotal(mapper.countByExample(example));
		response.setData(mapper.selectByExample(example));
		return response;
		
	}
	@Override
	public List<ServiceideaVO> list() {
		ServiceideaVOExample example=new ServiceideaVOExample();
		example.createCriteria();
		return mapper.selectByExample(example);
	}

}
