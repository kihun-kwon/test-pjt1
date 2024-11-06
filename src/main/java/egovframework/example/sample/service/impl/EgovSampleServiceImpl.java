/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package egovframework.example.sample.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import egovframework.example.cmmn.EximbayPayTypeGroup;
import egovframework.example.cmmn.EximbayService;
import egovframework.example.cmmn.EximbayErrorCode;
import egovframework.example.cmmn.EximbayPayType;
import egovframework.example.sample.service.EgovSampleService;
import egovframework.example.sample.service.SampleDefaultVO;
import egovframework.example.sample.service.SampleVO;
import egovframework.example.sample.service.eximbay.EximbayCommReturnVO;
import egovframework.example.sample.service.eximbay.cancel.EximbayCancelOrderVO;
import egovframework.example.sample.service.eximbay.cancel.EximbayCancelReturnVO;
import egovframework.example.sample.service.eximbay.ready.EximbayReadyOrderVO;
import egovframework.example.sample.service.eximbay.ready.EximbayReadyPaymentVO;
import egovframework.example.sample.service.eximbay.ready.EximbayReadyProductVO;
import egovframework.example.sample.service.eximbay.ready.EximbayReadyReturnVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Class Name : EgovSampleServiceImpl.java
 * @Description : Sample Business Implement Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Service("sampleService")
public class EgovSampleServiceImpl extends EgovAbstractServiceImpl implements EgovSampleService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EgovSampleServiceImpl.class);

	/** SampleDAO */
	// TODO ibatis 사용
	@Resource(name = "sampleDAO")
	private SampleDAO sampleDAO;
	// TODO mybatis 사용
	//  @Resource(name="sampleMapper")
	//	private SampleMapper sampleDAO;

	/** ID Generation */
	@Resource(name = "egovIdGnrService")
	private EgovIdGnrService egovIdGnrService;

	/**
	 * 글을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SampleVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	@Override
	public String insertSample(SampleVO vo) throws Exception {
		LOGGER.debug(vo.toString());

		/** ID Generation Service */
		String id = egovIdGnrService.getNextStringId();
		vo.setId(id);
		LOGGER.debug(vo.toString());

		sampleDAO.insertSample(vo);
		return id;
	}

	/**
	 * 글을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SampleVO
	 * @return void형
	 * @exception Exception
	 */
	@Override
	public void updateSample(SampleVO vo) throws Exception {
		sampleDAO.updateSample(vo);
	}

	/**
	 * 글을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SampleVO
	 * @return void형
	 * @exception Exception
	 */
	@Override
	public void deleteSample(SampleVO vo) throws Exception {
		sampleDAO.deleteSample(vo);
	}

	/**
	 * 글을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SampleVO
	 * @return 조회한 글
	 * @exception Exception
	 */
	@Override
	public SampleVO selectSample(SampleVO vo) throws Exception {
		SampleVO resultVO = sampleDAO.selectSample(vo);
		if (resultVO == null)
			throw processException("info.nodata.msg");
		return resultVO;
	}

	/**
	 * 글 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 글 목록
	 * @exception Exception
	 */
	@Override
	public List<?> selectSampleList(SampleDefaultVO searchVO) throws Exception {
		return sampleDAO.selectSampleList(searchVO);
	}

	/**
	 * 글 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 글 총 갯수
	 * @exception
	 */
	@Override
	public int selectSampleListTotCnt(SampleDefaultVO searchVO) {
		return sampleDAO.selectSampleListTotCnt(searchVO);
	}
	
	@Override
	public String getFgKey(EximbayReadyOrderVO eximbayReadyOrderVO, HttpServletRequest req, HttpServletResponse res){
		
		//EximbayReadyOrderVO eximbayReadyOrderVO = null;
		try {
			
			if (eximbayReadyOrderVO == null)
				throw new RuntimeException();
			
			if (eximbayReadyOrderVO.getProductList() == null || eximbayReadyOrderVO.getProductList().size() == 0)
				throw new RuntimeException();
			
			//payment Method가 지정된 경우
			EximbayPayType eximbayPayType = null;
			EximbayPayTypeGroup eximbayPayment;
			if (eximbayReadyOrderVO.getEximbayPaymentVO() != null) {
				// 결제 모듈 단일 수단 선택인 경우
				if (!"".equals(eximbayReadyOrderVO.getEximbayPaymentVO().getPayment_method())) {
					eximbayPayType = EximbayPayType.findByPayType(eximbayReadyOrderVO.getEximbayPaymentVO().getPayment_method());
				} 
				// 결제 모듈 복수 수단 선택일 경우
				else if (!"".equals(eximbayReadyOrderVO.getEximbayPaymentVO().getMulti_payment_method())){
					String multiMethod = eximbayReadyOrderVO.getEximbayPaymentVO().getMulti_payment_method();
					String[] arrMultiMethod = multiMethod.split("-");
					eximbayPayType = EximbayPayType.findByPayType(arrMultiMethod[0]);
				}
			} 
			// 결제 모듈 선택하지 않은 경우 
			if (eximbayPayType == null){
				// 현제 언어셋 확인 후 Multi payment method 값 지정
				// TODO 언어셋 확인
				String currentLang = "ko";
				StringBuffer sb = new StringBuffer();
				List<EximbayPayType> eximbayPayTypes = EximbayPayType.findByAllPayType(currentLang);
				for (EximbayPayType payType : eximbayPayTypes){
					if ("".equals(sb.toString())) {
						// 기본 타입 지정
						eximbayPayType = EximbayPayType.findByPayType(payType.getTitle());
						sb.append(payType.getTitle());
					}
					else 
						sb.append("-"+payType.getTitle());
				}
				// multi payment method 셋팅
				if (eximbayReadyOrderVO.getEximbayPaymentVO() == null) {
					EximbayReadyPaymentVO eximbayReadyPaymentVO = new EximbayReadyPaymentVO();
					eximbayReadyPaymentVO.setMulti_payment_method(sb.toString());
					eximbayReadyOrderVO.setEximbayPaymentVO(eximbayReadyPaymentVO);
				} else {
					eximbayReadyOrderVO.getEximbayPaymentVO().setMulti_payment_method(sb.toString());
				}
			}
			
			// 결제모듈 type에 따라 국내/해외 결제인지 확인
			eximbayPayment = EximbayPayTypeGroup.findByPayment(eximbayPayType);
			
			String orderId = "";
			
			/**
			 * transaction_type 
			 * PAYMENT: 인증, 승인, 매입  
			 * PAYER_AUTH: 인증
			 * AUTHORIZE: 인증, 승인
			 **/
			// 공통
			//TODO 가맹점 아이디 확인 후 셋팅
			eximbayReadyOrderVO.getEximbayMerchantVO().setMid("1849705C64");
			//TODO 구매자 개인정보 셋팅
			eximbayReadyOrderVO.getEximbayBuyerVO().setName("eximbay");
			eximbayReadyOrderVO.getEximbayBuyerVO().setEmail("test@eximbay.com");
			//TODO 활용여부 체크 필요
			//surcharge, ship_to, bill_to
			System.out.println("eximbayPayment ::: "+eximbayPayment);
			// 해외카드 결제인 경우
			if (eximbayPayment == EximbayPayTypeGroup.GLOBALPAY) {
				orderId = "G0000000";
				//TODO 주문번호 채번 로직 확인
				eximbayReadyOrderVO.getEximbayPaymentVO().setOrder_id(orderId);
				//TODO 결제 처리 방식 지정 AUTHORIZE: 인증, 승인
				eximbayReadyOrderVO.getEximbayPaymentVO().setTransaction_type("AUTHORIZE");
				
				eximbayReadyOrderVO.getEximbayPaymentVO().setCurrency("USD");
				//TODO 상품정보 조회 후 금액 계산
				eximbayReadyOrderVO.getEximbayPaymentVO().setAmount("10000");
				eximbayReadyOrderVO.getEximbayPaymentVO().setLang("EN");
				//TODO 결제 완료 페이지
				eximbayReadyOrderVO.getEximbayUrlVO().setReturn_url("eximbay.com");
				//TODO 결제 검증 수신 페이지
				eximbayReadyOrderVO.getEximbayUrlVO().setStatus_url("eximbay.com");
				
				//TODO 예비 파라미터 정보 셋팅 
				//param.getEximbayOtherParamVO().setParam1("");
				//param.getEximbayOtherParamVO().setParam2("");
			} 
			// 국내 간편결제인 경우
			else if (eximbayPayment == EximbayPayTypeGroup.LOCALPAY) {
				orderId = "E0000000";
				//TODO 주문번호 채번 로직 확인
				eximbayReadyOrderVO.getEximbayPaymentVO().setOrder_id(orderId);
				
				//결제 처리 방식 지정 PAYMENT: 인증, 승인, 매입  
				eximbayReadyOrderVO.getEximbayPaymentVO().setTransaction_type("PAYMENT");
				
				eximbayReadyOrderVO.getEximbayPaymentVO().setCurrency("USD");
				//TODO 상품정보 조회 후 금액 계산
				eximbayReadyOrderVO.getEximbayPaymentVO().setAmount("10000");
				eximbayReadyOrderVO.getEximbayPaymentVO().setLang("KR");
				//TODO 결제 완료 페이지
				eximbayReadyOrderVO.getEximbayUrlVO().setReturn_url("eximbay.com");
				//TODO 결제 검증 수신 페이지
				eximbayReadyOrderVO.getEximbayUrlVO().setStatus_url("eximbay.com");
				
				//TODO 국내 결제 시 세금 정보 셋팅 ( 네이버페이 포인트 결제 시 모두 필수 )
				//현금 영수증 발급
				eximbayReadyOrderVO.getEximbayTaxVO().setReceipt_status("N");
				// 결제 금액 중 면세 금액
				eximbayReadyOrderVO.getEximbayTaxVO().setAmount_tax_free("1");
				// 결제 금액 중 과세 금액
				eximbayReadyOrderVO.getEximbayTaxVO().setAmount_taxable("1");
				// 결제 금액 중 부과세 금액
				eximbayReadyOrderVO.getEximbayTaxVO().setAmount_vat("1");
				// 결제 금액 중 봉사료
				eximbayReadyOrderVO.getEximbayTaxVO().setAmount_service_fee("0");
				
				//TODO 예비 파라미터 정보 셋팅 
				//param.getEximbayOtherParamVO().setParam1("");
				//param.getEximbayOtherParamVO().setParam2("");
				
				//국내 결제인 경우만 
				eximbayReadyOrderVO.getEximbaySettingsVO().setIssuer_country("KR");
				//가상계좌 결제 입금만료기한 셋팅 시 
				//param.getEximbaySettingsVO().setVirtualaccount_expiry_date("");
			} else 
				throw new RuntimeException();
			
			//TODO 상품정보 DB 조회
			eximbayReadyOrderVO.getProductList().clear();
			EximbayReadyProductVO eximbayProductVO = new EximbayReadyProductVO();
			eximbayProductVO.setProduct_id("1");
			eximbayProductVO.setName("주문1");
			eximbayProductVO.setQuantity("1");
			eximbayProductVO.setUnit_price("1000");
			eximbayProductVO.setLink("eximbay.com");
			eximbayReadyOrderVO.getProductList().add(eximbayProductVO);
			eximbayProductVO = new EximbayReadyProductVO();
			eximbayProductVO.setProduct_id("2");
			eximbayProductVO.setName("주문2");
			eximbayProductVO.setQuantity("2");
			eximbayProductVO.setUnit_price("5000");
			eximbayProductVO.setLink("eximbay.com");
			eximbayReadyOrderVO.getProductList().add(eximbayProductVO);
			
			System.out.println("Eximbay Ready :: "+eximbayReadyOrderVO.toString());
			EximbayReadyReturnVO eximbayReadyReturnVO =  (EximbayReadyReturnVO) EximbayService.ready(eximbayReadyOrderVO);
			System.out.println(eximbayReadyReturnVO);
			if ("0000".equals(eximbayReadyReturnVO.getRescode())){
				
				if ("".equals(eximbayReadyReturnVO.getFgkey())) {
					throw new RuntimeException();
				} else {
					eximbayReadyOrderVO.setFgkey(eximbayReadyReturnVO.getFgkey());
				}
				//TODO 주문정보 DB 저장
				//sampleDAO.insertOrderId(eximbayReadyOrderVO);
				//TODO 주문 상품정보 DB 저장
				//sampleDAO.insertProduct(eximbayReadyOrderVO.getProductList());
				return eximbayReadyOrderVO.toString();
			} else {
				throw new RuntimeException();
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean eximbayVerifyValidate(Map<String,String> orderInfo, Map<String,String> param){
		
		if(!orderInfo.get("currency").equals(param.get("currency"))) return false;
		//주문 금액 확인 &amount=100
		if(!orderInfo.get("amount").equals(param.get("amount"))) return false;
		//결제수단 코드 확인 &payment_method=P101
		if(!orderInfo.get("payment_method").equals(param.get("payment_method"))) return false;
		//국내 or 해외 결제
		EximbayPayType payType = EximbayPayType.findByPayType(orderInfo.get("payment_method"));
		EximbayPayTypeGroup eximBayPayment = EximbayPayTypeGroup.findByPayment(payType);
		//국내 결제인 경우
		if (eximBayPayment == EximbayPayTypeGroup.LOCALPAY) {
			//네이버 포인트 & 가상계좌
			if (payType == EximbayPayType.NAVERPAY_POINT || payType == EximbayPayType.VER_ACCOUNT){
				
			} else {
				
			}
		} else if (eximBayPayment == EximbayPayTypeGroup.GLOBALPAY){
			
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
		
		return true;
	}
	
	@Override
	public String callEximbayStatus(Map<String,String> param, HttpServletRequest req, HttpServletResponse res){
		//String retVal = "rescode=null&resmsg=null";
		//Eximbay 데이터 검증 호출
		EximbayReadyReturnVO returnVO = (EximbayReadyReturnVO) EximbayService.verify(req);
		//데이터 검증 성공이면
		if ("0000".equals(returnVO.getRescode())){
			if (param != null && !param.isEmpty()) {
				// 수신 결과값이 성공인 경우
				if("0000".equals(param.get("rescode"))){
					//&resmsg=Success.&rescode=0000
					//상점ID 비교 //상점ID &mid=1849705C64
					//if(!testEximbayMid.equals(param.get("mid"))) return false;
					
					//TODO 주문번호로 주문정보 조회
					Map<String,String> orderInfo = new HashMap<String,String>();
					/**TODO 샘플데이터**/
					orderInfo.put("order_id","20220927152140");
					orderInfo.put("transaction_id","1849705C6420220927000016");
					orderInfo.put("currency","USD");
					orderInfo.put("amount","100");
					orderInfo.put("payment_method","P101");
					orderInfo.put("transaction_type","PAYMENT");
					//주문 데이터 확인
					if (orderInfo != null && !orderInfo.isEmpty()){
						// 파라미터 validate
						if (eximbayVerifyValidate(orderInfo,param)) {
							EximbayPayType payType = EximbayPayType.findByPayType(orderInfo.get("payment_method"));
							EximbayPayTypeGroup eximBayPayment = EximbayPayTypeGroup.findByPayment(payType);
							/**
							 * TODO 결제 데이터 업데이트 
							 */
							//TODO 중복 호출 방지해야함. transactionID 또는 order_id 확인 필요.
							//검증 데이터 DB 등록 후
							
							
							//해외 결제인 경우
							if (eximBayPayment == EximbayPayTypeGroup.GLOBALPAY){
								/**
								 * TODO 내부 청구 시스템 데이터 송신
								 */
							} 
							
							return "rescode=0000&resmsg=Success";
						} else {
							// validate 통과 못한 경우
							return "rescode=null&resmsg=null";
						}
						
					} else {
						//주문 데이터가 없는 경우
						return "rescode=null&resmsg=null";
					}
				} else {
					//eximbay querystring 실패 코드 전송
					return String.format("rescode=%s&resmsg=%s", param.get("rescode"), param.get("resmsg"));
				}
			} else {
				return "rescode=null&resmsg=null";
			}
		} else {
			//eximbay verify실행 실패 코드 전송
			return String.format("rescode=%s&resmsg=%s", returnVO.getRescode(), returnVO.getResmsg());
		}
		//return retVal;
	}
	
	@Override
	public String eximbayPaymentCancel(String transactionId, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		/**
		 * TODO transactionId 에 해당하는 승인 내역 조회
		 **/
		EximbayPayType eximbayPayType = EximbayPayType.findByPayType("P101");
		
		EximbayCancelOrderVO eximbayCancelOrderVO = new EximbayCancelOrderVO();
		//F: 전체취소, P:부분취소
		eximbayCancelOrderVO.getRefund().setRefund_type("F");
		//refund_type가 F 인 경우 금액을 보내지 않으면 원 승인 거래 전체 금액 취소
		eximbayCancelOrderVO.getRefund().setRefund_amount("1");
		/**
		 * TODO 고유 취소번호 발급 필요
		 **/
		eximbayCancelOrderVO.getRefund().setRefund_id("1849705C64");
		//결제 취소 사유
		eximbayCancelOrderVO.getRefund().setReason("단순변심");
		
		//결제시 사용한 거래 주문번호
		eximbayCancelOrderVO.getPayment().setOrder_id("20220829170258");
		//결제시 사용한 통화코드
		eximbayCancelOrderVO.getPayment().setCurrency("USD");
		//총 결제 금액
		eximbayCancelOrderVO.getPayment().setAmount("1");
		//취소 가능 금액 (승인 금액 - 환불 금액)
		eximbayCancelOrderVO.getPayment().setBalance("1");
		//결제창 지원 언어코드
		eximbayCancelOrderVO.getPayment().setLang("KO");
		
		/**
		 * TODO 예비 파라미터 정보 확인
		 **/
		//eximbayCancelOrderVO.getOther_param().setParam1("");
		//eximbayCancelOrderVO.getOther_param().setParam2("");
		
		//환불계좌 예금주
		eximbayCancelOrderVO.getRefund_account().setUser_name("홍길동");
		//환불계좌 은행코드
		eximbayCancelOrderVO.getRefund_account().setBank_code("");
		//환불계좌 계좌번호
		eximbayCancelOrderVO.getRefund_account().setAccount_number("");
		
		/**
		 * TODO 가상계좌, 네이버페이 확인 추가
		 * 가상계좌 또는 네이버페이 취소 시 사용
		 **/
		if (eximbayPayType == EximbayPayType.NAVERPAY_POINT
				|| eximbayPayType == EximbayPayType.NAVERPAY_CARDPOINT
				|| eximbayPayType == EximbayPayType.VER_ACCOUNT) {
			
			//현금영수증 발행 여부
			eximbayCancelOrderVO.getTax().setReceipt_status("N");
			//면세 금액
			eximbayCancelOrderVO.getTax().setAmount_tax_free("");
			//과세 금액
			eximbayCancelOrderVO.getTax().setAmount_taxable("");
			//부가세 금액
			eximbayCancelOrderVO.getTax().setAmount_vat("");
			//봉사료
			eximbayCancelOrderVO.getTax().setAmount_service_fee("");
		}
		
		EximbayCancelReturnVO cancelReturnVO = (EximbayCancelReturnVO) EximbayService.cancel(transactionId,eximbayCancelOrderVO);
		
		//취소응답이 성공인 경우
		if ("0000".equals(cancelReturnVO.getRescode())) {
			/**
			 * TODO 주문정보 취소처리 DB 저장
			 */
			System.out.println("cancelReturnVO :: "+cancelReturnVO);
		} else {
			System.out.println("cancelReturnVO :: "+cancelReturnVO.toString());
			String code = "";
			if (!"".equals(cancelReturnVO.getRescode())) 
				code = cancelReturnVO.getRescode();
			else 
				code = cancelReturnVO.getCode();
			
			EximbayErrorCode eximbayErrorCode = EximbayErrorCode.findByPayType(code);
			if (eximbayErrorCode == EximbayErrorCode.EMPTY){
				System.out.println("CODE EMPTY");
				System.out.println(cancelReturnVO.getCode());
				System.out.println(cancelReturnVO.getMessage());
				System.out.println(cancelReturnVO.getDescription());
			} else {
				System.out.println(eximbayErrorCode.getErrCode());
				System.out.println(eximbayErrorCode.getMsg());
			}
		}
		
		return "";
	}
}
