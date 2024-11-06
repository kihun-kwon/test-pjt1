package egovframework.example.sample.service.eximbay.cancel;

import egovframework.example.sample.service.eximbay.EximbayCommReturnVO;

public class EximbayCancelReturnVO extends EximbayCommReturnVO{

	private String mid;
	private EximbayCancelRefundVO refund;
	private EximbayCancelPaymentVO payment;
	private EximbayCancelForeignVO foreign;
	private EximbayCancelOtherParamVO other_param;
	
	public EximbayCancelReturnVO(){
		this.mid = "";
		this.refund = new EximbayCancelRefundVO();
		this.payment = new EximbayCancelPaymentVO();
		this.foreign = new EximbayCancelForeignVO();
		this.other_param = new EximbayCancelOtherParamVO();
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public EximbayCancelRefundVO getRefund() {
		return refund;
	}

	public void setRefund(EximbayCancelRefundVO refund) {
		this.refund = refund;
	}

	public EximbayCancelPaymentVO getPayment() {
		return payment;
	}

	public void setPayment(EximbayCancelPaymentVO payment) {
		this.payment = payment;
	}

	public EximbayCancelForeignVO getForeign() {
		return foreign;
	}

	public void setForeign(EximbayCancelForeignVO foreign) {
		this.foreign = foreign;
	}

	public EximbayCancelOtherParamVO getOther_param() {
		return other_param;
	}

	public void setOther_param(EximbayCancelOtherParamVO other_param) {
		this.other_param = other_param;
	}
}
