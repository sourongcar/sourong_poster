package com.sourongindex.aboutsourong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.base.common.util.SearchConditionUtils;
import com.base.datatables.domain.DataTablesRequest;
import com.base.datatables.domain.DataTablesResponse;
import com.sourongindex.aboutsourong.dao.AboutsourongVOMapper;
import com.sourongindex.aboutsourong.domain.AboutsourongVO;
import com.sourongindex.aboutsourong.domain.AboutsourongVOExample;


@Service
public class AboutsourongServiceImp implements AboutsourongService {
	@Autowired
	private AboutsourongVOMapper mapper;
	/**
	 * 新增
	 * @param entity
	 * @return
	 */
	@Override
	public int add(AboutsourongVO entity) {
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
	public int update(AboutsourongVO entity) {
		return mapper.updateByPrimaryKeySelective(entity);
	}
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	@Override
	public AboutsourongVO get(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public DataTablesResponse<AboutsourongVO> listByPage(DataTablesRequest request)
			throws Throwable {
		AboutsourongVOExample example = new AboutsourongVOExample();
		DataTablesResponse<AboutsourongVO> response = new DataTablesResponse<AboutsourongVO>();
		SearchConditionUtils.wrapperAndCondition(example, request);// 封装查询条件
		response.setDraw(request.getDraw());
		response.setRecordsTotal(mapper.countByExample(example));
		response.setData(mapper.selectByExample(example));
		return response;
		
	}

}
