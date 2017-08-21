package com.sourong.wxuser.service;

import java.util.List;

import com.base.datatables.domain.DataTablesRequest;
import com.base.datatables.domain.DataTablesResponse;
import com.sourong.wxuser.domain.WxuserVO;

public interface WxuserService {
    /**
	 * 新增
	 * @param entity
	 * @return
	 */
	public int add(WxuserVO entity);
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
	public int update(WxuserVO entity);
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public WxuserVO get(Integer id);
	
	/**
	 * 使用datatables的分页查询
	 * @param request
	 * @return
	 */
	public DataTablesResponse<WxuserVO> listByPage(DataTablesRequest request) throws Throwable;
	
	/**
	 * 得到我的上家信息
	 * @param id
	 * @return
	 */
	public WxuserVO getSupervisor(Integer id);
	
	/**
	 * 得到我的下家信息
	 * @param id
	 * @return
	 */
	public List<WxuserVO> getSubordinates(Integer id);
}
