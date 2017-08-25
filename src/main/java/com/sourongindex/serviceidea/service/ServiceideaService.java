package com.sourongindex.serviceidea.service;

import java.util.List;

import com.base.datatables.domain.DataTablesRequest;
import com.base.datatables.domain.DataTablesResponse;
import com.sourongindex.serviceidea.domain.ServiceideaVO;

public interface ServiceideaService {
    /**
	 * 新增
	 * @param entity
	 * @return
	 */
	public int add(ServiceideaVO entity);
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
	public int update(ServiceideaVO entity);
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public ServiceideaVO get(Integer id);
	
	/**
	 * 使用datatables的分页查询
	 * @param request
	 * @return
	 */
	public DataTablesResponse<ServiceideaVO> listByPage(DataTablesRequest request) throws Throwable;
	
	public List<ServiceideaVO> list();
}
