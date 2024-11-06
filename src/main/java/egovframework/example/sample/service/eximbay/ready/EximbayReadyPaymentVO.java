package egovframework.example.sample.service.eximbay.ready;

import egovframework.example.sample.service.eximbay.EximbayCommVO;

public class EximbayReadyPaymentVO extends EximbayCommVO {

	private String order_id;
	private String transaction_type;
	private String currency;
	private String amount;
	private String lang;
	private String payment_method;
	private String multi_payment_method;
	
	public EximbayReadyPaymentVO(){
		this.order_id = "";
		this.transaction_type = "";
		this.currency = "";
		this.amount = "";
		this.lang = "";
		this.payment_method = "";
		this.multi_payment_method = "";
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getPayment_method() {
		return payment_method;
	}

	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}

	public String getMulti_payment_method() {
		return multi_payment_method;
	}

	public void setMulti_payment_method(String multi_payment_method) {
		this.multi_payment_method = multi_payment_method;
	}
	
	@Override
	public String toString(){
		return super.toString(this);
	}
}
