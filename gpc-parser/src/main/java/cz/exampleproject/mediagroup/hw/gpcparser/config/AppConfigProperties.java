package cz.exampleproject.mediagroup.hw.gpcparser.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * Properties for GPC file format parser
 */
@ConfigurationProperties(prefix = "gpc-file")
public class AppConfigProperties {

	/**
	 * Path to charset
	 */
	@Value("charset")
	private String charset = "Windows-1250";

	/**
	 * Instantiates a new App config properties.
	 */
	public AppConfigProperties ( ) {
	}

	/**
	 * Gets charset.
	 *
	 * @return the charset
	 */
	public String getCharset ( ) {
		return charset;
	}

	/**
	 * Sets charset.
	 *
	 * @param charset the charset
	 */
	public void setCharset (String charset) {
		this.charset = charset;
	}

}
