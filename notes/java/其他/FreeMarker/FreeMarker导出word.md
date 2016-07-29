# freemarker 导出word #

## 简介 ##


Apache的FreeMarker是一个模板引擎：一个Java库生成基于模板和改变数据输出的文本（HTML网页，电子邮件，配置文件，源代码等）。模板中写入Freemarker模板语言（ FTL ），这是一个简单的，专业的语言（而不是一个完全成熟的编程语言如PHP）。准备数据必须让真正的编程语言去操作，比如数据库查询和业务计算，然后在已经准备好的模板中显示。在模板中，你的重点是如何呈现的数据，而模板之外你的重点是控制什么样的数据呈现。

FreeMarker对于word的导出功能非常强大，相比较其他如poi等，FreeMarker都表现的极其优秀及灵活。

## 导入jar ##

<pre>
&lt;dependency&gt;
    &lt;groupId&gt;org.freemarker&lt;/groupId&gt;
    &lt;artifactId&gt;freemarker&lt;/artifactId&gt;
    &lt;version&gt;2.3.23&lt;/version&gt;
&lt;/dependency&gt;
</pre>

## 语法 ##

以下仅介绍了FreeMarker语法的皮毛，具体的语法可以参考[FTL指令参考](http://freemarker.org/docs/ref_directive_alphaidx.html),文档中做了非常详细的介绍。

<pre>
${name}  :  数据展示
</pre>

<pre>
<#if x == 1>
  x is 1
<#elseif x == 2>
  x is 2
<#elseif x == 3>
  x is 3
<#elseif x == 4>
  x is 4
<#else>
  x is not 1 nor 2 nor 3 nor 4
&lt;/#if>

说明：
1、此处的X不需要再另外这样显示${X}显示，如果比较的类型为string，那么则需要 <#if x == '1'>,此处需要特别主要，如果是导出word的情况，不要在work中加好引号之后导出ftl文件，这样的话会导致显示数据失效，需要待ftl导出之后再修改文件内容。
</pre>

<pre>
<#list users as user>
  ${user}
&lt;/#list>

说明：
1、循环遍历users集合
</pre>

<pre>
${name!''}、${name??}

说明：
1、${name!''} 如果name为null或者不存在时，那么就设置为''.
2、${name??} 判断name是否为空的判断
</pre>

## 代码实现 ##

<pre>
public class DocumentHandler {
    
	/* 导出文件存放的路径，此处对应resources的根目录 */
	private static final String EXPORT_PATH = "/export";
	
	private String template = null;
	
	private Configuration configuration = null;
	
	public DocumentHandler() {
		configuration = new Configuration();
		configuration.setDefaultEncoding("UTF-8");
	}
	
	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}
	
	/**
	 * dataMap 需要显示的数据，需要以map对象的形式展示
	 * filename 写入文件保存的路径
	 */
	public void createDoc(Map<String, Object> dataMap, String fileName) throws UnsupportedEncodingException, FileNotFoundException {
		configuration.setClassForTemplateLoading(this.getClass(), EXPORT_PATH);
		Template t = null;
		try {
			/* 获取.ftl导出模板 */
			t = configuration.getTemplate(template + ".ftl");
		} catch (Exception e) {
			e.printStackTrace();
		}
		File outFile = new File(fileName);
		Writer out = null;
		FileOutputStream fos = new FileOutputStream(outFile);
		out = new OutputStreamWriter(fos, "UTF-8");
		
		try {
			t.process(dataMap, out);
			out.flush();
			out.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
</pre>

## 其他 ##

1、设置word模板，需要将画出需要展示的word模板，然后将内容另存为XML格式，最后直接将XML格式文件直接修改后缀为FTL文件。通过这样转化并不能一次性达到效果，对于数据展示需要调整FTL文件，如下：

- `<#if x == '1'>` 如果是判断字符串，那么就不能够直接在word中写好转化，需要向转化之后再在ftl文件中修改。
- `<#list users as user>` 所有涉及到尖括号的操作都需要在转化之后再ftl文件中修改，因为通过转化会将加括号全部转化为&lt;和&gt;标签，这样对于FTL语言来说就无法识别。
- 考虑到不是所有的数据都是存在或有值的，所以最后都加上为空判断`${name!''}`



## 参考资料 ##

[http://freemarker.org/](http://freemarker.org/)




