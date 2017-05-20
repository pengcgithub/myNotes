# idea 部署非maven项目 #

## 阐述 ##

最开始部署项目的时候一直对`Libraries`内容无法把握，之前部署maven项目时，所有依赖的jar文件会自动加载到`Libraries`中，但是非maven项目则需要手动设置jar的编译目录。还有就是项目的启动文件一定要在`modules`中配置好扫描的路径，在项目部署过程中就出现了`Invalid 'log4jConfigLocation' parameter: Log4j config file ... classes\artifacts\CRM1_0_war_exploded\WEB-INF\conf\log\log4j.properties [not found] `的问题。产生这个问题的主要原因是`modules`中设置了web的扫描范围过小，部分配置文件没有编译进去（建议直接设置编译目录为webRoot为根目录）。所以把握了以上两点，基本上就能水到渠成。

## 具体部署步骤 ##

### 1、配置Project Structure ###

- project 

![配置project](http://i.imgur.com/Mww94dS.png)

project中基本主要需要配置项目的名称、JDK、以及项目编译的路径

- Modules

![配置modules](http://i.imgur.com/RvXYf7e.png)

![](http://i.imgur.com/DDkVVM5.png)

与eclipse不同，此处modules就相当是eclipse中的项目的一样。此处的配置主要是需要将project中的项目导入到module中，需要注意的就是配置好项目的配置文件，已经扫描配置文件的目录。

- Libraries

![](http://i.imgur.com/XK3mnsI.png)

Libraries 主要是对于jar的依赖，此处不同于maven文件，通过`from maven`的方式就可以导入pom中的文件，非maven方式需要通过`java`的方式导入jar，并且此处需要注意，并不需要将lib下的jar文件全部引入，只需要引入jar的目录既lib目录就可以了。

- Facets

Facets的用处不是太清晰，主要就是选中项目中的配置文件即可。（web.xml、spring配置文件等）

- Artifacts

![](http://i.imgur.com/yx6BnQ0.png)

web部署中，这步是非常关键的。这步的配置主要是告诉web容器我需要通过何种方式部署，此处有两种，如下：

1、以`exploded`结尾的文件, 这是通过class文件的形式部署的，一般开发过程中建议使用这种方式。

2、另一种则是通过war文件的方式部署。

选择`exploded`结尾的文件时，需要注意查看WEB-INF/lib中是否有jar文件

### 2、配置web容器-Tomcat ###

![](http://i.imgur.com/I8C7ye0.png)

如果Project Structure配置好的话，那么tomcat的配置只是顺带的事情，因为其中不会有什么坑坑洼洼的东西。


## 遇到的问题 ##

### 1、jstl编译不通过 ###

可能是IDEA对于这种语法的不支持，所以需要引入jstl相关的jar。`jstl.jar`、`standard.jar`

### 2、jsp编译报错 ###

lib中缺少`jsp-api.jar`和`servlet.jar`文件，可以到Tomcat中的lib目录下拷贝。

## 插件推荐 ##

- background Image

背景图片插件

- Translation

翻译插件

- CodeGlance

编辑代码最右侧，显示一块代码小地图

- Grep Console

自定义控制台输出颜色，这样控制台就能比较明显的看到警告或则错误的信息，方便查找问题


## 参与者 ##

- [pengcheng321@gmail.com](https://github.com/pengcgithub)