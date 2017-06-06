package com.bxoon.testMain;

import com.bxoon.core.CacheExecutor;
import com.bxoon.util.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by ZGX99 on 2017/5/24.
 */
@Controller
public class executeServlet extends javax.servlet.http.HttpServlet {

    @Autowired
    private TestClass testClass;

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        testClass.getAll();
        response.sendRedirect("test.jsp");
    }

    /**
     * 刷新缓存
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws IOException
     */
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        SpringContextUtil.getBean(CacheExecutor.class).updCache();
        response.sendRedirect("test.jsp");
    }

    public void init(ServletConfig config) throws ServletException
    {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }
}
