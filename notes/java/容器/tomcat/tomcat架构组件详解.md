# tomcat架构组件详解 #

顶级组件：位于整个配置的顶部
容器类：可以包含其他组件的组件
连接器组件：连接用户请求至tomcat
被嵌套类的组件：位于一个容器当中，不能包含其他组件

容器类：
engine：核心容器，catalina引擎，扶着通过connector接收用户请求
host：类似于httpd中的虚拟主机，支持基于fqdn的虚拟主机
context：最内层的容器类组件，一个context代表一个web应用程序:配置context的主要目的，指定对应的webapp的根目录：还能为webapp指定额外的属性，如部署方式等。

服务：
service:将连接器关联至engine：
因此一个service内部可以有多个connector，但只有一个engine:

顶级组件：server，表示一个运行与jvm中的tomcat实例：

嵌套类组件：
value：拦截请求并在将其转至对应的webapp之前进行某种处理操作，可以用于任何容器中。
access log valve:
remote address filter value:基于IP做访问控制

logger:日志记录器，用于记录组件，内部的状态信息，可用于除context之外的任何容器中

realm:可以用于任何容器类的组件中，关联一个用户认证库，实现认证和授权；
UserDatabaseRealm:使用JNDI自定义的用户认证库；
MemoryRealm:tomcat-users.xml中
JDBCRealm:基于JDBC连接至数据库中查找用户