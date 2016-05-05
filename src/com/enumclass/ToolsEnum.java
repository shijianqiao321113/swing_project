package com.enumclass;

public enum ToolsEnum {

	HTTPTOOLSREQUESTBUTTON("Send Request"),
	HTTPTOOLSTIMELABELTITLE("超时时长："),
	HTTPTOOLSURLLABELTITLE("请求URL："),
	HTTPTOOLSREQUESTTYPELABELTITLE("请求类型："),
	HTTPTOOLSSYSTEMTRAYSHOWWINDOWS("显示窗口"),
	HTTPTOOLSSYSTEMEXIT("退出(Exit)"),
	HTTPTOOLSTITLENAME("HTTP工具");
	
	private String value;
	
	private ToolsEnum(String value){
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
}
