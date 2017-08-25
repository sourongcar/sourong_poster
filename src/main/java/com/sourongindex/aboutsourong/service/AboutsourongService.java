package com.sourongindex.aboutsourong.service;

import com.base.datatables.domain.DataTablesRequest;
import com.base.datatables.domain.DataTablesResponse;
import com.sourongindex.aboutsourong.domain.AboutsourongVO;


public interface AboutsourongService {
    /**
	 * 新增
	 * @param entity
	 * @return
	 */
	public int add(AboutsourongVO entity);
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
	public int update(AboutsourongVO entity);
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public AboutsourongVO get(Integer id);
	
	/**
	 * 使用datatables的分页查询
	 * @param request
	 * @return
	 */
	public DataTablesResponse<AboutsourongVO> listByPage(DataTablesRequest request) throws Throwable;
	
	
}
