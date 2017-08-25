package com.sourongindex.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.common.util.SearchConditionUtils;
import com.base.datatables.domain.DataTablesRequest;
import com.base.datatables.domain.DataTablesResponse;
import com.sourongindex.product.dao.ProductVOMapper;
import com.sourongindex.product.domain.ProductVO;
import com.sourongindex.product.domain.ProductVOExample;


@Service
public class ProductServiceImp implements ProductService {
	@Autowired
	private ProductVOMapper mapper;
	/**
	 * 新增
	 * @param entity
	 * @return
	 */
	@Override
	public int add(ProductVO entity) {
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
	public int update(ProductVO entity) {
		return mapper.updateByPrimaryKeySelective(entity);
	}
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	@Override
	public ProductVO get(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public DataTablesResponse<ProductVO> listByPage(DataTablesRequest request)
			throws Throwable {
		ProductVOExample example = new ProductVOExample();
		DataTablesResponse<ProductVO> response = new DataTablesResponse<ProductVO>();
		SearchConditionUtils.wrapperAndCondition(example, request);// 封装查询条件
		response.setDraw(request.getDraw());
		response.setRecordsTotal(mapper.countByExample(example));
		response.setData(mapper.selectByExample(example));
		return response;
		
	}
	@Override
	public List<ProductVO> list() {
		ProductVOExample example=new ProductVOExample();
		example.createCriteria();
		return mapper.selectByExample(example);
	}

}
