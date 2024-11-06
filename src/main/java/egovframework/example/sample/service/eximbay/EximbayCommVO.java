package egovframework.example.sample.service.eximbay;

import egovframework.example.cmmn.EximbayPayParam;
import egovframework.example.cmmn.EximbayService;

public class EximbayCommVO {
	
	public String toString(Object obj){
		if (isEmpty(obj)) return "";
		
		EximbayPayParam eximbayPayParam = EximbayPayParam.findByPayType(obj.getClass().getSimpleName());
		String str = EximbayService.appendClassVariable(obj);
		
		if (eximbayPayParam == EximbayPayParam.READY_PRODUCT){
			return "{" + str + "}\n";
		} else {
			return "\""+eximbayPayParam.getKeyNm()+"\":\n{" + str + "}\n";
		}
	}
	
	public boolean isEmpty(Object obj){
		return EximbayService.isClassVariableEmpty(obj);
	}
}
