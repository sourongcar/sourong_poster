package com.sourong.wxuser.service;

import java.security.spec.ECField;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.base.common.util.SearchConditionUtils;
import com.base.datatables.domain.DataTablesRequest;
import com.base.datatables.domain.DataTablesResponse;
import com.sourong.wxuser.dao.WxuserVOMapper;
import com.sourong.wxuser.domain.WxuserVO;
import com.sourong.wxuser.domain.WxuserVOExample;


@Service
public class WxuserServiceImp implements WxuserService {
	@Autowired
	private WxuserVOMapper mapper;
	/**
	 * 新增
	 * @param entity
	 * @return
	 */
	@Override
	public int add(WxuserVO entity) {
		return mapper.insertSelective(entity);
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@Override
	public int delete(Integer id) {
		WxuserVO vo = mapper.selectByPrimaryKey(id);
		vo.setIsdisplay(0);
		return mapper.updateByPrimaryKeySelective(vo);
	}
	/**
	 * 修改
	 * @param entity
	 * @return
	 */
	@Override
	public int update(WxuserVO entity) {
		return mapper.updateByPrimaryKeySelective(entity);
	}
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	@Override
	public WxuserVO get(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public DataTablesResponse<WxuserVO> listByPage(DataTablesRequest request)
			throws Throwable {
		WxuserVOExample example = new WxuserVOExample();
		example.createCriteria().andIsdisplayEqualTo(1);
		DataTablesResponse<WxuserVO> response = new DataTablesResponse<WxuserVO>();
		SearchConditionUtils.wrapperAndCondition(example, request);// 封装查询条件
		response.setDraw(request.getDraw());
		response.setRecordsTotal(mapper.countByExample(example));
		response.setData(mapper.selectByExample(example));
		return response;
		
	}
	
	/**
	 * 得到我的上家信息
	 * @param id
	 * @return
	 */
	@Override
	public WxuserVO getSupervisor(Integer id) {
		// TODO Auto-generated method stub
		return get(id);
	}
	
	/**
	 * 得到我的下家信息
	 * @param id
	 * @return
	 */
	@Override
	public List<WxuserVO> getSubordinates(Integer id) {
		// TODO Auto-generated method stub
		WxuserVOExample example = new WxuserVOExample();
		example.createCriteria().andReferreridEqualTo(id);
		List<WxuserVO> list = mapper.selectByExample(example);
		return list;
	}

}
