package egovframework.example.sample.service.eximbay.ready;

import egovframework.example.sample.service.eximbay.EximbayCommVO;

public class EximbayReadyOtherParamVO extends EximbayCommVO {

	private String param1;
	private String param2;
	
	public EximbayReadyOtherParamVO(){
		this.param1 = "";
		this.param2 = "";
	}

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public String getParam2() {
		return param2;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
	}
	
	@Override
	public String toString(){
		return super.toString(this);
	}
}
