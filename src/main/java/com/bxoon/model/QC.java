package com.bxoon.model;

/**
 * Created by ZGX99 on 2017/5/24.
 *
 * 查询条件对象
 */
public class QC {
    private String name;
    private Object value;

    public QC(){

    }

    public QC(String name, Object value){
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "QC{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
