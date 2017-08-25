package com.sourongindex.consultant.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.sourongindex.aboutsourong.domain.AboutsourongVO;
import com.sourongindex.aboutsourong.service.AboutsourongService;
import com.sourongindex.banner.domain.BannerVO;
import com.sourongindex.banner.service.BannerService;
import com.sourongindex.companyinfom.domain.CompanyinfomVO;
import com.sourongindex.companyinfom.service.CompanyinfomService;
import com.sourongindex.consultant.domain.ConsultantVO;
import com.sourongindex.consultant.service.ConsultantService;
import com.sourongindex.createHtml.util.CreateHtml;
import com.sourongindex.product.domain.ProductVO;
import com.sourongindex.product.service.ProductService;
import com.sourongindex.serviceidea.domain.ServiceideaVO;
import com.sourongindex.serviceidea.service.ServiceideaService;


@Controller
@RequestMapping("/consultant")
public class ConsultantController {
	@Autowired
	private ConsultantService service;
	@Autowired
	private CompanyinfomService companyService;
	@RequestMapping("/edit")
	public String edit(Integer consultantid,ModelMap map){
		System.out.println(consultantid);
		if(consultantid!=null){
			map.addAttribute("entity",service.get(consultantid));
		}
		System.out.println(service.get(consultantid));
		//获取所有公司
		
		List<CompanyinfomVO> companys = companyService.list();
	
		map.addAttribute("companys",companys);
		return "consultant/edit";//跳转到编辑页面
	}
	
	@RequestMapping(value="/doEdit",method=RequestMethod.POST,consumes={"multipart/form-data"})
	public @ResponseBody JsonResult doEdit(ConsultantVO entity,@RequestParam("pic")MultipartFile file) throws IOException{
		JsonResult js = new JsonResult();
		String saveImage = ConfigUtil.getValue("saveImage");
		
		if(entity.getConsultantid()!=null){//修改
			ConsultantVO consultant = service.get(entity.getConsultantid());
			String name = consultant.getConsultantpic();
			if (name != null) {
				new File(ConfigUtil.getValue("saveImage") + name).delete();// 删除原先的图片
			}
			if (!file.isEmpty()) {
				String orgname = file.getOriginalFilename();
				String savename = UUID.randomUUID() + orgname.substring(orgname.lastIndexOf("."));// 保存图片的名字唯一
				String savepath = saveImage + savename;
				System.out.println(savepath);
				FileUtils.copyInputStreamToFile(file.getInputStream(), new File(savepath));// 图片存放位置
				file.transferTo(new File(savepath));
				entity.setConsultantpic(savename);
			}
			if (service.update(entity) > 0) {// 修改成功
				js.setStatus(1);
				js.setMsg("修改成功！");

			} else {
				js.setStatus(0);
				js.setMsg("修改失败！");
			}
		}else{//新增
			if (!file.isEmpty()) {
				String orgname = file.getOriginalFilename();
				String savename = UUID.randomUUID() + orgname.substring(orgname.lastIndexOf("."));// 保存图片的名字唯一
				String savepath = saveImage + savename;
				FileUtils.copyInputStreamToFile(file.getInputStream(), new File(savepath));// 图片存放位置
				file.transferTo(new File(savepath));
				entity.setConsultantpic(savename);
			}
			if (service.add(entity) > 0) {// 新增成功
				js.setStatus(1);
				js.setMsg("新增成功！");

			} else {
				js.setStatus(0);
				js.setMsg("新增失败！");
			}
		}
		return js;//返回编辑状态
	}
	
	@RequestMapping("/rest/doDelete")
	public @ResponseBody JsonResult doDelete(Integer id){
		JsonResult rs=new JsonResult();
		if(service.delete(id)>0){
			rs.setStatus(1);
			rs.setMsg("删除成功！");
		}else{
			rs.setStatus(0);
			rs.setMsg("删除失败！");
		}
		return rs;
	}
	
	@RequestMapping("/list")
	public String list(){
		return "consultant/list";//跳转到分页查询页面
	}
	/**
	 * datatable分页查询接口
	 * @param request
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping("/rest/doSearch")
	public @ResponseBody DataTablesResponse<ConsultantVO> pageSearch(
			@RequestBody DataTablesRequest request) throws Throwable{
		return service.listByPage(request);
	}
	
	
}
