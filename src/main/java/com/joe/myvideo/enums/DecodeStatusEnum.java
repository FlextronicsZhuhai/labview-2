package com.joe.myvideo.enums;

public enum DecodeStatusEnum {

	WAIT_TO_FIX(0, "等候解密"),
	IS_FIXING(1, "正在解密"),
	ALREADY_TO_FIX(2, "完成解密"),
	ALREADY_TO_DOWNLOAD(3, "已经下载"),
	ALREADY_TO_DATE(4, "已经过期"),
	IS_ILLEGAL(5, "不合法文件"),
	CAN_NOT_FIX(6, "不能解密"),
	ALREADY_TO_DELETE(7, "已删除");
		
	private int key;
	private String value;
	
	public int getKey() {
		return key;
	}
	
	public String getValue() {
		return value;
	}
	
	private DecodeStatusEnum(int key, String value){
		this.key = key;
		this.value = value;
	}
	
	public static String get(int key) {
		for(DecodeStatusEnum item : DecodeStatusEnum.values()){
			if(item.getKey() == key){
				return item.getValue();
			}
		}
		return "";
	}
}
