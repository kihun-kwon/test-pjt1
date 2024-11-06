package egovframework.example.sample.service.eximbay.ready;

import egovframework.example.sample.service.eximbay.EximbayCommVO;
public class EximbayReadyBuyerVO extends EximbayCommVO{

	private String name;
	private String phone_number;
	private String email;
	
	public EximbayReadyBuyerVO(){
		this.name = "";
		this.phone_number = "";
		this.email = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString(){
		return super.toString(this);
	}
}
