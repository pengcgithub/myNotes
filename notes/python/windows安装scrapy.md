# windows 安装scrapy爬虫框架

## 简介

Scrapy是一个为了爬取网站数据，提取结构性数据而编写的应用框架。 可以应用在包括数据挖掘，信息处理或存储历史数据等一系列的程序中。

## 安装

首先需要安装`python 3.5`以及`pip`包管理器，如果基础环境已经配置完毕，那么直接使用`pip install Scrapy`安装即可。但是往往事情都不会那么尽如人意，如果安装报以下错误：

- `Microsoft Visual C++ Build Tools`，由于Scrapy是基于C++开发的，所以需要编译环境。
- 其他原因都是由于安装Scrapy需要Twisted的依赖，所以必须先安装所缺少的依赖。

scrapy的依赖关系比较紧密，所以安装步骤必须有先后顺序，假设`python 3.5`以及`pip`包管理器已经安装完毕。下面正式进入`Scrapy`的安装。

**1、安装Visual C++ Build Tools**
由于Scrapy的依赖库文件中，pywin32和Twisted的底层是基于C语言开发的，因此需要安装C语言的编译环境。

**2、安装pywin32**
pywin32 必需使用exe安装包来进行安装，否则windows下很难安装，下载地址为：[Python for Windows Extensions](https://www.lfd.uci.edu/~gohlke/pythonlibs/#lxml)

**3、安装Twisted**
Scrapy需要依赖Twisted。Twisted是Python下面一个非常重要的基于事件驱动的IO引擎。Twisted的安装依赖于pywin32和前面的Visual C++ Build Tools，所以必需先安装完成这两个东西以后才能安装Twisted。

通常情况下使用`pip  install twisted`命令安装即可，但是我一直没有安装成功，所以推荐使用本地安装的方式安装，首先选择与`python`版本一致的[Twisted文件](https://www.lfd.uci.edu/~gohlke/pythonlibs/#lxml)。

安装时如果你没有选择正确的版本，那么会出现[twisted is not a supported wheel on this platform](https://blog.csdn.net/qing101hua/article/details/52504403)的错误，此刻只需要选择版本与`python`一直的Twisted文件即可。

<pre>pip install F:\python\mytool\Twisted-17.9.0-cp36-cp36m-win_amd64.whl</pre>

**4、pip 安装Scrapy**
<pre>pip  install scrapy</pre>

## 创建Scrapy项目

- 脚手架创建：`scrapy startproject 项目名称`
- 项目目录：
![](https://i.imgur.com/H77awWd.png)
- 初始化目录解析：
<pre>
scrapy.cfg: 项目的配置文件。
scrapyspider/: 该项目的python模块。之后您将在此加入代码。
scrapyspider/items.py: 项目中的item文件。
scrapyspider/pipelines.py: 项目中的pipelines文件。
scrapyspider/settings.py: 项目的设置文件。
scrapyspider/spiders/: 放置spider代码的目录。
</pre>

## 参考资料

- [如何在Windows下安装Scrapy](https://zhuanlan.zhihu.com/p/24982105)
- [pip install Scrapy报错及解决方法](https://blog.csdn.net/tanqu9315/article/details/79714249)



