package site.dungang.lusoimao;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Constraint(validatedBy=LusimaoCaptcha.ValidateLusoimaoCaptcha.class)
public @interface LusimaoCaptcha {
	
	String message() default "验证码无效!";
	
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default{};
    
	class ValidateLusoimaoCaptcha implements ConstraintValidator<LusimaoCaptcha, String>  {

		private static Logger logger = LoggerFactory.getLogger(ValidateLusoimaoCaptcha.class);
				
		private Map<String, String> messages;
		
		/**
		 * luosimao人机验证码的key
		 */
		@Autowired
		private LuosimaoProperties properties;
		
		public void initialize(LusimaoCaptcha annotation) {
			messages.put("-10", "API KEY 为空");
			messages.put("-11", "response为空");
			messages.put("-2x", "response错误");
			messages.put("-40", "API_KEY使用错误");
		}

		public boolean isValid(String luotestResponse, ConstraintValidatorContext context) {
			Map<String, String> params = new HashMap<String, String>();
			params.put("response", luotestResponse);
			params.put("api_key", properties.getApiKey());
			String response = HttpClientUtil.sendHttpPost(properties.getGateway(),params);
			if(null != response && !response.isEmpty()) {
				Map<String, Object> result = parseJson2map(response);
				if(null != result && null!=result.get("res")) {
					if(result.get("res").equals("success")) {
						return true;
					} else if(null != result.get("error")) {
						String errorCode = (String) result.get("error");
						if(null != messages.get(errorCode)) {
							logger.error(messages.get(errorCode));
						}
					}
				} 
			}
			return false;
		}
		
		public  Map<String, Object> parseJson2map(String json) {
			Map<String, Object> map = new HashMap<String, Object>();
			ObjectMapper mapper = new ObjectMapper();
			try {
				map = mapper.readValue(json, new TypeReference<HashMap<String, Object>>() {
				});
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
			return map;
		}
		
	}
}
