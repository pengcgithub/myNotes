# JDK6升级JDK8踩雷

## 简介 ##

此次升级借助于公司项目，现公司项目为JDK6，处于总总原因的考虑，需要将现有版本升级为JDK8。整个项目的环境非常的乱，没有用maven做jar管理，所以升级过程中也遇到了一些小麻烦，编码更是惨不忍睹，虽然步步艰辛，但是我也都一一克服了。

之前项目开发过程中不太关注JDK版本与版本之间的差异，以及JDK版本和spring之间的异同，通过这次升级也能够了解一些其中的关系。比如spring4以上的版本才能够兼容JDK8的、还有`FtpClient`到JDK7开始就已经被重写了等等问题

博客的记录过程会直接复刻解决问题的过程，一方面便于记录，另一方面便于读者理解，逐步深入。

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



## 参考资料 ##

[Quartz - Spring 环境下的使用](http://www.cnblogs.com/solverpeng/p/5908381.html)

[Spring 3.x 升级到Spring 4.x 注意事项和步骤，错误解决方法](http://www.sojson.com/blog/145.html)

[ Spring3 升级Spring 4](http://blog.csdn.net/three_man/article/details/51173140)
