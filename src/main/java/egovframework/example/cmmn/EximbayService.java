package egovframework.example.cmmn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.example.sample.service.eximbay.EximbayCommReturnVO;
import egovframework.example.sample.service.eximbay.EximbayCommVO;
import egovframework.example.sample.service.eximbay.cancel.EximbayCancelOrderVO;
import egovframework.example.sample.service.eximbay.cancel.EximbayCancelReturnVO;
import egovframework.example.sample.service.eximbay.ready.EximbayReadyOrderVO;
import egovframework.example.sample.service.eximbay.ready.EximbayReadyReturnVO;

public class EximbayService {
	
	private final static String testEximbayPaymentUrl = "https://api-test.eximbay.com/v1/payments";
	private final static String liveEximbayPaymentUrl = "https://api.eximbay.com/v1/payments";
	
	private final static String testEximbayApiKey = "test_1849705C642C217E0B2D:";
	private final static String liveEximbayApiKey = "live_";
	
	private final static String testEximbayMid = "1849705C64";
	private final static String liveEximbayMid = "";
	
	private static EximbayCommReturnVO sendToEximbay(EximbayPayStatus payStatus,String sendUrl, String sendData) throws Exception{
		BufferedReader in = null;
		try {
			URL url = new URL(sendUrl);
			byte[] postDataBytes = sendData.getBytes("UTF-8");
			
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
			conn.setRequestMethod("POST");
			conn.setConnectTimeout(2000);
			conn.setReadTimeout(2000);
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
			if (payStatus == EximbayPayStatus.CANCEL){
				TypeReference<EximbayCancelReturnVO> typeReference = new TypeReference<EximbayCancelReturnVO>() {};
				EximbayCancelReturnVO data = objectMapper.readValue(response.toString(), typeReference);
				return data;
			} else {
				TypeReference<EximbayReadyReturnVO> typeReference = new TypeReference<EximbayReadyReturnVO>() {};
				EximbayReadyReturnVO data = objectMapper.readValue(response.toString(), typeReference);
				return data;
			}
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
	
	public static EximbayCommReturnVO ready(EximbayReadyOrderVO vo) throws Exception{
		
		String callUrl = testEximbayPaymentUrl + EximbayPayStatus.READY.getSubUrl();
		String sendData = vo.toString();
		System.out.println(sendData);
		return sendToEximbay(EximbayPayStatus.READY,callUrl,sendData);
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
	
	/**
	 * Eximbay 승인 결과 검증
	 * @param req
	 * @return
	 */
	public static EximbayCommReturnVO verify(HttpServletRequest req) throws Exception{
		String callUrl = testEximbayPaymentUrl + EximbayPayStatus.VERIFY.getSubUrl();
		String sendData = "{\"data\":\""+req.getQueryString()+"\"}";
		//결제 데이터 인증
		return sendToEximbay(EximbayPayStatus.VERIFY,callUrl, sendData);
	}
	
	/**
	 * Eximbay 결제승인 취소
	 * @param transactionId
	 * @param cancelOrder
	 * @return
	 */
	public static EximbayCommReturnVO cancel(String transactionId, EximbayCancelOrderVO cancelOrder) throws Exception{
		String callUrl = testEximbayPaymentUrl + String.format(EximbayPayStatus.CANCEL.getSubUrl(),transactionId);
		//상점 아이디 
		cancelOrder.setMid(testEximbayMid);
		String sendData = cancelOrder.toString();
		return sendToEximbay(EximbayPayStatus.CANCEL,callUrl, sendData);
	}
	
	/**
	 * Eximbay VO 클래스에 포함된 변수로 전송 전문 생성
	 * 변수의 값이 없으면 제외   
	 * @param obj
	 * @return
	 */
	public static String appendClassVariable(Object obj) throws Exception{
		
		String str = "";
		Field[] fields = obj.getClass().getDeclaredFields();
        AccessibleObject.setAccessible(fields, true);
        for (Field field : fields) {
        	//field.setAccessible(true);
        	String fieldName = field.getName();
        	if (appendExcVariable(fieldName)) continue;
            try {
                Object fieldValue = field.get(obj);
                if(fieldValue instanceof EximbayCommVO){
					str = declaredMethodInvoke(str,fieldValue);
                } else if (fieldValue instanceof ArrayList){
                	str += arrayListToString(str,(ArrayList<?>)fieldValue);
                } else {
                	str = appendParam(str,fieldName, String.valueOf(fieldValue));
                }
            } catch (IllegalAccessException ex) {
                throw new InternalError("Unexpected IllegalAccessException: " + ex.getMessage());
            } catch (Exception e) {
				// TODO: handle exception
			}
        }
		return str;
	}
	
	/**
	 * Eximbay VO 클래스에 선언된 변수 중 ArrayList 전송 전문 생성
	 * @param listObj
	 * @return
	 * @throws Exception
	 */
	private static String arrayListToString(String str, List<?> list) throws Exception{
		EximbayPayParam eximbayPayParam = checkClassPayParam(list);
		if (eximbayPayParam == EximbayPayParam.EMPTY) return "";
		String appendStr = "";
		for (Object obj : list) {
			appendStr = declaredMethodInvoke(appendStr,obj);
		}
		return appendSeparator(str) + "\""+eximbayPayParam.getKeyNm()+"\":[\n" + appendStr + "]\n";
	}
	/**
	 * list내에 pay vo가 있는지 확인
	 * @param list
	 * @return
	 */
	private static EximbayPayParam checkClassPayParam(List<?> list) throws Exception{
		Optional<?> op = list.stream()
				.filter(item -> EximbayPayParam.findByPayParam(item.getClass().getSimpleName()) != EximbayPayParam.EMPTY)
				.findFirst();
		return EximbayPayParam.findByPayParam(op.orElseThrow(() -> new RuntimeException()).getClass().getSimpleName());
	}
	
	/**
	 * VO 클래스에  선언된 toString method를 실행하여 전송 전문 생성 
	 * @param str
	 * @param obj
	 * @return VO 클래스에 해당하는 전송 전문 
	 */
	private static String declaredMethodInvoke(String str, Object obj) throws Exception{
		try {
			Method myMethod = obj.getClass().getDeclaredMethod("toString",new Class[]{});
			String retVal = String.valueOf(myMethod.invoke(obj));
			if(!"".equals(retVal)) str += appendSeparator(str) + retVal;
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException();
		}
		return str;
	}
	
	public static String appendSeparator(String str) throws Exception{
		return !"".equals(str)?",":"";
	}
	
	public static String appendParam(String str, String key, String val) throws Exception{
		
		if (!"".equals(val)) str += appendSeparator(str) + "\""+ key +"\":\"" + val + "\"\n";
		
		return str;
	}
	
	/**
	 * Eximbay VO 클래스 변수 중 전문에서 제외할 대상 지정
	 * @param fieldName
	 * @return
	 */
	public static boolean appendExcVariable(String fieldName) throws Exception{
		List<String> exVal =  Arrays.asList("product_id");
		return exVal.stream().anyMatch(val -> val.equals(fieldName));
		
		//return " product_id ".indexOf(fieldName) > -1 ? true:false;
	}
	
	/**
	 * Eximbay VO 클래스 변수값이 모두 비어있는지 확인
	 * @param obj
	 * @return
	 */
	public static boolean isClassVariableEmpty(Object obj) throws Exception{
		
		Field[] fields = obj.getClass().getDeclaredFields();
        AccessibleObject.setAccessible(fields, true);
        for (Field field : fields) {
        	String fieldName = field.getName();
        	if (appendExcVariable(fieldName)) continue;
            try {
                Object fieldValue = field.get(obj);
                
                if(fieldValue != null && !"".equals(String.valueOf(fieldValue))) return false; 
                
            } catch (IllegalAccessException ex) {
                throw new InternalError("Unexpected IllegalAccessException: " + ex.getMessage());
            }
        }
		return true;
	}

}
