package refactory.util.enums;

public enum LogTypeEnum {
	
	INFO("INFO","1"),
	ERROR("ERROR","2"),
	WARNING("WARNING","3");
	
	LogTypeEnum(String name, String value1){
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
	
	public static boolean contains(String id){
		boolean contains=false;
		for(LogTypeEnum type: LogTypeEnum.values()){
			if(type.getValue1().equals(id)){
				contains=true;
				break;
			}
		}
		return contains;
	}
}
