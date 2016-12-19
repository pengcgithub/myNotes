# hexo #

### 1、创建hexo ###

由于hexo是node写的，并且也是需要基于github运行的，所有安装hexo之前需要安装一下

- [nodejs](http://nodejs.org/)

- [Git](http://git-scm.com/)

#### 安装Hexo ####

1、安装hexo

`$ npm install hexo-cli -g`

2、创建hexo项目

`$ hexo init blog`

3、进入blog（cd blog），使用一下命令可以操作hexo。

生成静态文件 ： `hexo generate`

发表草稿 ： `hexo publish [layout] <filename>`

启动服务器(默认情况下，访问网址为： http://localhost:4000/) : `hexo server`

部署网站,通过此命令可以将静态文件发布到github等平台 ： `hexo deploy`

清除缓存文件 (db.json) 和已生成的静态文件 (public) ： `hexo clean`


### 2、使用hexo deploy部署至github ###

首先安装 hexo-deployer-git.
<pre>
$ npm install hexo-deployer-git --save
</pre>

其次需要在_config.xml文件中配置如下，具体可以[参考配置](https://hexo.io/docs/deployment.html)：
<pre>
deploy:
  type: git
  repo: git@github.com:pengcgithub/pengcgithub.github.io.git
  branch: master
</pre>

type ： 固定写法，之前hexo版本有写github的，但是目前版本基本上都是git

repo ： GitHub repository URL，如果你需要部署到其他平台此处需要写入他们的URL即可

branch ： 分支的名称

然后执行`hexo d`即可完成部署。

#### 踩坑提醒 ####

**1、读取不到git分支**

报错 ： could not read Username for 'https://github.com': No error

解决 ： 将repo的连接方式换成SSH的连接方式

**2、没有设置public key**

报错 ： Permission denied (publickey).
fatal: Could not read from remote repository.
Please make sure you have the correct access rights
and the repository exists.

解决 ： 在本机生成public key （参考[github帮助](https://help.github.com/articles/generating-an-ssh-key/)）：

`＃ssh-keygen -t rsa -b 4096 -C "xxx@xxx.com"`

然后在#user_id/.ssh目录下会生成两个文件，id_rsa.pub和id_rsa.(可以通过 `clip < ~/.ssh/id_rsa.pub`命令去复制密钥文件内容)

然后登陆github，在[SSH设置页面](https://github.com/settings/ssh)添加上刚才的public key文件也就是id_rsa.pub的内容即可。


### 参考文献 ###

[1、手把手教你使用Hexo + Github Pages搭建个人独立博客](http://jiji262.github.io/2016/04/15/2016-04-15-hexo-github-pages-blog/)

[2、教你定制Hexo的landscape打造自己的主题](http://www.jianshu.com/p/b96fd206571a)


