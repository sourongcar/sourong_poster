package com.base.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.base.common.util.ConfigUtil;

@WebListener
public class InitListener implements ServletContextListener {

    public InitListener() {
    }

    public void contextInitialized(ServletContextEvent evnet)  { 
    	
    	evnet.getServletContext().setAttribute("path", ConfigUtil.getValue("adminUrl"));
    }

    public void contextDestroyed(ServletContextEvent evnet)  { 
    }
	
}
