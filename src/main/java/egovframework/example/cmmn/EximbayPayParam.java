package egovframework.example.cmmn;

import java.util.Arrays;

public enum EximbayPayParam {
	
	// 결제 준비
	READY_PRODUCT("EximbayReadyProductVO","product"),
	READY_BUYER("EximbayReadyBuyerVO","buyer"),
	READY_MERCHANT("EximbayReadyMerchantVO","merchant"),
	READY_OTHER_PARAM("EximbayReadyOtherParamVO","other_param"),
	READY_PAYMENT("EximbayReadyPaymentVO","payment"),
	READY_SETTINGS("EximbayReadySettingsVO","settings"),
	READY_TAX("EximbayReadyTaxVO","tax"),
	READY_URL("EximbayReadyUrlVO","url"),
	// 결제 취소
	CANCEL_FOREIGN("EximbayCancelForeignVO","foreign"),
	CANCEL_OTHER_PARAM("EximbayCancelOtherParamVO","other_param"),
	CANCEL_PAYMENT("EximbayCancelPaymentVO","payment"),
	CANCEL_REFUND_ACCOUNT("EximbayCancelRefundAccountVO","refund_account"),
	CANCEL_REFUND("EximbayCancelRefundVO","refund"),
	CANCEL_TAX("EximbayCancelTaxVO","tax"),
	
	EMPTY("","");
	
	private String classNm;
	private String keyNm;
	
	EximbayPayParam(String classNm, String keyNm) {
		this.classNm = classNm;
		this.keyNm = keyNm;
	}
	
	public static EximbayPayParam findByPayParam(String classNm){
		return Arrays.stream(EximbayPayParam.values())
				.filter(val ->  val.classNm.equals(classNm))
				.findAny().orElse(EMPTY);
	}

	public String getClassNm() {
		return classNm;
	}

	public String getKeyNm() {
		return keyNm;
	}
}
