package site.dungang.luosimao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(LuosimaoProperties.class)
public class LuosimaoAutoConfiguration {
	
	private static final Logger logger = LoggerFactory.getLogger(LuosimaoAutoConfiguration.class);

	public LuosimaoAutoConfiguration() {
		logger.debug("LuosimaoAutoConfiguration start");
	}
}
