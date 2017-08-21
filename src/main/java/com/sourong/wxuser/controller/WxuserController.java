package com.sourong.wxuser.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.base.common.domain.CurrentUser;
import com.base.common.domain.JsonResult;
import com.base.datatables.domain.DataTablesRequest;
import com.base.datatables.domain.DataTablesResponse;
import com.sourong.wxuser.domain.WxuserVO;
import com.sourong.wxuser.service.WxuserService;


@Controller
@RequestMapping("/wxuser")
public class WxuserController {
	@Autowired
	private WxuserService service;
	
	@RequestMapping("/edit")
	public String edit(Integer id,ModelMap map){
		if(id!=null){
			map.addAttribute("entity",service.get(id));
		}
		return "wxuser/edit";//跳转到编辑页面
	}
	
	@RequestMapping("/doEdit")
	public String doEdit(WxuserVO entity){
		/*CurrentUser user = CurrentUser.getInstance();*/
		//entity.setCreatorUserId(user.getUserId());//创建者id
		System.out.println(entity);
		if(entity.getUserid()!=null){//修改
			service.update(entity);
		}else{//新增
			service.add(entity);
		}
		return "redirect:/wxuser/list.action";//跳转到列表页面
	}
	
	@RequestMapping("/rest/doDelete")
	public @ResponseBody JsonResult doDelete(Integer id){
		JsonResult rs=new JsonResult();
		service.delete(id);
		rs.setStatus(1);
		rs.setMsg("删除成功！");
		return rs;
	}
	
	@RequestMapping("/list")
	public String list(){
		return "wxuser/list";//跳转到分页查询页面
	}
	/**
	 * datatable分页查询接口
	 * @param request
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping("/rest/doSearch")
	public @ResponseBody DataTablesResponse<WxuserVO> pageSearch(
			@RequestBody DataTablesRequest request) throws Throwable{
		return service.listByPage(request);
	}
	
	@RequestMapping("/rest/getUpAndDown")
	public @ResponseBody List<Object> getSupervisorAndSubordinates(Integer id){
		List<Object> obj = new ArrayList<Object>();
		WxuserVO user = service.get(id);//获取当前用户
		WxuserVO supervisor = null;//上家
		WxuserVO super_supervisor = null;//上上家
		List<WxuserVO> underlist1 = new ArrayList<WxuserVO>();//下家
		List<WxuserVO> underlist2 = new ArrayList<WxuserVO>();//下下家
		if(user.getReferrerid() != null){//如果用户推荐人ID存在，获取上家信息
			supervisor = service.getSupervisor(user.getReferrerid());
			if(supervisor.getReferrerid()!=null){//如果推荐人的上家ID存在，获取上上家信息
				super_supervisor = service.getSupervisor(supervisor.getReferrerid());
			}
		}
		underlist1 = service.getSubordinates(id);//获取下家的集合
		for (WxuserVO wxuserVO : underlist1) {
			List<WxuserVO> list = service.getSubordinates(wxuserVO.getUserid());
			underlist2.addAll(list);
		}
		obj.add(supervisor);
		obj.add(super_supervisor);
		obj.add(underlist1);
		obj.add(underlist2);
		
		return obj;
	}
	
	/**
	 * 得到上家和上上家
	 * @param id
	 * @return
	 */
	
	@RequestMapping("/rest/getSuperAndSuper")
	public @ResponseBody List<Object> getSuperAndSuper(Integer id){
		List<Object> obj = new ArrayList<Object>();
		WxuserVO user = service.get(id);//获取当前用户
		WxuserVO supervisor = null;//上家
		WxuserVO super_supervisor = null;//上上家
		if(user.getReferrerid() != null){//如果用户推荐人ID存在，获取上家信息
			supervisor = service.getSupervisor(user.getReferrerid());
			if(supervisor.getReferrerid()!=null){//如果推荐人的上家ID存在，获取上上家信息
				super_supervisor = service.getSupervisor(supervisor.getReferrerid());
			}
		}
		obj.add(supervisor);
		obj.add(super_supervisor);
		return obj;
	}
	
	/**
	 * 得到下家信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/rest/getJunior")
	public  @ResponseBody List<WxuserVO> getJunior(Integer id){
		List<WxuserVO> underlist = new ArrayList<WxuserVO>();
		underlist = service.getSubordinates(id);
		return underlist;
	}
	
	/**
	 * 得到下家和下下家信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/rest/getJuniorAndJunior")
	public  @ResponseBody List<Object> getJuniorAndJunior(Integer id){
		List<Object> obj = new ArrayList<Object>();
		WxuserVO user = service.get(id);//获取当前用户
		List<WxuserVO> underlist1 = new ArrayList<WxuserVO>();//下家
		List<WxuserVO> underlist2 = new ArrayList<WxuserVO>();//下下家
		underlist1 = service.getSubordinates(id);//获取下家的集合
		for (WxuserVO wxuserVO : underlist1) {
			List<WxuserVO> list = service.getSubordinates(wxuserVO.getUserid());
			underlist2.addAll(list);
		}
		obj.add(underlist1);
		obj.add(underlist2);
		
		return obj;
	}
}
