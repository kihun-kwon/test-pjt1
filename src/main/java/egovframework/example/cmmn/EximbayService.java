package egovframework.example.cmmn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

public class EximbayService {
	
	private static Map<String,String> verifyChkParam;
	
	private final static String testEximbayPaymentUrl = "https://api-test.eximbay.com/v1/payments";
	private final static String liveEximbayPaymentUrl = "https://api.eximbay.com/v1/payments";
	
	private final static String testEximbayApiKey = "test_1849705C642C217E0B2D:";
	private final static String liveEximbayApiKey = "live_";
	
	private final static String testEximbayMid = "1849705C64";
	private final static String liveEximbayMid = "";
	
	private static Map<String,String> sendToEximbay(EximbayPayStatus eximbayPay, Map<String,String> param){
		BufferedReader in = null;
		try {
			String payUrl = testEximbayPaymentUrl + eximbayPay.getSubUrl();
			if(eximbayPay == EximbayPayStatus.CANCEL || eximbayPay == EximbayPayStatus.CATURE)
				payUrl = testEximbayPaymentUrl + String.format(eximbayPay.getSubUrl(),param.get("transaction_id"));
			
			URL url = new URL(payUrl);
			
			String sendData = String.valueOf(param.get("data"));
			byte[] postDataBytes = sendData.getBytes("UTF-8");
			
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
			conn.setRequestMethod("POST");
			conn.setConnectTimeout(2000);
			conn.setReadTimeout(2000);;
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			
			conn.setRequestProperty("Content-Type","application/json");
			conn.setRequestProperty("Authorization","Basic "+new String(Base64.getEncoder().encode(testEximbayApiKey.getBytes()),"UTF-8"));
			conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
			
			conn.getOutputStream().write(postDataBytes);
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			
			String inputLine;
			StringBuffer response = new StringBuffer();
			
			while((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			System.out.println(response.toString());
			
			ObjectMapper objectMapper = new ObjectMapper();
			TypeReference<Map<String, String>> typeReference = new TypeReference<Map<String,String>>() {};
			Map<String,String> data = objectMapper.readValue(response.toString(), typeReference);
			
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(in != null) in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static String ready(Map<String,String> param){
		verifyChkParam = param;
		Map<String,String> data = sendToEximbay(EximbayPayStatus.READY,param);
		return data.get("fgkey");
		/*
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Authorization", "Basic dGVzdF8xODQ5NzA1QzY0MkMyMTdFMEIyRDo=");

		URI url = URI.create("https://api-test.eximbay.com/v1/payments/ready");

		String body = "{\n" +
					        "\"payment\" : {\n" +
					        "\"transaction_type\" : \"PAYMENT\",\n" +
					        "\"order_id\" : \"20220819105102\",\n" +
					        "\"currency\" : \"USD\",\n" +
					        "\"amount\" : \"1\",\n" +
					        "\"lang\" : \"EN\"\n" +
					        "},\n" +
					        "\"merchant\" : {\n" +
					        "\"mid\" : \"1849705C64\"\n" +
					        "},\n" +
					        "\"buyer\" : {\n" +
					        "\"name\" : \"eximbay\",\n" +
					        "\"email\" : \"test@eximbay.com\"\n" +
					        "},\n" +
					        "\"url\" : {\n" +
					        "\"return_url\" : \"eximbay.com\",\n" +
					        "\"status_url\" : \"eximbay.com\"\n" +
					        " }\n" +
					        "}";
					  "{\"payment\":{
							\"transaction_type\":\"PAYMENT\",
							\"order_id\":\"20220819105102\",
							\"currency\":\"USD\",
							\"amount\":\"1\",
							\"lang\":\"KR\",
							\"payment_method\":\"P101\"},
						  \"tax\":{
						  	\"receipt_status\":\"Y\",
						  	\"amount_tax_free\":\"0.1\",
						  	\"amount_taxable\":\"0.1\",
						  	\"amount_vat\":\"0.1\"},
						  \"product\":[{
						  	\"name\":\"주문1\",
						  	\"quantity\":\"1\",
						  	\"unit_price\":\"0.5\",
						  	\"link\":\"eximbay.com\"}],
						  \"merchant\":{
						  	\"mid\":\"1849705C64\"},
						  \"buyer\":{
						  	\"name\":\"eximbay\",
						  	\"email\":\"test@eximbay.com\"},
						  \"url\":{
						  	\"return_url\":\"eximbay.com\",
						  	\"status_url\":\"eximbay.com\"}}"

		HttpEntity<String> entity = new HttpEntity<>(body, headers);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

		
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String,Object> data = objectMapper.convertValue(response.getBody(), Map.class);
		
		System.out.println(data.get("fgkey"));
		*/
		//System.setProperty( "https.protocols", "TLSv1,TLSv1.1,TLSv1.2" );
		/*
		BufferedReader in = null;
		try {
			//java.lang.System.setProperty("https.protocols", "TLSv1.2");
			//java.lang.System.setProperty("jdk.tls.client.protocols", "TLSv1.2");
			URL url = new URL("https://api-test.eximbay.com/v1/payments/ready");
			
			String sendData = String.valueOf(param.get("data"));
			System.out.println(sendData);
			byte[] postDataBytes = sendData.getBytes("UTF-8");
			
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
			// Set Hostname verification
			conn.setHostnameVerifier(new HostnameVerifier() {
				@Override
				public boolean verify(String hostname, SSLSession session) {
					// Ignore host name verification. It always returns true.
					return true;
				}
			});
			
			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return new X509Certificate[0];
				}

				public void checkClientTrusted(X509Certificate[] certs, String authType){
				}

				public void checkServerTrusted(X509Certificate[] certs, String authType) {
				}
			} };
			SSLContext sc = SSLContext.getInstance("TLSv1.2");
			//sc.init(null, trustAllCerts, new java.security.SecureRandom());
			sc.init(null, null, new java.security.SecureRandom());
			conn.setSSLSocketFactory(sc.getSocketFactory());
			conn.setRequestMethod("POST");
			conn.setConnectTimeout(2000);
			conn.setReadTimeout(2000);;
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			
			conn.setRequestProperty("Content-Type","application/json");
			//TODO Authorization API KEY base64 encoding
			
			System.out.println(new String(Base64.getDecoder().decode("dGVzdF8xODQ5NzA1QzY0MkMyMTdFMEIyRDo=")));
			conn.setRequestProperty("Authorization","Basic dGVzdF8xODQ5NzA1QzY0MkMyMTdFMEIyRDo=");
			conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
			
			conn.getOutputStream().write(postDataBytes);
			SSLContext context = SSLContext.getInstance("TLS");
			context.init(null, null, null); // No validation for now
			conn.setSSLSocketFactory(context.getSocketFactory());
			
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			
			String inputLine;
			StringBuffer response = new StringBuffer();
			
			while((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			System.out.println(response.toString());
			ObjectMapper objectMapper = new ObjectMapper();
			TypeReference<Map<String, Object>> typeReference = new TypeReference<Map<String,Object>>() {};
			Map<String,Object> data = objectMapper.readValue(response.toString(), typeReference);
			//System.out.println(data.get("fgkey"));
			return (String)data.get("fgkey");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(in != null) in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
		*/
	}
	
	public static boolean callEximbayStatus(Map<String,String> param){
		
		boolean retVal = false;
		
		if (param != null && !param.isEmpty()) {
			// 수신 결과값이 성공인 경우
			if("0000".equals(param.get("rescode"))){
				//&resmsg=Success.&rescode=0000
				//상점ID 비교 //상점ID &mid=1849705C64
				if(!testEximbayMid.equals(param.get("mid"))) return false;
				
				//TODO 주문번호로 주문정보 조회
				Map<String,String> orderInfo = new HashMap<String,String>();
				/*샘플데이터*/
				orderInfo.put("order_id","20220927152140");
				orderInfo.put("transaction_id","1849705C6420220927000016");
				orderInfo.put("currency","USD");
				orderInfo.put("amount","100");
				orderInfo.put("payment_method","P101");
				orderInfo.put("transaction_type","PAYMENT");
				
				if (orderInfo == null || orderInfo.isEmpty()) return false;
				//주문번호 확인 &order_id=20220927152140
				//if(!orderInfo.get("order_id").equals(param.get("order_id"))) return false;
				//주문 통화 확인 &currency=USD
				if(!orderInfo.get("currency").equals(param.get("currency"))) return false;
				//주문 금액 확인 &amount=100
				if(!orderInfo.get("amount").equals(param.get("amount"))) return false;
				//결제수단 코드 확인 &payment_method=P101
				if(!orderInfo.get("payment_method").equals(param.get("payment_method"))) return false;
				//국내 or 해외 결제
				EximbayPayType payType = EximbayPayType.findByPayType(orderInfo.get("payment_method"));
				EximbayPayment eximBayPayment = EximbayPayment.findByPayment(payType);
				//국내 결제인 경우
				if (eximBayPayment == EximbayPayment.LOCALPAY) {
					//네이버 포인트 & 가상계좌
					if (payType == EximbayPayType.NAVERPAY_POINT || payType == EximbayPayType.VER_ACCOUNT){
						
					} else {
						
					}
				} else if (eximBayPayment == EximbayPayment.GLOBALPAY){
					
				} else {
					return false;
				}
				
				//결제 방식 확인 &transaction_type=PAYMENT
				if(!orderInfo.get("transaction_type").equals(param.get("transaction_type"))) return false;
				
				//TODO 트랜잭션 ID 저장 => 중복인증 또는 승인 방지
				//인증 요청마다 새롭게 발급되어 수신 &transaction_id=1849705C6420220927000016
				//트랜잭션 ID가 동일한 경우 중복처리로 간주
				if(orderInfo.get("transaction_id").equals(param.get("transaction_id"))) return false;
				
				//TODO 기타 파라미터 인증 필요한지 확인 필요
				//&card_number1=4111
				//&card_number4=1111
				//&card_holder=TESTP
				//&access_country=KR
				//&email=test@eximbay.com
				//&ver=230
				//&param3=TEST
				//&auth_code=309812
				//&fgkey=2AE38D785E05E6AF57977328908C7CD84A273B3FE6C042D537A800B0CBC783EA
				//&pay_to=EXIMBAY.COM
			}
			retVal = true;
		}
		return retVal;
	}
	
	public static boolean verify(HttpServletRequest req, HttpServletResponse res){
		Map<String,String> param = new HashMap<String,String>();
		param.put("data", req.getQueryString());
		//결제 데이터 인증
		Map<String,String> data = sendToEximbay(EximbayPayStatus.VERIFY, param);
		if ("0000".equals(data.get("rescode"))){
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean cancel(Map<String,String> param){
		//결제 데이터 취소
		Map<String,String> data = sendToEximbay(EximbayPayStatus.CANCEL, param);
		if ("0000".equals(data.get("rescode"))){
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args){
		System.out.println(EximbayService.ready(new HashMap()));
	}
}
