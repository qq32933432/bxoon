package com.bxoon.test;

import com.bxoon.dao.BaseDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by ZGX99 on 2017/5/23.
 */
public class testMain extends JdbcDaoSupport {

    @Autowired
    private BaseDao baseDao;
    @Test
    public void getAll(){
        ApplicationContext ac=new FileSystemXmlApplicationContext("classpath*:spring/applicationContext.xml");//利用文件系统查询applicationContext.xml配置文件
        System.out.println(ac.getBean("baseDao"));
        System.out.println(baseDao);
//        NorthMan n=(NorthMan) ac.getBean(northMan);
//        n.eat();
//        n.drink();
//        SouthMan s=(SouthMan)ac.getBean(southMan);
//        s.eat();
//        s.drink();
    }
}
