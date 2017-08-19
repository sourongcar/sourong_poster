package com.sourong.poster.service;

import com.base.datatables.domain.DataTablesRequest;
import com.base.datatables.domain.DataTablesResponse;
import com.sourong.poster.domain.PosterVO;

public interface PosterService {
    /**
	 * 新增
	 * @param entity
	 * @return
	 */
	public int add(PosterVO entity);
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
	public int update(PosterVO entity);
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public PosterVO get(Integer id);
	
	/**
	 * 使用datatables的分页查询
	 * @param request
	 * @return
	 */
	public DataTablesResponse<PosterVO> listByPage(DataTablesRequest request) throws Throwable;
	
	
}
