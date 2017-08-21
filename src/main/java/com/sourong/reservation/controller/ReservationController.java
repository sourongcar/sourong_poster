package com.sourong.reservation.controller;

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
import com.sourong.reservation.domain.ReservationVO;
import com.sourong.reservation.service.ReservationService;


@Controller
@RequestMapping("/reservation")
public class ReservationController {
	@Autowired
	private ReservationService service;
	
	@RequestMapping("/edit")
	public String edit(Integer reservationid,ModelMap map){
		if(reservationid!=null){
			map.addAttribute("entity",service.get(reservationid));
		}
		return "reservation/edit";//跳转到编辑页面
	}
	
	@RequestMapping("/doEdit")
	public String doEdit(ReservationVO entity){
		CurrentUser user = CurrentUser.getInstance();
		//entity.setCreatorUserId(user.getUserId());//创建者id
		if(entity.getReservationid()!=null){//修改
			service.update(entity);
		}else{//新增
			service.add(entity);
		}
		return "redirect:/reservation/list.action";//跳转到列表页面
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
		return "reservation/list";//跳转到分页查询页面
	}
	
	@RequestMapping("/rest/doDisposal")
	public @ResponseBody JsonResult doDisposal(ReservationVO entity){
		service.changDisposal(entity);//跳转到分页查询页面
		JsonResult rs=new JsonResult();
		rs.setStatus(1);
		rs.setMsg("标记成功！");
		return rs;
	}
	/**
	 * datatable分页查询接口
	 * @param request
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping("/rest/doSearch")
	public @ResponseBody DataTablesResponse<ReservationVO> pageSearch(
			@RequestBody DataTablesRequest request) throws Throwable{
		return service.listByPage(request);
	}
}
