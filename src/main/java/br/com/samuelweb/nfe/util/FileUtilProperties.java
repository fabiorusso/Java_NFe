package br.com.samuelweb.nfe.util;

public enum FileUtilProperties {
	
	BUFFER_SIZE("file.buffer.size", "8192", 8192);
	
	FileUtilProperties(final String name, final String value, final int intValue) {
		this.name=name;
		this.intValue = intValue;
		this.value = value;
	}
	
	private int intValue;
	private String name;
	private String value;
	
	public int getIntValue() {
		return intValue;
	}
	public String getName() {
		return name;
	}
	public String getValue() {
		return value;
	}
	
	
	
}
