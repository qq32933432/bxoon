package com.bxoon.testMain;

import com.bxoon.Annotation.Cache;

/**
 * 
 * @author ZGX99
 * 
 *数据字典表
 */
@Cache(tableName = "t_bxoon_dictionary")
public class t_dictionary {
	private String data_key="1";
	private String key_desc;
	private String key_name;
	private String super_key;
	private String value;
	
	public String getData_key() {
		return data_key;
	}
	public void setData_key(String data_key) {
		this.data_key = data_key;
	}
	public String getKey_desc() {
		return key_desc;
	}
	public void setKey_desc(String key_desc) {
		this.key_desc = key_desc;
	}
	public String getKey_name() {
		return key_name;
	}
	public void setKey_name(String key_name) {
		this.key_name = key_name;
	}
	public String getSuper_key() {
		return super_key;
	}
	public void setSuper_key(String super_key) {
		this.super_key = super_key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
