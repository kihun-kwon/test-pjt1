package egovframework.example.sample.service.eximbay.ready;

import egovframework.example.sample.service.eximbay.EximbayCommReturnVO;

public class EximbayReadyReturnVO extends EximbayCommReturnVO{

	private String fgkey;
	
	public EximbayReadyReturnVO(){
		this.fgkey = "";
	}

	public String getFgkey() {
		return fgkey;
	}

	public void setFgkey(String fgkey) {
		this.fgkey = fgkey;
	}
}
