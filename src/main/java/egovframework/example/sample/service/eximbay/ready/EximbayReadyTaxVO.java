package egovframework.example.sample.service.eximbay.ready;

import egovframework.example.sample.service.eximbay.EximbayCommVO;

public class EximbayReadyTaxVO extends EximbayCommVO {

	private String receipt_status;
	private String amount_tax_free;
	private String amount_taxable;
	private String amount_vat;
	private String amount_service_fee;
	
	public EximbayReadyTaxVO(){
		this.receipt_status = "";
		this.amount_tax_free = "";
		this.amount_taxable = "";
		this.amount_vat = "";
		this.amount_service_fee = "";
	}

	public String getReceipt_status() {
		return receipt_status;
	}

	public void setReceipt_status(String receipt_status) {
		this.receipt_status = receipt_status;
	}

	public String getAmount_tax_free() {
		return amount_tax_free;
	}

	public void setAmount_tax_free(String amount_tax_free) {
		this.amount_tax_free = amount_tax_free;
	}

	public String getAmount_taxable() {
		return amount_taxable;
	}

	public void setAmount_taxable(String amount_taxable) {
		this.amount_taxable = amount_taxable;
	}

	public String getAmount_vat() {
		return amount_vat;
	}

	public void setAmount_vat(String amount_vat) {
		this.amount_vat = amount_vat;
	}

	public String getAmount_service_fee() {
		return amount_service_fee;
	}

	public void setAmount_service_fee(String amount_service_fee) {
		this.amount_service_fee = amount_service_fee;
	}
	@Override
	public String toString(){
		return super.toString(this);
	}
}
