package egovframework.example.sample.service.eximbay;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class EximbayCommReturnVO {
	
	private String rescode;
	private String resmsg;
	private String code;
	private String message;
	private String description;
	public String getRescode() {
		return rescode;
	}
	public void setRescode(String rescode) {
		this.rescode = rescode;
	}
	public String getResmsg() {
		return resmsg;
	}
	public void setResmsg(String resmsg) {
		this.resmsg = resmsg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
