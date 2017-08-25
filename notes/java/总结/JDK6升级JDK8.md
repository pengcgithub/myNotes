# JDK6升级JDK8踩雷

## 简介 ##

此次升级借助于公司项目，现公司项目为JDK6，出于种种原因的考虑，需要将现有版本升级为JDK8。整个项目的环境非常的乱，没有用maven做jar管理，所以升级过程中也遇到了一些小麻烦，编码更是惨不忍睹，虽然步步艰辛，但是我也都一一克服了。

之前项目开发过程中不太关注JDK版本与版本之间的差异，以及JDK版本和spring之间的异同，通过这次升级也能够了解一些其中的关系。比如spring4以上的版本才能够兼容JDK8的、还有`FtpClient`到JDK7开始就已经被重写了等等问题

博客的记录过程会直接复刻解决问题的过程，一方面便于记录，另一方面便于读者理解。

## 升级参数 ##

- IntelliJ IDEA 2017.1.5

> 原项目配置

- JDK6
- Tomcat 6
- Spring 3.2.8
- Mybatis 3.2.6

> 现项目配置

- JDK8
- Tomcat8
- Spring 4.2.5
- Mybatis 3.2.6
- jackson-core 2.8.4
- quartz 2.2.2


## 踩雷过程 ##

### 1、FtpClient 报错 ###

此功能主要用于将文件上传至FTP文件服务器操作，原本JDK6版本 `FtpClient` 需要new实现，但是至JDK7之后重写了相关方法，所以想要从JDK6升级到JDK8首先得重写FTP文件上传相关功能。 具体实现可以Google，或者使用我有提供好。

[FtpUtil.java](https://github.com/pengcgithub/share.utils/blob/master/src/main/java/com/share/network/FtpUtil.java)

### 2、spring4.x 支持 JDK8 ###

原本项目spring是基于3.x的，但是spring对于JDK8的支持只有4.x才开始。所以为了能够成功升级JDK8，必须要先更换之前spring相关的jar。
替换jar之后还需要将所有xml配置文件中基于3.x的引用全部替换成4.x。

![替换xml中相关属性](http://i.imgur.com/fZn8Uzh.png)

### 3、配置json解析 ###

spring4.x下对于Jackson的配置发生了些许变化，原先的配置`org.springframework.http.converter.json.MappingJacksonHttpMessageConverter`现已替换为`org.springframework.http.converter.json.MappingJackson2HttpMessageConverter`，所以参考以下配置即可完成从spring3.x到spring4.x的转化。

![spring4.x配置Jackson](http://i.imgur.com/hoK26Wn.png)

配置Jackson的同时，也需要升级Jackson相关的jar`jackson-annotations`、`jackson-databind`、`jackson-core`

### 4、重写Quartz在spring4.x下的配置 ###

Quartz和spring的整合，在spring4.x中有两点区别。

- spring4.x开始使用`ref`，由`local`变为`bean`属性
`<ref local="imageDeleteTrigger"/>` 变为 `<ref bean="closeOrderTrigger"/>`

- `org.springframework.scheduling.quartz.CronTriggerBean`类在spring4.x中被弃用，现变更为`org.springframework.scheduling.quartz.CronTriggerFactoryBean`类

具体重写可以参考 [Quartz - Spring4.x 环境下的使用](http://www.cnblogs.com/solverpeng/p/5908381.html)

### 5、Spring Security 4.x 默认开启CSRF保护功能

CSRF保护功能在Spring Security 3.x中是默认关闭的，所有3.x中并不需要过多关注，如果有必要用到防御，需要开启后再加入部分配置。
开启CSRF保护之后如何使用可以参数[Spring Boot与Spring Security整合后post数据不了，403拒绝访问](http://www.cnblogs.com/zhao1949/p/6399925.html)

![](http://i.imgur.com/stq3BSk.png)

## 参考资料 ##

[Quartz - Spring 环境下的使用](http://www.cnblogs.com/solverpeng/p/5908381.html)

[Spring 3.x 升级到Spring 4.x 注意事项和步骤，错误解决方法](http://www.sojson.com/blog/145.html)

[ Spring3 升级Spring 4](http://blog.csdn.net/three_man/article/details/51173140)

## 参与者 ##

- [pengcheng321@gmail.com](https://github.com/pengcgithub)
