# Java读取 Properties文件 #

在实际的开发中会存在将一些可配置的选项（比如路径），放置到properties文件中。代码中需要引用那就直接读取调用，如修改只需修改properties文件即可。

## 实现说明 ##

## 源码解析 ##

## 封装类 ##

<pre>
/**
* @params sourceUrl 源路径
* @params sourceData 源数据查询名称
* @return 返回Map<String, Object>
*/
public static Map<String, Object> readPropertiesFile(String soureUrl, List<String> soureData) 
{
	Map<String, Object> readProFileMap = new HashMap<String, Object>();
	Properties prop = new Properties();
	InputStream in = Object.class.getResourceAsStream("/"+soureUrl);
	try 
	{
		prop.load(in);
		for (String element : soureData)
		{
			readProFileMap.put(element, prop.getProperty(element).trim());
		}
	} 
	catch (IOException e) 
	{
		e.printStackTrace();
	}
	return readProFileMap;
}
</pre>