spring boot luosimao captcha
--

基于 spring boot 封装的 luosimao人机验证码

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
	private String luotest_response; //属性的名称固定的不能修改
	
}
```

> 前端代码

```
<div data-site-key="sitekey" data-width="270px" class="l-captcha" ></div>
<!-- thymeleaf -->
<p style="color: #FF5722" th:if="${#fields.hasErrors('luotest_response')}" th:errors="*{luotest_response}"></p>

<script>
var c = document.createElement('script');c.type = 'text/javascript';c.async = true;
c.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'captcha.luosimao.com/static/dist/captcha.js?v=201610101436';
var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(c, s);
</script>

```

## 协议

The MIT License (MIT)

Copyright (c) 2017 dungang

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the "Software"), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
