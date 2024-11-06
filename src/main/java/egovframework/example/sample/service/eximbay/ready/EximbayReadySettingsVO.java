package egovframework.example.sample.service.eximbay.ready;

import egovframework.example.sample.service.eximbay.EximbayCommVO;

public class EximbayReadySettingsVO extends EximbayCommVO {

	private String display_type;
	private String autoclose;
	private String site_foreign_currency;
	private String call_from_app;
	private String call_from_scheme;
	private String issuer_country;
	private String ostype;
	private String virtualaccount_expiry_date;
	
	public EximbayReadySettingsVO(){
		this.display_type = "";
		this.autoclose = "";
		this.site_foreign_currency = "";
		this.call_from_app = "";
		this.call_from_scheme = "";
		this.issuer_country = "";
		this.ostype = "";
		this.virtualaccount_expiry_date = "";
	}
	
	public String getDisplay_type() {
		return display_type;
	}
	public void setDisplay_type(String display_type) {
		this.display_type = display_type;
	}
	public String getAutoclose() {
		return autoclose;
	}
	public void setAutoclose(String autoclose) {
		this.autoclose = autoclose;
	}
	public String getSite_foreign_currency() {
		return site_foreign_currency;
	}
	public void setSite_foreign_currency(String site_foreign_currency) {
		this.site_foreign_currency = site_foreign_currency;
	}
	public String getCall_from_app() {
		return call_from_app;
	}
	public void setCall_from_app(String call_from_app) {
		this.call_from_app = call_from_app;
	}
	public String getCall_from_scheme() {
		return call_from_scheme;
	}
	public void setCall_from_scheme(String call_from_scheme) {
		this.call_from_scheme = call_from_scheme;
	}
	public String getIssuer_country() {
		return issuer_country;
	}
	public void setIssuer_country(String issuer_country) {
		this.issuer_country = issuer_country;
	}
	public String getOstype() {
		return ostype;
	}
	public void setOstype(String ostype) {
		this.ostype = ostype;
	}
	public String getVirtualaccount_expiry_date() {
		return virtualaccount_expiry_date;
	}
	public void setVirtualaccount_expiry_date(String virtualaccount_expiry_date) {
		this.virtualaccount_expiry_date = virtualaccount_expiry_date;
	}
	@Override
	public String toString(){
		return super.toString(this);
	}
}
