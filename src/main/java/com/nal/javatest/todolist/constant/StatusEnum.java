package com.nal.javatest.todolist.constant;

public enum StatusEnum {
	PLANNING, 
	DOING, 
	COMPLETE;

	String value;

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
