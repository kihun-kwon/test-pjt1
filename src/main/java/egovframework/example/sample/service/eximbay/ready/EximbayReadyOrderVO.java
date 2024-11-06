package egovframework.example.sample.service.eximbay.ready;

import java.util.ArrayList;
import java.util.List;
import egovframework.example.cmmn.EximbayService;

public class EximbayReadyOrderVO {

	private String fgkey;
	private EximbayReadyPaymentVO eximbayPaymentVO;
	private EximbayReadyMerchantVO eximbayMerchantVO;
	private EximbayReadyUrlVO eximbayUrlVO;
	private EximbayReadyBuyerVO eximbayBuyerVO;
	private EximbayReadyTaxVO eximbayTaxVO;
	private EximbayReadyOtherParamVO eximbayOtherParamVO;
	private List<EximbayReadyProductVO> productList;
	//private List<EximbaySurcharge> surchargeList;
	//private ShipToVO shipToVO;
	//private BillToVO billToVO;
	private EximbayReadySettingsVO eximbaySettingsVO;
	
	public EximbayReadyOrderVO(){
		this.fgkey = "";
		this.eximbayPaymentVO = new EximbayReadyPaymentVO();
		this.eximbayMerchantVO = new EximbayReadyMerchantVO();
		this.eximbayUrlVO = new EximbayReadyUrlVO();
		this.eximbayBuyerVO = new EximbayReadyBuyerVO();
		this.eximbayTaxVO = new EximbayReadyTaxVO();
		this.eximbayOtherParamVO = new EximbayReadyOtherParamVO();
		this.eximbaySettingsVO = new EximbayReadySettingsVO();
		this.productList = new ArrayList<EximbayReadyProductVO>();
	}

	public String getFgkey() {
		return fgkey;
	}

	public void setFgkey(String fgkey) {
		this.fgkey = fgkey;
	}

	public List<EximbayReadyProductVO> getProductList() {
		return productList;
	}

	public void setProductList(List<EximbayReadyProductVO> productList) {
		this.productList = productList;
	}

	public EximbayReadyPaymentVO getEximbayPaymentVO() {
		return eximbayPaymentVO;
	}

	public void setEximbayPaymentVO(EximbayReadyPaymentVO eximbayPaymentVO) {
		this.eximbayPaymentVO = eximbayPaymentVO;
	}

	public EximbayReadyMerchantVO getEximbayMerchantVO() {
		return eximbayMerchantVO;
	}

	public void setEximbayMerchantVO(EximbayReadyMerchantVO eximbayMerchantVO) {
		this.eximbayMerchantVO = eximbayMerchantVO;
	}

	public EximbayReadyUrlVO getEximbayUrlVO() {
		return eximbayUrlVO;
	}

	public void setEximbayUrlVO(EximbayReadyUrlVO eximbayUrlVO) {
		this.eximbayUrlVO = eximbayUrlVO;
	}

	public EximbayReadyBuyerVO getEximbayBuyerVO() {
		return eximbayBuyerVO;
	}

	public void setEximbayBuyerVO(EximbayReadyBuyerVO eximbayBuyerVO) {
		this.eximbayBuyerVO = eximbayBuyerVO;
	}

	public EximbayReadyTaxVO getEximbayTaxVO() {
		return eximbayTaxVO;
	}

	public void setEximbayTaxVO(EximbayReadyTaxVO eximbayTaxVO) {
		this.eximbayTaxVO = eximbayTaxVO;
	}

	public EximbayReadyOtherParamVO getEximbayOtherParamVO() {
		return eximbayOtherParamVO;
	}

	public void setEximbayOtherParamVO(EximbayReadyOtherParamVO eximbayOtherParamVO) {
		this.eximbayOtherParamVO = eximbayOtherParamVO;
	}

	public EximbayReadySettingsVO getEximbaySettingsVO() {
		return eximbaySettingsVO;
	}

	public void setEximbaySettingsVO(EximbayReadySettingsVO eximbaySettingsVO) {
		this.eximbaySettingsVO = eximbaySettingsVO;
	}
	
	//private List<EximbaySurcharge> surchargeList;
	//private ShipToVO shipToVO;
	//private BillToVO billToVO;
	public String toString(){
		String str = "";
		str = EximbayService.appendClassVariable(this);
		str = "{\n" + str + "}";
		return str;
	}
}
