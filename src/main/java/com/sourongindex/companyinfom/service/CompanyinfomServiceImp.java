package com.sourongindex.companyinfom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.common.util.SearchConditionUtils;
import com.base.datatables.domain.DataTablesRequest;
import com.base.datatables.domain.DataTablesResponse;
import com.sourongindex.companyinfom.dao.CompanyinfomVOMapper;
import com.sourongindex.companyinfom.domain.CompanyinfomVO;
import com.sourongindex.companyinfom.domain.CompanyinfomVOExample;


@Service
public class CompanyinfomServiceImp implements CompanyinfomService {
	@Autowired
	private CompanyinfomVOMapper mapper;
	/**
	 * 新增
	 * @param entity
	 * @return
	 */
	@Override
	public int add(CompanyinfomVO entity) {
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
	public int update(CompanyinfomVO entity) {
		return mapper.updateByPrimaryKeySelective(entity);
	}
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	@Override
	public CompanyinfomVO get(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public DataTablesResponse<CompanyinfomVO> listByPage(DataTablesRequest request)
			throws Throwable {
		CompanyinfomVOExample example = new CompanyinfomVOExample();
		DataTablesResponse<CompanyinfomVO> response = new DataTablesResponse<CompanyinfomVO>();
		SearchConditionUtils.wrapperAndCondition(example, request);// 封装查询条件
		response.setDraw(request.getDraw());
		response.setRecordsTotal(mapper.countByExample(example));
		response.setData(mapper.selectByExample(example));
		return response;
		
	}
	
	@Override
	public List<CompanyinfomVO> list() {
		CompanyinfomVOExample exmaple=new CompanyinfomVOExample();
		exmaple.createCriteria();
		return mapper.selectByExample(exmaple);
	}

}
