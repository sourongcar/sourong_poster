package com.sourongindex.companyinfom.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.util.UUID;
import java.io.FileInputStream;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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

import com.base.common.domain.CurrentUser;
import com.base.common.domain.JsonResult;
import com.base.common.util.ConfigUtil;
import com.base.datatables.domain.DataTablesRequest;
import com.base.datatables.domain.DataTablesResponse;
import com.sourongindex.companyinfom.domain.CompanyinfomVO;
import com.sourongindex.companyinfom.service.CompanyinfomService;


@Controller
@RequestMapping("/companyinfom")
public class CompanyinfomController {
	@Autowired
	private CompanyinfomService service;
	
	@RequestMapping("/edit")
	public String edit(Integer companyid,ModelMap map){
		if(companyid!=null){
			map.addAttribute("entity",service.get(companyid));
		}
		return "companyinfom/edit";//跳转到编辑页面
	}
	
	@RequestMapping(value="/doEdit",method=RequestMethod.POST,consumes={"multipart/form-data"})
	public String doEdit(CompanyinfomVO entity,Integer companyid,@RequestParam("logopic")MultipartFile filelogo,@RequestParam("qrpic")MultipartFile fileqr) throws IOException{		
		String saveImage=ConfigUtil.getValue("saveImage");
		CompanyinfomVO covo=service.get(companyid);
		String logo=covo.getCompanylogo();
		
		if(!filelogo.isEmpty()){
			String orgname=filelogo.getOriginalFilename();
			String savename=UUID.randomUUID()+orgname.substring(orgname.lastIndexOf("."));//保存图片的名字唯一
			String savepath=saveImage+savename;
			FileUtils.copyInputStreamToFile(filelogo.getInputStream(), new File(savepath));//图片存放位置
			filelogo.transferTo(new File(savepath));
			entity.setCompanylogo(savename);
		}
		String qr=covo.getCompanyqr();
		
		if(!fileqr.isEmpty()){
			String orgname=fileqr.getOriginalFilename();
			String savename=UUID.randomUUID()+orgname.substring(orgname.lastIndexOf("."));//保存图片的名字唯一
			String savepath=saveImage+savename;
			FileUtils.copyInputStreamToFile(fileqr.getInputStream(), new File(savepath));//图片存放位置
			fileqr.transferTo(new File(savepath));
			entity.setCompanyqr(savename);
			
		}
		service.update(entity);
		return "redirect:/companyinfom/list.action";//跳转到列表页面
	}
	
	
	@RequestMapping("/list")
	public String list(){
		return "companyinfom/list";//跳转到分页查询页面
	}
	/**
	 * datatable分页查询接口
	 * @param request
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping("/rest/doSearch")
	public @ResponseBody DataTablesResponse<CompanyinfomVO> pageSearch(
			@RequestBody DataTablesRequest request) throws Throwable{
		return service.listByPage(request);
	}
}
