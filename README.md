spring luosimao captcha
--

> 后端代码

```
public class Model {

	@LusimaoCaptcha
	private String luotest_response;
	
}
```

> 前端代码

```
<div data-site-key="" data-width="300" class="l-captcha" ></div>

<script>
var c = document.createElement('script');c.type = 'text/javascript';c.async = true;
c.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'captcha.luosimao.com/static/dist/captcha.js?v=201610101436';
var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(c, s);
</script>

```
