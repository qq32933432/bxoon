package com.bxoon.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by ZGX99 on 2017/5/23.
 */
public class BaseDao{

    private DataSource dataSource;

    public BaseDao(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public <T> List<T> getAll(String tableName){
        StringBuilder sql = new StringBuilder("select * from ");
        sql.append(tableName);
        List list = new JdbcTemplate(dataSource).queryForList(sql.toString());
        return list;
    }
}
