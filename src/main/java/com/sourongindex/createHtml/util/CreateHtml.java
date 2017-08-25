package com.sourongindex.createHtml.util;

import java.io.FileWriter;
import java.util.Locale;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class CreateHtml{

private final Configuration config = new Configuration(
			Configuration.VERSION_2_3_26);	
public void exportHtml(String name,Map<String,Object> root,String outFile){
	FileWriter out=null;
	try {
		out=new FileWriter("F:\\sourongindex\\"+outFile);
		config.setEncoding(Locale.CHINA, "UTF-8");
		config.setClassForTemplateLoading(CreateHtml.class,"/com/sourongindex/createHtml/util");
		Template template=config.getTemplate(name);
		config.setClassicCompatible(true);
		//config.isClassicCompatible();
		template.process(root, out);
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		if(out!=null){
			try {
				out.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
}
