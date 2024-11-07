package egovframework.example.sample.service.eximbay.ready;

import egovframework.example.sample.service.eximbay.EximbayCommVO;

public class EximbayReadyUrlVO extends EximbayCommVO {

	private String return_url;
	private String status_url;
	
	public EximbayReadyUrlVO(){
		this.return_url = "";
		this.status_url = "";
	}

	public String getReturn_url() {
		return return_url;
	}

	public void setReturn_url(String return_url) {
		this.return_url = return_url;
	}

	public String getStatus_url() {
		return status_url;
	}

	public void setStatus_url(String status_url) {
		this.status_url = status_url;
	}
	@Override
	public String toString() {
		return super.toString(this);
	}
}
