package com.sourongindex.consultant.service;

import java.util.List;

import com.base.datatables.domain.DataTablesRequest;
import com.base.datatables.domain.DataTablesResponse;
import com.sourongindex.consultant.domain.ConsultantVO;

public interface ConsultantService {
    /**
	 * 新增
	 * @param entity
	 * @return
	 */
	public int add(ConsultantVO entity);
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
	public int update(ConsultantVO entity);
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public ConsultantVO get(Integer id);
	
	/**
	 * 使用datatables的分页查询
	 * @param request
	 * @return
	 */
	public DataTablesResponse<ConsultantVO> listByPage(DataTablesRequest request) throws Throwable;
	
	public List<ConsultantVO> list();
}
