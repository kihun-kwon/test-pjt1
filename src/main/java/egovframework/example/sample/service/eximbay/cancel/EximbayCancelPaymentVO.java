package egovframework.example.sample.service.eximbay.cancel;

import egovframework.example.sample.service.eximbay.EximbayCommVO;

public class EximbayCancelPaymentVO extends EximbayCommVO {
	private String order_id;
	private String currency;
	private String amount;
	private String balance;
	private String lang;
	
	//취소 수신
	private String transaction_id;
	private String auth_code;
	private String base_amount;
	private String base_rate;
	private String dcc_rate;
	
	public EximbayCancelPaymentVO(){
		this.order_id = "";
		this.currency = "";
		this.amount = "";
		this.balance = "";
		this.lang = "";
		this.transaction_id = "";
		this.auth_code = "";
		this.base_amount = "";
		this.base_rate = "";
		this.dcc_rate = "";
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
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

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getAuth_code() {
		return auth_code;
	}

	public void setAuth_code(String auth_code) {
		this.auth_code = auth_code;
	}

	public String getBase_amount() {
		return base_amount;
	}

	public void setBase_amount(String base_amount) {
		this.base_amount = base_amount;
	}

	public String getBase_rate() {
		return base_rate;
	}

	public void setBase_rate(String base_rate) {
		this.base_rate = base_rate;
	}

	public String getDcc_rate() {
		return dcc_rate;
	}

	public void setDcc_rate(String doc_rate) {
		this.dcc_rate = doc_rate;
	}

	public String toString(){
		return super.toString(this);
	}
}
