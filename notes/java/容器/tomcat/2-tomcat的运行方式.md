# tomcat的运行方式 #

apache jserv protocal
二进制协议，使用httpd方向代理用户请求至tomcat时，在httpd和tomcat之间使用；

LAMT : Apache反代理，使用JPA请求方式；
LNMT ： Nginx反代理，使用HTTP请求方式； 

1、server组件
className: 用于实现此server容器的完全限定类的名称，默认为org.apache.catalina.core.standardServer
port：接收shutdown指令的端口，默认仅允许通过本机访问，默认为8005
shutdown：发生此server用于实现关闭tomcat实例的命令字符串，默认为shutdown；

2、service组件
service主要用于关联一个引擎和与此引擎相关的连接器，每个连接器通过一个特定的端口和协议接收入站请求将其转发至关联引擎进行处理。因此，service要包含一个引擎、一个或多个连接器。

如上面实例中的定义
<service name="catalina">

这定义了一个名为catalina的service，此名字也会在产生相关的日志信息时记录在日志文件当中。

Service相关的属性
className: 用于实现此server容器的完全限定类的名称，默认为org.apache.catalina.core.standardServer
name：此服务的名称，默认为catalina

3、connector组件
进入tomcat的请求可以根据tomcat的工作模式分为如下两类：
tomcat作为应用程序服务器：请求来自于前端的web服务器，这可能是apache,IIS,Nginx等
tomcat作为独立服务器：请求来自于web浏览器；

tomcat应该考虑工作情形下的请求分别定义好需要的连接器才能正确接受来自客户端的请求，一个引擎可以有一个或多个连接器，以适应多种连接方式。

定义连接器可以使用多种属性，有些属性也只适用于某特定的连接器类型，一般来说，常见于service.xml中的连接器类型通常有四种：
1）HTTP连接器
2）SSL连接器
3）AJP 1.3连接器
4）proxy连接器

如上面实例service.xml中定义的HTTP连接器：<connector port="8080" protocol="HTTP/1.1" maxThreads="150" connectionTimeout="20000" redirectPort="8443" />

定义连接器时可以配置的属性非常多，但通常定义HTTP连接器时必须定义的属性只有"port"，定义AJP连接器时必须定义的属性只有"protocol",因为默认的协议为HTTP；
以下为常用属性说明：
1）address:指定连接器监听的地址，默认为所有地址，即0.0.0.0
2）maxThreads:支持的最大并发连接数，默认为200
3）port:监听的端口，默认为0
4）protocol:连接器使用的协议，默认为HTTP/1.1，定义AJP协议时通常为AJP/1.3
4)redirectPort
6)connectionTimeout
7)enableLookups
8)acceptCount

4、Engine

5、HOST组件
位于Engine容器中用于接收请求并进行相应处理的主机或虚拟机，如前面实例中的定义：
<Host appBase="webapps" autoDeploy="true" name="localhost" unpackWARs="true">

常用属性：
1)appBase: 此host的webapps目录，即存放非归档的web应用程序的目录或归档后的war文件的目录路径；可以使用基于$CATALINA_HOME的相对路径。
2）autoDeploy:在tomcat处于运行状态时放置于appBase目录中的应用程序文件是否自动进行deploy；默认为true；
3）unpackWars：在启动此webapps时是否对WAR格式的归档文件先进行展开；默认为true

虚拟主机定义实例：
<pre>
<Engine defaultHost="localhost" name="Catalina">
  <Host appBase="webapps" autoDeploy="true" name="localhost" unpackWARs="true">
    <Valve className="org.apache.catalina.valves.AccessLogValve" directory="logs" pattern="%h %l %u %t &quot;%r&quot; %s %b" prefix="localhost_access_log."suffix=".txt"/>
  <Context docBase="E:\JavaJava\tomcat7\webapps\spring-node-1" path="/spring-node-2" reloadable="true" source="org.eclipse.jst.jee.server:spring-node-1"/>
  <Context docBase="/web/bbs" path="/bbs" reloadable="true"/>
  </Host>
</Engine>
</pre>

6、Context


### servlet、jsp、jvm、Java编程语言、tomcat彼此间的关系 ###

java体系：
Java程序设计语言
Java api
java class 文件格式
Java VM

JDK：JVM + 工具库

JAVA EE:Java SE + 企业级类库
  servlet、jsp、jmx
  servlet:类库
  servlet container

Tomcat: JDK + servlet、jsp
Java EE : 不完整实现