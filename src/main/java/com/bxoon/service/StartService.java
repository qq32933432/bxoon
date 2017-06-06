package com.bxoon.service;

import com.bxoon.Annotation.Cache;
import com.bxoon.dao.BaseDao;
import com.bxoon.util.EntityUtil;
import com.bxoon.util.PackageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by ZGX99 on 2017/5/23.
 */
public class StartService {

    private String scanPath;

    private BaseDao baseDao;

    private EntityUtil entityUtil;

    private Map<String, Object> cacheMap;

    public StartService(){
        entityUtil = EntityUtil.getSingleton();
        cacheMap = new HashMap<>();
    }

    public StartService(BaseDao baseDao){
        this.baseDao = baseDao;
    }

    public Map<String, Object> getCache() {
        return cacheMap;
    }

    public void init(){
        try {
            cacheMap.clear();
            List<Class<?>> lodClassList = new ArrayList<Class<?>>();
            List<String> className_list = PackageUtil.getClassName(scanPath);
            for (String className:className_list){
                Class<?> clazz = Class.forName(className);
                if (clazz.isAnnotationPresent(Cache.class)){
                    lodClassList.add(clazz);
                }
            }
            for (Class<?> lodClass:lodClassList){
                Cache cache = lodClass.getAnnotation(Cache.class);
                String className = lodClass.getName();
                String tableName = "";
                if (className.indexOf(".")>0) {
                    tableName = className.substring(className.lastIndexOf(".")+1);
                }
                if (!StringUtils.isEmpty(cache.tableName())){
                    tableName = cache.tableName();
                }
                List list = baseDao.getAll(tableName);

                List data_list = new LinkedList();
                try {
                    Class<?> clazz = Class.forName(lodClass.getName());
                    for (Object map:list){
                        Object o = entityUtil.MapToTransEntity(clazz,(Map<String, Object>) map);
                        data_list.add(o);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                cacheMap.put(className,data_list);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void setScanPath(String scanPath) {
        this.scanPath = scanPath;
    }

    public BaseDao getBaseDao() {
        return baseDao;
    }

    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

}
