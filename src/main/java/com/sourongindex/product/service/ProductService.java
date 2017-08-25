package com.sourongindex.product.service;

import java.util.List;

import com.base.datatables.domain.DataTablesRequest;
import com.base.datatables.domain.DataTablesResponse;
import com.sourongindex.product.domain.ProductVO;

public interface ProductService {
    /**
	 * 新增
	 * @param entity
	 * @return
	 */
	public int add(ProductVO entity);
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
	public int update(ProductVO entity);
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public ProductVO get(Integer id);
	
	/**
	 * 使用datatables的分页查询
	 * @param request
	 * @return
	 */
	public DataTablesResponse<ProductVO> listByPage(DataTablesRequest request) throws Throwable;
	
	public List<ProductVO> list();
}
