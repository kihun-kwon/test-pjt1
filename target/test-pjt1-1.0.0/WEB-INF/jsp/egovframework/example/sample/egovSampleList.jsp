<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**
  * @Class Name : egovSampleList.jsp
  * @Description : Sample List 화면
  * @Modification Information
  *
  *   수정일         수정자                   수정내용
  *  -------    --------    ---------------------------
  *  2009.02.01            최초 생성
  *
  * author 실행환경 개발팀
  * since 2009.02.01
  *
  * Copyright (C) 2009 by MOPAS  All right reserved.
  */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title><spring:message code="title.sample" /></title>
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="https://api-test.eximbay.com/v1/javascriptSDK.js"></script>
    
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>
    <script type="text/javaScript" language="javascript" defer="defer">
        <!--
        /* 글 수정 화면 function */
        function fn_egov_select(id) {
        	document.listForm.selectedId.value = id;
           	document.listForm.action = "<c:url value='/updateSampleView.do'/>";
           	document.listForm.submit();
        }
        
        /* 글 등록 화면 function */
        function fn_egov_addView() {
           	document.listForm.action = "<c:url value='/addSample.do'/>";
           	document.listForm.submit();
        }
        
        /* 글 목록 화면 function */
        function fn_egov_selectList() {
        	document.listForm.action = "<c:url value='/egovSampleList.do'/>";
           	document.listForm.submit();
        }
        
        /* pagination 페이지 링크 function */
        function fn_egov_link_page(pageNo){
        	document.listForm.pageIndex.value = pageNo;
        	document.listForm.action = "<c:url value='/egovSampleList.do'/>";
           	document.listForm.submit();
        }
        
        //-->
    </script>
    <script type="text/javascript">
      function payment() {
    	  const payment = {};
    	  const tax = {};
    	  const products = [];
    	  const product = {};
    	  const merchant = {};
    	  const buyer = {};
    	  const url = {};
    	  const settings = {};
    	  //const sendData = {};
    	  //PAYMENT: 인증, 승인, 매입
    	  //PAYER_AUTH: 인증
    	  //AUTHORIZE: 인증, 승인
    	  payment.transaction_type = "AUTHORIZE";
    	  //주문번호
    	  payment.order_id = "20220819105102";
    	  //원화:KRW 달러:USD
    	  payment.currency = "KRW";
    	  payment.amount = "40000000";
    	  payment.lang = "KR";
    	  //해외 VISA:P101 MASTER:P102 AMEX:P103 JCB:P104
    	  //국내  카카오페이:P302 토스:P303 페이코:P304 스마일페이:P306 네이버페이(카드):P307 네이버포인트:P308 네이버카드&포인트:P015 가상계좌:P305
    	  //payment.payment_method = "P302";
    	  payment.multi_payment_method = "P101";
    	  
    	  //국내 결제 시 
    	  tax.receipt_status = "N";
    	  tax.amount_tax_free = "100";
    	  tax.amount_taxable = "100";
    	  tax.amount_vat = "100";
    	  
    	  //상품
    	  product.name = "주문1";
    	  product.quantity = "1";
    	  product.unit_price = "1000";
    	  product.link = "eximbay.com";
    	  products[0] = product;
    	  product.name = "주문1";
    	  product.quantity = "1";
    	  product.unit_price = "1000";
    	  product.link = "eximbay.com";
    	  products[1] = product;
    	  product.name = "주문1";
    	  product.quantity = "1";
    	  product.unit_price = "1000";
    	  product.link = "eximbay.com";
    	  products[2] = product;
    	  product.name = "주문1";
    	  product.quantity = "1";
    	  product.unit_price = "1000";
    	  product.link = "eximbay.com";
    	  products[3] = product;
    	  
    	  //가맹점ID
    	  merchant.mid = "1849705C64";
    	  
    	  buyer.name = "eximbay";
    	  buyer.email = "test@eximbay.com";
    	  
    	  url.return_url = "eximbay.com";
    	  url.status_url = "eximbay.com";
    	  //국내결제
    	  //settings.issuer_country = "KR";
    	  //settings.display_type = "R";
    	  
    	  const sendData = {"payment":payment,"tax":tax,"product":products,"merchant":merchant,"buyer":buyer,"url":url,"settings":settings};
    	  
    	  
    	  //sendData.fgkey = 'test';
    	  //console.log(sendData);
    	  //delete sendData['fgkey'];
    	  //console.log(sendData);
    	  //return;
    	  $.get({
    		  type:'POST',
    		  url:'/test-pjt1/getFgKey.do',
    		  data:{'data':JSON.stringify(sendData)},
    		  success: function (res){
	    		  if (res){
	    			  sendData.fgkey = res;
	    			  EXIMBAY.request_pay(sendData);
	    		  }
    	  	  }
    	});
          
      }
</script>
</head>

<body style="text-align:center; margin:0 auto; display:inline; padding-top:100px;">
    <form:form commandName="searchVO" id="listForm" name="listForm" method="post">
        <input type="hidden" name="selectedId" />
        <div id="content_pop">
        	<!-- 타이틀 -->
        	<div id="title">
        		<ul>
        			<li><img src="<c:url value='/images/egovframework/example/title_dot.gif'/>" alt=""/><spring:message code="list.sample" /></li>
        		</ul>
        	</div>
        	<!-- // 타이틀 -->
        	<div id="search">
        		<ul>
        			<li>
        			    <label for="searchCondition" style="visibility:hidden;"><spring:message code="search.choose" /></label>
        				<form:select path="searchCondition" cssClass="use">
        					<form:option value="1" label="Name" />
        					<form:option value="0" label="ID" />
        				</form:select>
        			</li>
        			<li><label for="searchKeyword" style="visibility:hidden;display:none;"><spring:message code="search.keyword" /></label>
                        <form:input path="searchKeyword" cssClass="txt"/>
                    </li>
        			<li>
        	            <span class="btn_blue_l">
        	                <a href="javascript:fn_egov_selectList();"><spring:message code="button.search" /></a>
        	                <img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" style="margin-left:6px;" alt=""/>
        	            </span>
        	        </li>
                </ul>
        	</div>
        	<!-- List -->
        	<div id="table">
        		<table width="100%" border="0" cellpadding="0" cellspacing="0" summary="카테고리ID, 케테고리명, 사용여부, Description, 등록자 표시하는 테이블">
        			<caption style="visibility:hidden">카테고리ID, 케테고리명, 사용여부, Description, 등록자 표시하는 테이블</caption>
        			<colgroup>
        				<col width="40"/>
        				<col width="100"/>
        				<col width="150"/>
        				<col width="80"/>
        				<col width="?"/>
        				<col width="60"/>
        			</colgroup>
        			<tr>
        				<th align="center">No</th>
        				<th align="center"><spring:message code="title.sample.id" /></th>
        				<th align="center"><spring:message code="title.sample.name" /></th>
        				<th align="center"><spring:message code="title.sample.useYn" /></th>
        				<th align="center"><spring:message code="title.sample.description" /></th>
        				<th align="center"><spring:message code="title.sample.regUser" /></th>
        			</tr>
        			<c:forEach var="result" items="${resultList}" varStatus="status">
            			<tr>
            				<td align="center" class="listtd"><c:out value="${paginationInfo.totalRecordCount+1 - ((searchVO.pageIndex-1) * searchVO.pageSize + status.count)}"/></td>
            				<td align="center" class="listtd"><a href="javascript:fn_egov_select('<c:out value="${result.id}"/>')"><c:out value="${result.id}"/></a></td>
            				<td align="left" class="listtd"><c:out value="${result.name}"/>&nbsp;</td>
            				<td align="center" class="listtd"><c:out value="${result.useYn}"/>&nbsp;</td>
            				<td align="center" class="listtd"><c:out value="${result.description}"/>&nbsp;</td>
            				<td align="center" class="listtd"><c:out value="${result.regUser}"/>&nbsp;</td>
            			</tr>
        			</c:forEach>
        		</table>
        	</div>
        	<!-- /List -->
        	<div id="paging">
        		<ui:pagination paginationInfo = "${paginationInfo}" type="image" jsFunction="fn_egov_link_page" />
        		<form:hidden path="pageIndex" />
        	</div>
        	<div id="sysbtn">
        	  <ul>
        	      <li>
        	          <span class="btn_blue_l">
        	              <a href="javascript:fn_egov_addView();"><spring:message code="button.create" /></a>
                          <img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" style="margin-left:6px;" alt=""/>
                      </span>
        	          <span class="btn_blue_l">
        	              <button type="button" onclick="payment();">결제 창 연동</button>
                          <img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" style="margin-left:6px;" alt=""/>
                      </span>
                  </li>
              </ul>
        	</div>
        </div>
    </form:form>
</body>
</html>
