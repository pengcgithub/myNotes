# tomcat负载均衡 #

Tomcat的运行方式：
standalone configure:
  request -> web server(tomcat) ->servlet container

apache与tomcat连接器通信的模块有两个:
mod_jk : apache/1.3、apache/2.0
mod_proxy ： apache/2.2

tomcat的连接器协议有两种：
http、ajp

mod_jk 与 mod_proxy 比较

负载均衡：都支持
管理接口：
兼容性：
配置：mod_proxy比jk简单的多
协议：mod_jk(ajp)、mod_proxy(http/https/ajp)


tomcat的http连接器：
类型有三种：
基于Java的http/1.1:
基于Java的高性能NIO HTTP/1.1连接器
基于c++研发的Native APR HTTP/1.1连接器

LAMT:
  apache(mod_jk, ajp) + tomcat(ajp connector)
  apache(mod_proxy, (http,https,ajp)) + tomcat(http, https, ajp)

LNMT:
  nginx + tomcat(http, https)
