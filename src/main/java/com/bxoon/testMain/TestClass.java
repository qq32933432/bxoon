package com.bxoon.testMain;

import com.bxoon.core.CacheExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ZGX99 on 2017/5/23.
 *
 * 测试程序
 */
@Service
public class TestClass {

    @Resource(type = CacheExecutor.class)
    private CacheExecutor cacheExecutor;

    /**
     * 获取所有
     */
    public void getAll(){
        List<t_dictionary> list = cacheExecutor.getByField(t_dictionary.class);
        for (t_dictionary t:list){
            System.out.println(t.getValue());
        }
    }

    /**
     * 条件查询
     */
    public void getByField(){
        List<t_dictionary> list = cacheExecutor.getByField(t_dictionary.class);
        for (t_dictionary t:list){
            System.out.println(t.getValue());
        }
    }

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        Integer[] ints = new Integer[5];
        ints[0]=1;
        ints[1]=1;
        ints[2]=1;

        List list = Arrays.asList(ints);

        testClass.ty();
    }

    void ty(){

        try {
            System.out.println(this.getClass().getClassLoader().loadClass("TestClass").getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
