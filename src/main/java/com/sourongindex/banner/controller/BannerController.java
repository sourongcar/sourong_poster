package com.sourongindex.banner.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import com.base.common.domain.JsonResult;
import com.base.common.util.ConfigUtil;
import com.base.datatables.domain.DataTablesRequest;
import com.base.datatables.domain.DataTablesResponse;
import com.sourongindex.banner.domain.BannerVO;
import com.sourongindex.banner.service.BannerService;


@Controller
@RequestMapping("/banner")
public class BannerController {
	@Autowired
	private BannerService service;
	
	@RequestMapping("/edit")
	public String edit(Integer bannerid,ModelMap map){
		if(bannerid!=null){
			map.addAttribute("entity",service.get(bannerid));
		}
		return "banner/edit";//跳转到编辑页面
	}
	
	@RequestMapping(value="/doEdit",method=RequestMethod.POST,consumes={"multipart/form-data"})
	public String doEdit(BannerVO entity,Integer bannerid,@RequestParam("pic")MultipartFile file) throws IOException{
		String saveImage=ConfigUtil.getValue("saveImage");
		
		if(entity.getBannerid()!=null){//修改
			BannerVO banner=service.get(bannerid);
			String name=banner.getPicname();
			if(name!=null){
				new File(ConfigUtil.getValue("saveImage")+name).delete();//删除原先的图片
			}
			if(!file.isEmpty()){
				String orgname=file.getOriginalFilename();
				String savename=UUID.randomUUID()+orgname.substring(orgname.lastIndexOf("."));//保存图片的名字唯一
				String savepath=saveImage+savename;
				FileUtils.copyInputStreamToFile(file.getInputStream(), new File(savepath));//图片存放位置
				file.transferTo(new File(savepath));
				entity.setPicname(savename);
			}
			service.update(entity);
		}else{//新增
			if(!file.isEmpty()){	
				String orgname=file.getOriginalFilename();
				String savename=UUID.randomUUID()+orgname.substring(orgname.lastIndexOf("."));//保存图片的名字唯一
				String savepath=saveImage+savename;
				FileUtils.copyInputStreamToFile(file.getInputStream(), new File(savepath));//图片存放位置
				file.transferTo(new File(savepath));
				entity.setPicname(savename);
			}
			service.add(entity);
		}
		return "redirect:/banner/list.action";//跳转到列表页面
	}
	
	@RequestMapping("/rest/doDelete")
	public @ResponseBody JsonResult doDelete(Integer bannerid){
		JsonResult rs=new JsonResult();
		BannerVO banner=service.get(bannerid);
		String name=banner.getPicname();
		if(name!=null){	
			new File(ConfigUtil.getValue("saveImage")+name).delete();
		}
		service.delete(bannerid);
		rs.setStatus(1);
		rs.setMsg("删除成功！");
		return rs;
	}
	
	@RequestMapping("/list")
	public String list(){
		return "banner/list";//跳转到分页查询页面
	}
	/**
	 * datatable分页查询接口
	 * @param request
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping("/rest/doSearch")
	public @ResponseBody DataTablesResponse<BannerVO> pageSearch(
			@RequestBody DataTablesRequest request) throws Throwable{
		return service.listByPage(request);
	}
}
