package com.sourongindex.banner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.common.util.SearchConditionUtils;
import com.base.datatables.domain.DataTablesRequest;
import com.base.datatables.domain.DataTablesResponse;
import com.sourongindex.banner.dao.BannerVOMapper;
import com.sourongindex.banner.domain.BannerVO;
import com.sourongindex.banner.domain.BannerVOExample;


@Service
public class BannerServiceImp implements BannerService {
	@Autowired
	private BannerVOMapper mapper;
	/**
	 * 新增
	 * @param entity
	 * @return
	 */
	@Override
	public int add(BannerVO entity) {
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
	public int update(BannerVO entity) {
		return mapper.updateByPrimaryKeySelective(entity);
	}
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	@Override
	public BannerVO get(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public DataTablesResponse<BannerVO> listByPage(DataTablesRequest request)
			throws Throwable {
		BannerVOExample example = new BannerVOExample();
		DataTablesResponse<BannerVO> response = new DataTablesResponse<BannerVO>();
		SearchConditionUtils.wrapperAndCondition(example, request);// 封装查询条件
		response.setDraw(request.getDraw());
		response.setRecordsTotal(mapper.countByExample(example));
		response.setData(mapper.selectByExample(example));
		return response;
		
	}
	@Override
	public List<BannerVO> list() {
		BannerVOExample example=new BannerVOExample();
		example.createCriteria();
		return mapper.selectByExample(example);
	}

}
