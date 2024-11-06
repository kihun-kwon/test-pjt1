package egovframework.example.sample.service.eximbay.cancel;

import egovframework.example.sample.service.eximbay.EximbayCommVO;

public class EximbayCancelRefundVO extends EximbayCommVO {

	//취소 송신
	private String refund_type;
	private String reason;
	
	//취소 수신
	private String refund_date;
	private String refund_transaction_id;
	
	//공통
	private String refund_amount;
	private String refund_id;
	
	public EximbayCancelRefundVO(){
		this.refund_type = "";
		this.refund_amount = "";
		this.refund_id = "";
		this.reason = "";
		this.refund_date = "";
		this.refund_transaction_id = "";
	}
	
	public String getRefund_type() {
		return refund_type;
	}

	public void setRefund_type(String refund_type) {
		this.refund_type = refund_type;
	}

	public String getRefund_amount() {
		return refund_amount;
	}

	public void setRefund_amount(String refund_amount) {
		this.refund_amount = refund_amount;
	}

	public String getRefund_id() {
		return refund_id;
	}

	public void setRefund_id(String refund_id) {
		this.refund_id = refund_id;
	}

	public String getReason() {
		return reason;
	}
	
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public String getRefund_date() {
		return refund_date;
	}

	public void setRefund_date(String refund_date) {
		this.refund_date = refund_date;
	}

	public String getRefund_transaction_id() {
		return refund_transaction_id;
	}

	public void setRefund_transaction_id(String refund_transaction_id) {
		this.refund_transaction_id = refund_transaction_id;
	}
	@Override
	public String toString(){
		return super.toString(this);
	}
}
