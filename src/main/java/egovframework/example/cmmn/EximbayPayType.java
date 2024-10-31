package egovframework.example.cmmn;

import java.util.Arrays;

public enum EximbayPayType {
	
	KAKAOPAY("P302"),
	TOSS("P303"),
	PAYCO("P304"),
	SMAILPAY("P306"),
	NAVERPAY_POINT("P308"),
	NAVERPAY_CARD("P307"),
	NAVERPAY_CARDPOINT("P015"),
	VER_ACCOUNT("P305"),
	
	VISA("P101"),
	MASTER("P102"),
	AMEX("P103"),
	JCB("P104");;
	
	private String title;
	
	EximbayPayType(String title) { this.title = title;}
	
	public static EximbayPayType findByPayType(String code){
		return Arrays.stream(EximbayPayType.values())
				.filter(val -> val.title.equals(code))
				.findAny().orElse(null);
	}
	
	public String getTitle(){
		return title;
	}
}
