package egovframework.example.sample.service.eximbay.ready;

import egovframework.example.sample.service.eximbay.EximbayCommVO;

public class EximbayReadyProductVO extends EximbayCommVO {

	private String product_id;
	private String name;
	private String quantity;
	private String unit_price;
	private String link;
	
	public EximbayReadyProductVO(){
		this.product_id = "";
		this.name = "";
		this.quantity = "";
		this.unit_price = "";
		this.link = "";
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(String unit_price) {
		this.unit_price = unit_price;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	@Override
	public String toString(){
		return super.toString(this);
	}
}
