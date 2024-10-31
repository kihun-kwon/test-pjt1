package egovframework.example.cmmn;

import java.util.Arrays;

public enum EximbayPayStatus {
	
	READY("ready","/ready"),
	VERIFY("verify","/verify"),
	CONFIRM("confirm","/confirm"),
	RETRIEVE("retrieve","/retrieve"),
	CANCEL("cancel","/%s/cancel"),
	CATURE("capture","/%s/capture"),
	PAYMENT("payment","/payment"),
	EMPTY("","");
	
	private String title;
	private String subUrl;
	
	EximbayPayStatus(String title, String subUrl) {
		this.title = title;
		this.subUrl = subUrl;
	}
	
	public static EximbayPayStatus findByPayType(String code){
		return Arrays.stream(EximbayPayStatus.values())
				.filter(val ->  val.title.equals(code))
				.findAny().orElse(EMPTY);
	}
	
	public String getTitle(){
		return title;
	}
	public String getSubUrl(){
		return subUrl;
	}
}
