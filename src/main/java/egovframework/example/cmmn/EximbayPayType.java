package egovframework.example.cmmn;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum EximbayPayType {
	
	KAKAOPAY("P302","ko"),
	TOSS("P303","ko"),
	PAYCO("P304","ko"),
	SMAILPAY("P306","ko"),
	NAVERPAY_POINT("P308","ko"),
	NAVERPAY_CARD("P307","ko"),
	NAVERPAY_CARDPOINT("P015","ko"),
	VER_ACCOUNT("P305","ko"),
	
	VISA("P101","en"),
	MASTER("P102","en"),
	AMEX("P103","en"),
	JCB("P104","en");
	
	private String title;
	private String lang;
	
	EximbayPayType(String title, String lang) { 
		this.title = title;
		this.lang = lang;
	}
	
	public static EximbayPayType findByPayType(String code){
		return Arrays.stream(EximbayPayType.values())
				.filter(val -> val.title.equals(code))
				.findAny().orElse(null);
	}
	
	public static List<EximbayPayType> findByAllPayType(String lang){
		return Arrays.stream(EximbayPayType.values())
				.filter(val -> val.lang.equals(lang))
				.collect(Collectors.toList());
	}
	
	public String getTitle(){
		return title;
	}
}
