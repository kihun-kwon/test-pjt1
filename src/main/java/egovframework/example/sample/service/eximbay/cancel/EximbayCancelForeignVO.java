package egovframework.example.sample.service.eximbay.cancel;

import egovframework.example.sample.service.eximbay.EximbayCommVO;

public class EximbayCancelForeignVO extends EximbayCommVO {
	private String foreign_currency;
	private String foreign_amount;
	private String foreign_rate;
	
	public EximbayCancelForeignVO(){
		this.foreign_currency = "";
		this.foreign_amount = "";
		this.foreign_rate = "";
	}
	
	public String getForeign_currency() {
		return foreign_currency;
	}

	public void setForeign_currency(String foreign_currency) {
		this.foreign_currency = foreign_currency;
	}

	public String getForeign_amount() {
		return foreign_amount;
	}

	public void setForeign_amount(String foreign_amount) {
		this.foreign_amount = foreign_amount;
	}

	public String getForeign_rate() {
		return foreign_rate;
	}

	public void setForeign_rate(String foreign_rate) {
		this.foreign_rate = foreign_rate;
	}

	@Override
	public String toString(){
		return super.toString(this);
	}
}
