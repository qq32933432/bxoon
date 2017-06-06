package com.bxoon.core;

import com.bxoon.model.QC;
import com.bxoon.service.StartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by ZGX99 on 2017/5/24.
 */
public class CacheExecutor {

    private StartService startService;

    private Map<String,Object> cache;

    public CacheExecutor(StartService startService){
        this.startService = startService;
        cache = startService.getCache();
    }

    /**
     * 更新缓存入口
     */
    public void updCache(){
        startService.init();
    }

    /**
     * 全等条件查询入口
     */
    public <T> T getByField(Class<?> paramClass, QC... queryCondition){
        List<Object> returnlist = new LinkedList<>();
        try {
            String className = paramClass.getName();
            List<Object> list = (List<Object>)cache.get(className);
            for (Object obj:list){
                boolean bool = true;
                for (QC qc:queryCondition){
                    Field field = obj.getClass().getDeclaredField(qc.getName());
                    field.setAccessible(true);
                    Object value = field.get(obj);
                    if (!value.equals(qc.getValue())){
                        bool = false;
                    }
                }
                if(bool) {
                    returnlist.add(obj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T)returnlist;
    }

    /**
     * 模糊查询入口
     */



    public StartService getStartService() {
        return startService;
    }

    public void setStartService(StartService startService) {
        this.startService = startService;
    }
}
