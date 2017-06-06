package com.bxoon.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * Created by ZGX99 on 2017/5/23.
 */
public class EntityUtil<T> {

    private static class Sing {
        private static EntityUtil singleton = new EntityUtil();
    }

    public static EntityUtil getSingleton(){
        return Sing.singleton;
    }

    public <T> T MapToTransEntity(Class<T> cla, Map<String, Object> maps) {
        T obj = null;
        try {
            obj = cla.newInstance();
            Set keySet = maps.keySet();
            Object[] keyObjs = keySet.toArray();
            for (Object keyName : keyObjs) {
                String fieldName = keyName.toString().toLowerCase();
//                // 识别KEY中带下划线的情况
//                if (fieldName.split("_").length > 1) {
//                    String[] nameArray = fieldName.split("_");
//                    fieldName = nameArray[0];
//                    for (int i = 1; i < nameArray.length; i++) {
//                        String nameUp = nameArray[i].substring(0, 1)
//                                .toUpperCase()
//                                + nameArray[i].substring(1);
//                        fieldName += nameUp;
//                    }
//                }
                // 遍历根据参数名遍历fields
                for (Field field : cla.getDeclaredFields()) {
                        String fieldname1 = field.getName().toLowerCase();
                        fieldName = fieldName.toLowerCase();
                        if (fieldname1.equals(fieldName)) {
                            fieldName = field.getName();
                            String methodName = "set"
                                    + fieldName.substring(0, 1).toUpperCase()
                                    + fieldName.substring(1);
                            Method method = cla.getDeclaredMethod(methodName,
                                    field.getType());
                            if (null != maps.get(keyName)) {
                                if ("String".equals(field.getType()
                                        .getSimpleName().toString())) {
                                    String temp = maps.get(keyName).toString();
                                    method.invoke(obj, temp);
                                }
                                if ("Integer".equals(field.getType()
                                        .getSimpleName().toString())) {
                                    Integer temp = Integer.valueOf(maps.get(
                                            keyName).toString());
                                    method.invoke(obj, temp);
                                }
                                if ("int".equals(field.getType()
                                        .getSimpleName().toString())) {
                                    Integer temp = Integer.valueOf(maps.get(
                                            keyName).toString());
                                    method.invoke(obj, temp);
                                }
                                if ("Long".equals(field.getType()
                                        .getSimpleName().toString())) {
                                    Long temp = Long.valueOf(maps.get(keyName)
                                            .toString());
                                    method.invoke(obj, temp);
                                }
                                if ("long".equals(field.getType()
                                        .getSimpleName().toString())) {
                                    Long temp = Long.valueOf(maps.get(keyName)
                                            .toString());
                                    method.invoke(obj, temp);
                                }
                                if ("Date".equals(field.getType()
                                        .getSimpleName().toString())) {
                                    Date temp = (Date) maps.get(keyName);
                                    method.invoke(obj, temp);
                                }
                                if ("BigDecimal".equals(field.getType()
                                        .getSimpleName().toString())) {
                                    BigDecimal temp = new BigDecimal(maps.get(
                                            keyName).toString());
                                    method.invoke(obj, temp);
                                }
                            }
                        }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
