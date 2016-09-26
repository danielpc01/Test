package refactory.util.enums;

public enum ConstantFatherEnum {
	
	LOG_TYPE("LOG TYPE","1");
	
	ConstantFatherEnum(String name, String value1){
		this.name=name;
		this.value1=value1;
	
	}
	
	private String name;
	private String value1;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue1() {
		return value1;
	}
	public void setValue1(String value1) {
		this.value1 = value1;
	}
	
	
	
}
