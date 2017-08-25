package com.sourongindex.createHtml.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sourongindex.aboutsourong.domain.AboutsourongVO;
import com.sourongindex.aboutsourong.service.AboutsourongService;
import com.sourongindex.banner.domain.BannerVO;
import com.sourongindex.banner.service.BannerService;
import com.sourongindex.companyinfom.domain.CompanyinfomVO;
import com.sourongindex.companyinfom.service.CompanyinfomService;
import com.sourongindex.consultant.domain.ConsultantVO;
import com.sourongindex.consultant.service.ConsultantService;
import com.sourongindex.product.domain.ProductVO;
import com.sourongindex.product.service.ProductService;
import com.sourongindex.serviceidea.domain.ServiceideaVO;
import com.sourongindex.serviceidea.service.ServiceideaService;

@Controller
@RequestMapping("/create")
public class CreateHtmlControl {
	@Autowired
	private ConsultantService service;
	@Autowired
	private CompanyinfomService companyService;
	@Autowired
	private ServiceideaService ideaService;
	@Autowired
	private AboutsourongService aboutService;
	@Autowired
	private ProductService proService;
	@Autowired
	private BannerService bannerService;
	
	@RequestMapping("/html")
	public String export(){
		CreateHtml html=new CreateHtml();
		Map<String, Object> root=new HashMap<String, Object>();
		List<ConsultantVO> list=service.list();
		CompanyinfomVO company=companyService.get(1);
		List<ServiceideaVO> idealist=ideaService.list();
		AboutsourongVO about=aboutService.get(1);
		List<ProductVO> prolist=proService.list();
		
		List<BannerVO> banlist=bannerService.list();
		root.put("Consultants", list);
		root.put("Serviceideas", idealist);
		root.put("Prouducts", prolist);
		root.put("Banners", banlist);
		root.put("servicePhone",company.getServicephone());
		root.put("serviceTime", company.getServicetime());
		root.put("companyaddress", company.getCompanyaddress());
		root.put("detailaddress", company.getDetailaddress());
		root.put("companyqr",company.getCompanyqr());
		root.put("companylogo", company.getCompanylogo());
		root.put("title", about.getTitle());
		root.put("aboutpic", about.getPicname());
		root.put("specificDescribe", about.getSpecificdescribe());
		html.exportHtml("home", root, "home.html");
		return "consultant/succeed";
	}
}
