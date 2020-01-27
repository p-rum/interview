package cz.exampleproject.mediagroup.hw.gpcparser.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * Properties for GPC file format parser
 */
@ConfigurationProperties(prefix = "gpc-file")
public class GPCConfigProperties {

	@Value("charset")
	private String charset = "Windows-1250";

	public String getCharset ( ) {
		return charset;
	}

	public void setCharset (String charset) {
		this.charset = charset;
	}

}
