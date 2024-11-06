package egovframework.example.sample.service.eximbay.cancel;

import egovframework.example.sample.service.eximbay.EximbayCommVO;

public class EximbayCancelRefundAccountVO extends EximbayCommVO {

	private String user_name;
	private String bank_code;
	private String account_number;
	
	public EximbayCancelRefundAccountVO(){
		this.user_name = "";
		this.bank_code = "";
		this.account_number = "";
	}
	
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getBank_code() {
		return bank_code;
	}

	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	@Override
	public String toString(){
		return super.toString(this);
	}
}
