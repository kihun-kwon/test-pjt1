package egovframework.example.cmmn;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum EximbayPayment {
	
	LOCALPAY("국내결제수단",Arrays.asList(EximbayPayType.KAKAOPAY,EximbayPayType.NAVERPAY_POINT,EximbayPayType.NAVERPAY_CARD,EximbayPayType.NAVERPAY_CARDPOINT,EximbayPayType.VER_ACCOUNT,EximbayPayType.TOSS,EximbayPayType.SMAILPAY,EximbayPayType.PAYCO)),
	GLOBALPAY("해외결제수단",Arrays.asList(EximbayPayType.VISA,EximbayPayType.MASTER,EximbayPayType.AMEX,EximbayPayType.JCB)),
	EMPTY("값없음",Collections.EMPTY_LIST);

	private String title;
	private List<EximbayPayType> list;
	
	EximbayPayment(String title, List<EximbayPayType> list){
		this.title = title;
		this.list = list;
	}
	
	public static EximbayPayment findByPayment(EximbayPayType payType){
		return Arrays.stream(EximbayPayment.values())
				.filter(payment -> payment.hasPaymentCode(payType))
				.findAny().orElse(EMPTY);
	}
	
	public boolean hasPaymentCode(EximbayPayType payType){
		return list.stream().anyMatch(pay -> pay == payType);
	}
	
	public String getTitle(){
		return this.title;
	}
}
