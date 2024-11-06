package egovframework.example.sample.service.eximbay.ready;

import egovframework.example.sample.service.eximbay.EximbayCommVO;

public class EximbayReadyMerchantVO extends EximbayCommVO {

	private String mid;
	private String shop;
	private String partner_code;

	public EximbayReadyMerchantVO(){
		this.mid = "";
		this.shop = "";
		this.partner_code = "";
	}
	
	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getShop() {
		return shop;
	}

	public void setShop(String shop) {
		this.shop = shop;
	}

	public String getPartner_code() {
		return partner_code;
	}

	public void setPartner_code(String partner_code) {
		this.partner_code = partner_code;
	}

	@Override
	public String toString(){
		return super.toString(this);
	}
}
