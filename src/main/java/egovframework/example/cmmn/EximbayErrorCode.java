package egovframework.example.cmmn;

import java.util.Arrays;

public enum EximbayErrorCode {
	
	EXPIRED_CARD("EXPIRED_CARD","The card has expired. Please check the card exipration date is correct or expired.","입력하신 카드번호가 올바르지 않습니다. 카드번호를 다시 확인해주세요.","카드 유효기간을 확인해주세요. 만료된 카드라면 다른 카드를 사용해주세요."),
	INVALID_CARD_NUMBER("INVALID_CARD_NUMBER","The card number is incorrect. Please check the card number.","입력하신 카드번호가 올바르지 않습니다. 카드번호를 다시 확인해주세요.","올바른 카드 번호를 입력해주세요."),
	INVAILD_CARD_DATA("INVAILD_CARD_DATA","Some of the card data was invalid (CVV, expiration date, card number, name on card, card password)","일부 카드 정보가 올바르지 않습니다(CVV, 유효기간, 카드번호, 카드 명의자, 비밀번호).","입력한 카드 정보가 올바른지 확인해주세요."),
	INVALID_CVC("INVALID_CVC","The CVC(CVV) number is incorrect. Please try again using the correct CVC(CVV).","카드 CVC 번호가 올바르지 않습니다. CVC 번호를 확인해주세요.","카드 cvc 번호를 올바르게 입력해주세요."),
	INVALID_PASSWORD("INVALID_PASSWORD","The card password is incorrect or has been incorrect several times. Please try again with the correct password.","입력하신 카드 비밀번호가 올바르지 않거나 입력 가능 횟수를 초과했습니다. 비밀번호를 확인해주시거나 잠시 후 다시 시도해주세요.","올바른 카드 비밀번호를 입력해주세요. 입력 가능 횟수를 초과한 경우 카드사에 문의해주세요."),
	PASSWORD_REQUIRED("PASSWORD_REQUIRED","The card was declined as it requires a password(PIN).","카드 비밀번호가 필요해 결제에 실패했습니다. 카드 비밀번호를 입력해주세요.","카드 비밀번호를 입력해주세요."),
	INVALID_AUTHENTICATION("INVALID_AUTHENTICATION","The payment was declined because authentication failed or was required.","인증이 실패했거나, 필요해 결제에 실패했습니다.","인증 결제가 가능한 카드인지 확인 후 올바른 방법으로 인증해주세요."),
	INVALID_CAVV("INVALID_CAVV","The payment was declined because CAVV is incorrect.","CAVV 정보가 유효하지 않아 결제에 실패했습니다.","올바른 CAVV 정보를 입력해주세요."),
	FRAUDULENT_DECLINE("FRAUDULENT_DECLINE","The payment was declined because the transaction was suspected to be fraudulent.","위험거래로 의심되어 결제가 거절되었습니다.",""),
	STOLEN_OR_LOST_CARD("STOLEN_OR_LOST_CARD","The card was reported lost or stolen. Please try check the card.","도난 또는 분실 신고된 카드입니다.","결제에 사용한 카드사로 연락해 확인해주세요."),
	CONTACT_CARD_ISSUER("CONTACT_CARD_ISSUER","The card was declined for an unknown reason. Please contact card issuer for more information.","카드 발급사에서 승인이 거절되었습니다. 카드 발급사에 연락해 사유를 확인해주세요.","결제에 사용한 카드사로 연락해 확인해주세요."),
	CARD_NOT_SUPPORTED("CARD_NOT_SUPPORTED","The card does not support this type of payment. Please try again using other card.","해당 결제에서 지원하지 않는 카드입니다.","사용 가능한 카드사의 카드를 사용해주세요."),
	RESTRICTED_CARD("RESTRICTED_CARD","You can't use this card to make this payment. Please contact card issuer for more information.","사용하신 카드를 사용하실 수 없습니다. 카드 발급사에 확인해주세요.","결제에 사용한 카드사로 연락해 확인해주세요."),
	NOT_REGISTERED_CARD("NOT_REGISTERED_CARD","The card does not register, please register your card before using it.","등록되지 않은 카드입니다. 카드 등록 후 사용해주세요.","발급받은 카드를 카드사에 등록 후 사용해주세요."),
	CARD_PAYMENT_COUNT_EXCEEDED("CARD_PAYMENT_COUNT_EXCEEDED","You have exceeded the maximum number(daily/monthly/annually) of payments.","최대 결제 횟수(일/월/연)을 초과했습니다.","카드에 설정되어 있는 최대 결제 횟수를 초과했습니다. 설정된 제한 횟수는 카드사에 확인해주세요."),
	CARD_VELOCITY_EXCEEDED("CARD_VELOCITY_EXCEEDED","You have exceeded the balance, credit limit, or transaction amount limit available on their card.","카드 잔액, 사용한도 또는 허용 거래 금액을 초과했습니다.","잔액 또는 사용한 카드의 한도가 충분한지 확인해주세요."),
	INSUFFICIENT_FUNDS("INSUFFICIENT_FUNDS","The card has insufficient funds to complete the purchase.","잔액이 부족해 결제에 실패했습니다.","사용하신 카드의 잔액이 충분한지 확인해주세요."),
	INVALID_CARD_IDENTITY("INVALID_CARD_IDENTITY","Some of the identity information was invalid(resident registration number, business number).","입력하신 주민번호/사업자번호가 올바르지 않습니다. 카드 소유자의 정보를 사용해주세요.",""),
	KEYIN_NOT_SUPPORTED("KEYIN_NOT_SUPPORTED","The mercahnt has not allowed KEYIN transaction.","키인 결제를 사용할 수 없습니다.",""),
	INVALID_CARD_INSTALLMENT_PLAN("INVALID_CARD_INSTALLMENT_PLAN","The installment months are invalid or exceeded.","할부개월 정보가 잘못되었습니다.",""),
	NOT_SUPPORT_INSTALLMENT_PLAN("NOT_SUPPORT_INSTALLMENT_PLAN","The card does not support installment plan.","할부를 지원하지 않는 거래입니다.",""),
	NOT_SUPPORT_DISCOUNT("NOT_SUPPORT_DISCOUNT","The card does not support discount.","할인을 지원하지 않는 거래입니다.",""),
	INVALID_CARD_INSTALLMENT_AMOUNT("INVALID_CARD_INSTALLMENT_AMOUNT","The installment amount is incorrect. Card installment plan is supported over 50,000won transaction.","5만원 이하는 할부 결제를 할 수 없습니다.",""),
	POINTS_NOT_SUPPORTED("POINTS_NOT_SUPPORTED","The points cannot be used this transaction. Please try again or contact card issuer.","포인트 사용 및 적립이 불가능한 거래입니다.",""),
	INVALID_MERCHANT_NUMBER("INVALID_MERCHANT_NUMBER","The merchant number is invalid. Please check merchant number is correct.","가맹점 번호가 올바르지 않습니다. 올바른 가맹점 번호를 사용했는 지 확인해주세요.","엑심베이 고객센터로 문의해주세요."),
	INVALID_SUBMALL_NUMBER("INVALID_SUBMALL_NUMBER","The submall merchant number is invalid. Please check merchant number is correct.","서브몰 사업자 번호가 올바르지 않습니다.","엑심베이 고객센터로 문의해주세요."),
	CHECK_MERCHANT_STATUS("CHECK_MERCHANT_STATUS","The merchant status is a suspended. Please check merchant status.","거래가 제한된 가맹점으로 결제가 실패했습니다. 가맹점 상태를 확인해주세요.","가맹점의 mid 상태가 정상인 mid를 사용해주세요."),
	INSUFFICIENT_MERCHANT_FUNDS("INSUFFICIENT_MERCHANT_FUNDS","The merchant has insufficient funds to complete the purchase.","가맹점 한도가 초과해 결제에 실패했습니다.","엑심베이 고객센터로 문의해주세요."),
	INSUFFICIENT_MERCHANT_REFUND_FUNDS("INSUFFICIENT_MERCHANT_REFUND_FUNDS","The merchant has insufficient funds to complete the refund.","가맹점 한도가 초과해 취소에 실패했습니다.","엑심베이 고객센터로 문의해주세요."),
	INVALID_CANCEL_REQUEST("INVALID_CANCEL_REQUEST","The cancel request was invalid. Please check the orginal transaction status and try again.","취소가 실패했습니다. 취소 요청 및 원거래 상태가 유효한지와 취소가 가능한 거래인지 확인해주세요.","취소하려는 원거래의 상태 및 정보가 정확한지 확인해주세요."),
	TRANSACTION_ALREADY_CANCELED("TRANSACTION_ALREADY_CANCELED","The transaction was already canceled.","이미 취소된 거래입니다.","거래 상태를 확인해주세요."),
	TRANSACTION_ALREADY_CAPTURED("TRANSACTION_ALREADY_CAPTURED","The transaction was already captured.","이미 매입된 거래입니다.",""),
	TRANSACTION_ALREADY_CAPTURED_OR_CANCELED("TRANSACTION_ALREADY_CAPTURED_OR_CANCELED","The transaction was already captured or canceled.","이미 취소 또는 매입 요청된 거래입니다.",""),
	ALREADY_VOID_CAPTURED_TRANSACTION("ALREADY_VOID_CAPTURED_TRANSACTION","The captured transaction was already void.","이미 무효화된 캡쳐 거래입니다.",""),
	INVALID_CERTIFICATE("INVALID_CERTIFICATE","Your certificate has expired or invalid. Please check your certificate and try agian.","사용하신 공인인증서가 만료되었거나 유효하지 않습니다.",""),
	INVALID_OR_MISSING_FIELD("INVALID_OR_MISSING_FIELD","The request is missing one or more fields or contain invalid data.","요청파라미터 중 유효하지 않는 값이 있거나 누락된 파라미터가 있습니다.","연동문서 내 필수파라미터 정보와 중복이 불가능한 정보를 확인해주세요."),
	DUPLICATE_TRANSACTION("DUPLICATE_TRANSACTION","The transaction was decline as duplicate.","중복 결제 요청으로 결제에 실패했습니다.",""),
	CURRENCY_NOT_SUPPORTED("CURRENCY_NOT_SUPPORTED","The transaction does not support the currency used.","해당 통화를 사용할 수 없는 거래입니다.","사용할 수 있는 통화 정보를 확인해주세요."),
	GENERIC_DECLINE("GENERIC_DECLINE","The transaction was failed an unknown reason. Please try again later or contact card issuer for more information.","결제에 실패했습니다. 잠시 후 다시 시도해주시거나 카드 발급사에 확인해주세요.",""),
	ORIGINAL_TRANSACTION_NOT_EXIST("ORIGINAL_TRANSACTION_NOT_EXIST","The original transaction was not exisited.","원거래가 존재하지 않습니다.","원거래 정보를 다시 확인해주세요."),
	INVALID_REQEUST_AMOUNT("INVALID_REQEUST_AMOUNT","Requested amount conflicts with the minimum or maximum amount allowed.","요청 최소/최대 금액을 초과했거나, 올바르지 않은 요청 금액입니다.",""),
	TEMPORARY_ERROR("TEMPORARY_ERROR","There is a temporary error in the system. Please try again later.","시스템에 일시적인 오류가 발생했습니다. 잠시 후 다시 시도해주세요.",""),
	INVALID_MERCHANT("INVALID_MERCHANT","Information in your merchant is incorrect.","가맹점 정보가 올바르지 않습니다.",""),
	INVALID_ACCOUNT("INVALID_ACCOUNT","Information in your account is incorrect or not supported.","계정 정보가 올바르지 않거나 해당 서비스를 지원하지 않습니다.",""),
	NOT_REGISTERED_MERCHANT("NOT_REGISTERED_MERCHANT","The merchant does not register, please register merchant before payment.","미등록 가맹점입니다. 결제 진행 전 가맹점이 정상적으로 등록되었는 지 확인해주세요.",""),
	INVALID_REQEUST_ID("INVALID_REQEUST_ID","The request ID is invalid. Please check the request ID before reqeusting payment.","Reqeust ID가 유효하지 않습니다.",""),
	INVALID_ADDRESS("INVALID_ADDRESS","The address you entered is invalid, please enter the correct address.","입력한 주소가 올바르지 않습니다. 올바른 주소를 입력해주세요.",""),
	ACQUIRER_DECLINE("ACQUIRER_DECLINE","The transaction was declined because of acquirer.","매입사 거절로 결제가 실패했습니다.",""),
	VALIDATION_FAILED("VALIDATION_FAILED","The transaction failed due to a valiation failure.","결제 처리 중 검증에 실패해 거절되었습니다.",""),
	DUPLICATION_DECLINE("DUPLICATION_DECLINE","The transaction was decline because a specific field was requested as duplicated. Please make sure that duplicate values are not requested.","특정 필드에 중복값이 요청되었습니다. 중복이 허용되지 않는 필드를 확인해주세요.",""),
	INVALID_CAPTURE_REQUEST("INVALID_CAPTURE_REQUEST","The requested capture was invalid. Check amount exceeds the authorized amount or orginal transaction.","캡쳐 요청이 유효하지 않습니다. 요청한 원승인 거래의 금액 또는 거래 정보가 올바른지 확인해주세요.",""),
	ALREADY_ACTIVE_PREPAID_CARD("ALREADY_ACTIVE_PREPAID_CARD","Gift card account or prepaid card account is already active.","사용한 키프트카드 또는 선불카드가 이미 활성화되었습니다.","");

	private String errCode;
	private String enMsg;
	private String koMsg;
	private String msg;
	
	EximbayErrorCode(String errCode, String enMsg, String koMsg, String msg) { 
		this.errCode = errCode;
		this.enMsg = enMsg;
		this.koMsg = koMsg;
		this.msg = msg;
	}
	
	public static EximbayErrorCode findByPayType(String code){
		return Arrays.stream(EximbayErrorCode.values())
				.filter(val -> val.errCode.equals(code))
				.findAny().orElse(null);
	}

	public String getErrCode() {
		return errCode;
	}

	public String getEnMsg() {
		return enMsg;
	}

	public String getKoMsg() {
		return koMsg;
	}

	public String getMsg() {
		return msg;
	}
}
