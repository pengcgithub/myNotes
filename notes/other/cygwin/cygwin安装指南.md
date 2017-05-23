# cygwin安装指南 #

## 简介 ##

cygwin主要是可以复刻Linux下的操作，不仅有利于熟悉Linux的人士在window下操作，而且也方便Linux小白进行操作学习。最开始使用该软件是在学习git的时候偶然看到的，cygwin对于git的兼容也是非常好的，可以非常便利的操作git。

## 步骤 ##

### 1、下载 ###

[https://www.cygwin.com/](https://www.cygwin.com/)

进入官网，选择对应自己机器(x86或者x64)的文件下载。

### 2、安装 ###

![](http://i.imgur.com/DVJURQY.png)

![](http://i.imgur.com/GalMwIL.png)

![](http://i.imgur.com/cTUkES1.png)

![](http://i.imgur.com/a6aOHg4.png)

上图是需要尤其注意的，毕竟默认提供的所有镜像都是比较慢的，这里不排除选择之后可以下载下来，但是这里最好选择中国区的镜像地址。

手动添加163的x86的地址： http://mirrors.163.com/cygwin/x86/

或x64的地址：http://mirrors.163.com/cygwin/x64/

上述描述的比较简单，具体可以参考[Cygwin安装时，选择163的源](http://www.crifan.com/cygwin_choose_163_mirror_error_unable_to_get_setup_ini_from_http_mirrors_163_com_cygwin/)。

![](http://i.imgur.com/tX5xfCr.png)

安装组件包也是比较关键的点，里面有很多组件包，但是为了能够使我们安装的cywin能够编译程序，我们需要安装gcc编译器。在`Devel`分支下选择自己需要的组件，我们必须如下：

- binutils

- gcc

- gcc-mingw

- gdb

具体选择那些组件可以参考[cygwin安装教程图解](http://blog.csdn.net/xj626852095/article/details/27524937)。如果涉及到git以及vim组件的安装，分别对应选择不同的组件即可。


## 参考资料 ##

- [Cygwin安装时，选择163的源后出错：Unable to get setup.ini from <http://mirrors.163.com/cygwin/>](http://www.crifan.com/cygwin_choose_163_mirror_error_unable_to_get_setup_ini_from_http_mirrors_163_com_cygwin/)

- [Cygwin 学习及使用](http://idxuanjun.github.io/blog/2014/02/22/learning-and-using-cygwin/)


