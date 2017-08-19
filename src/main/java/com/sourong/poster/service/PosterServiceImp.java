package com.sourong.poster.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.common.util.ConfigUtil;
import com.base.common.util.SearchConditionUtils;
import com.base.datatables.domain.DataTablesRequest;
import com.base.datatables.domain.DataTablesResponse;
import com.sourong.poster.dao.PosterVOMapper;
import com.sourong.poster.domain.PosterVO;
import com.sourong.poster.domain.PosterVOExample;


@Service
public class PosterServiceImp implements PosterService {
	@Autowired
	private PosterVOMapper mapper;
	/**
	 * 新增
	 * @param entity
	 * @return
	 */
	@Override
	public int add(PosterVO entity) {
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
	public int update(PosterVO entity) {
		PosterVO record=mapper.selectByPrimaryKey(entity.getPosterid());
		int result = mapper.updateByPrimaryKeySelective(entity);
		if (entity.getPosterurl() != null && !entity.getPosterurl().equals(record.getPosterurl())) {
			File f = new File(ConfigUtil.getValue("saveImage") + record.getPosterurl());
			if (f.exists()) {
				f.delete();
			}
		}
		return result;
	}
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	@Override
	public PosterVO get(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public DataTablesResponse<PosterVO> listByPage(DataTablesRequest request)
			throws Throwable {
		PosterVOExample example = new PosterVOExample();
		DataTablesResponse<PosterVO> response = new DataTablesResponse<PosterVO>();
		SearchConditionUtils.wrapperAndCondition(example, request);// 封装查询条件
		response.setDraw(request.getDraw());
		response.setRecordsTotal(mapper.countByExample(example));
		response.setData(mapper.selectByExample(example));
		return response;
		
	}

}
