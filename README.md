spring luosimao captcha
--

> pom.xml

```
	<dependency>
		<groupId>site.dungang</groupId>
		<artifactId>luosimao-captcha-spring</artifactId>
		<version>0.0.1</version>
	</dependency>
```

> 配置 applicaiton.yml

```
luosimao:
	gateway: https://captcha.luosimao.com/api/site_verify
	api-key: apikey
	site-key: sitekey
	
```

> 后端代码

```
public class Model {

	@LusimaoCaptcha
	private String luotest_response;
	
}
```

> 前端代码

```
<div data-site-key="sitekey" data-width="300" class="l-captcha" ></div>

<script>
var c = document.createElement('script');c.type = 'text/javascript';c.async = true;
c.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'captcha.luosimao.com/static/dist/captcha.js?v=201610101436';
var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(c, s);
</script>

```
