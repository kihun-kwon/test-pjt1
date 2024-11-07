package egovframework.example.sample.service.eximbay.ready;

import java.util.ArrayList;
import java.util.List;
import egovframework.example.cmmn.EximbayService;

public class EximbayReadyOrderVO {

	private String fgkey;
	private EximbayReadyPaymentVO payment;
	private EximbayReadyMerchantVO merchant;
	private EximbayReadyUrlVO url;
	private EximbayReadyBuyerVO buyer;
	private EximbayReadyTaxVO tax;
	private EximbayReadyOtherParamVO other_param;
	private List<EximbayReadyProductVO> product;
	//private List<EximbaySurcharge> surchargeList;
	//private ShipToVO shipToVO;
	//private BillToVO billToVO;
	private EximbayReadySettingsVO settings;
	
	public EximbayReadyOrderVO(){
		this.fgkey = "";
		this.payment = new EximbayReadyPaymentVO();
		this.merchant = new EximbayReadyMerchantVO();
		this.url = new EximbayReadyUrlVO();
		this.buyer = new EximbayReadyBuyerVO();
		this.tax = new EximbayReadyTaxVO();
		this.other_param = new EximbayReadyOtherParamVO();
		this.settings = new EximbayReadySettingsVO();
		this.product = new ArrayList<EximbayReadyProductVO>();
	}

	public String getFgkey() {
		return fgkey;
	}

	public void setFgkey(String fgkey) {
		this.fgkey = fgkey;
	}
	
	public EximbayReadyPaymentVO getPayment() {
		return payment;
	}

	public void setPayment(EximbayReadyPaymentVO payment) {
		this.payment = payment;
	}

	public EximbayReadyMerchantVO getMerchant() {
		return merchant;
	}

	public void setMerchant(EximbayReadyMerchantVO merchant) {
		this.merchant = merchant;
	}

	public EximbayReadyUrlVO getUrl() {
		return url;
	}

	public void setUrl(EximbayReadyUrlVO url) {
		this.url = url;
	}

	public EximbayReadyBuyerVO getBuyer() {
		return buyer;
	}

	public void setBuyer(EximbayReadyBuyerVO buyer) {
		this.buyer = buyer;
	}

	public EximbayReadyTaxVO getTax() {
		return tax;
	}

	public void setTax(EximbayReadyTaxVO tax) {
		this.tax = tax;
	}

	public EximbayReadyOtherParamVO getOther_param() {
		return other_param;
	}

	public void setOther_param(EximbayReadyOtherParamVO other_param) {
		this.other_param = other_param;
	}

	public List<EximbayReadyProductVO> getProduct() {
		return product;
	}

	public void setProduct(List<EximbayReadyProductVO> product) {
		this.product = product;
	}

	public EximbayReadySettingsVO getSettings() {
		return settings;
	}

	public void setSettings(EximbayReadySettingsVO settings) {
		this.settings = settings;
	}

	//private List<EximbaySurcharge> surchargeList;
	//private ShipToVO shipToVO;
	//private BillToVO billToVO;
	public String toString(){
		String str = "";
		try {
			str = EximbayService.appendClassVariable(this);
		} catch (Exception e) {
			throw new RuntimeException();
		}
		str = "{\n" + str + "}";
		return str;
	}
}
