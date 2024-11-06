package egovframework.example.sample.service.eximbay.cancel;

import egovframework.example.cmmn.EximbayService;

public class EximbayCancelOrderVO {

	private String mid;
	private EximbayCancelPaymentVO payment;
	private EximbayCancelRefundVO refund;
	private EximbayCancelOtherParamVO other_param;
	private EximbayCancelRefundAccountVO refund_account;
	private EximbayCancelTaxVO tax;
	
	public EximbayCancelOrderVO(){
		this.mid = "";
		this.payment = new EximbayCancelPaymentVO();
		this.refund = new EximbayCancelRefundVO();
		this.other_param = new EximbayCancelOtherParamVO();
		this.refund_account = new EximbayCancelRefundAccountVO();
		this.tax = new EximbayCancelTaxVO();
	}
	
	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public EximbayCancelPaymentVO getPayment() {
		return payment;
	}

	public void setPayment(EximbayCancelPaymentVO payment) {
		this.payment = payment;
	}

	public EximbayCancelRefundVO getRefund() {
		return refund;
	}

	public void setRefund(EximbayCancelRefundVO refund) {
		this.refund = refund;
	}

	public EximbayCancelOtherParamVO getOther_param() {
		return other_param;
	}

	public void setOther_param(EximbayCancelOtherParamVO other_param) {
		this.other_param = other_param;
	}

	public EximbayCancelRefundAccountVO getRefund_account() {
		return refund_account;
	}

	public void setRefund_account(EximbayCancelRefundAccountVO refund_account) {
		this.refund_account = refund_account;
	}

	public EximbayCancelTaxVO getTax() {
		return tax;
	}

	public void setTax(EximbayCancelTaxVO tax) {
		this.tax = tax;
	}

	public String toString(){
		String str = EximbayService.appendClassVariable(this);
		str = "{\n" + str + "}";
		return str;
	}
}
