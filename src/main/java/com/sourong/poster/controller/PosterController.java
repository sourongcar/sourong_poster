package com.sourong.poster.controller;

import java.io.File;

import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.base.common.domain.CurrentUser;
import com.base.common.domain.JsonResult;
import com.base.common.util.ConfigUtil;
import com.base.common.util.IDUtil;
import com.base.datatables.domain.DataTablesRequest;
import com.base.datatables.domain.DataTablesResponse;
import com.sourong.poster.domain.PosterVO;
import com.sourong.poster.service.PosterService;


@Controller
@RequestMapping("/poster")
public class PosterController {
	@Autowired
	private PosterService service;
	
	@RequestMapping("/edit")
	public String edit(Integer id,ModelMap map){
		if(id!=null){
			map.addAttribute("entity",service.get(id));
		}
		return "poster/edit";//跳转到编辑页面
	}
	
	@RequestMapping("/doEdit")
	public String doEdit(@Valid PosterVO entity,BindingResult br,MultipartFile pic) throws Exception{
		if (br.hasErrors())
			throw new Exception(br.getFieldError().getDefaultMessage());
		else {
			int result = 0;
			if (pic != null && pic.getSize() > 0) {
				if (pic.getSize() > (1024 * 512))
					throw new IllegalArgumentException("图片文件太大");
				switch (pic.getContentType()) {
				case "image/jpeg":
				case "image/png":
				case "image/gif":
					break;
				default:
					throw new IllegalArgumentException("图片类型错误");
				}
				String desName = "poster/" + IDUtil.uuid() + '.'
						+ FilenameUtils.getExtension(pic.getOriginalFilename());
				pic.transferTo(new File(ConfigUtil.getValue("saveImage") + desName));
				entity.setPosterurl(desName);
			}
			if (entity.getPosterid() != null) {// 修改
				result = service.update(entity);
			} else {// 新增
				result = service.add(entity);
			}
			if (result == 1)
				return "redirect:/poster/list.action";// 跳转到列表页面
			else {
				return "redirect:edit.action?id=" + entity.getPosterid();
			}
		}
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
		return "poster/list";//跳转到分页查询页面
	}
	/**
	 * datatable分页查询接口
	 * @param request
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping("/rest/doSearch")
	public @ResponseBody DataTablesResponse<PosterVO> pageSearch(
			@RequestBody DataTablesRequest request) throws Throwable{
		return service.listByPage(request);
	}
}
