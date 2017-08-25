package com.sourongindex.banner.service;

import java.util.List;

import com.base.datatables.domain.DataTablesRequest;
import com.base.datatables.domain.DataTablesResponse;
import com.sourongindex.banner.domain.BannerVO;

public interface BannerService {
    /**
	 * 新增
	 * @param entity
	 * @return
	 */
	public int add(BannerVO entity);
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
	public int update(BannerVO entity);
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public BannerVO get(Integer id);
	
	/**
	 * 使用datatables的分页查询
	 * @param request
	 * @return
	 */
	public DataTablesResponse<BannerVO> listByPage(DataTablesRequest request) throws Throwable;
	
	public List<BannerVO> list();
}
