package site.dungang.luosimao;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("luosimao")
public class LuosimaoProperties {
	
	private String gateway = "https://captcha.luosimao.com/api/site_verify";

	private String apiKey = "";
	
	private String siteKey = "";

	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getSiteKey() {
		return siteKey;
	}

	public void setSiteKey(String siteKey) {
		this.siteKey = siteKey;
	}
	
	
}
