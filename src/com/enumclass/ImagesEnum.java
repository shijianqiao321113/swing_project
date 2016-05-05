package com.enumclass;

public enum ImagesEnum {
	
	HTTP_TOOLS_TRAYICON_IMAGE("http_tools_TrayIcon_image"),//http工具托盘图标
	HTTP_TOOLS_WINDOWS_IMAGE("http_tools_windows_image");//http工具窗口图标
	
	private String value;
	
	private ImagesEnum(String value){
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

}
