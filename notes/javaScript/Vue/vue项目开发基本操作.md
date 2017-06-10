## 简介 ##

再一开始学习Vue的时候，我们通常会使用`npm install vue`语法安装Vue，但是往往实际的项目开发中不太可能用这种方式去做项目，我们通常比较多的做法应该是利用[webpack]()作为前端项目的构建工具。利用webpack构建Vue项目通常有两种方式，一种是直接用`webpack`的方式，另一种则是`webpack-simple`的方式。

webpack 方式具有特有的两个功能：1、Eslint 检查代码规范 2、单元测试

webpack-simple 方式就反正没有以上两种功能，通常项目中推荐使用这种方式构建项目

`vue init simple#2.0 vue-simple-demo `

## 步骤 ##

首先Vue的依赖于node，所以一下的操作步骤依赖于node环境完好的前提下，node中会自带`npm`包管理器，由于国外的地址访问比较慢，建议修改为淘宝镜像，具体操作自己翻墙。

### 安装依赖环境 ###

1、vue-cli (安装Vue构建框架)

```
  cnpm install vue-cli -g 
```

2、vue环境

```
cnpm install vue -g 
```

3、webpack（项目管理以及构建工具）

```
  cnpm install webpack -g
```

4、webpack-simple（simple模板）

```
cnpm install webpack-simple -g
```

5、webpack-dev-server（webpack开发工具）
```
npm install webpack-dev-server --save-dev
```

### 生成项目 ###

利用`vue inti webpack-simple vue-simple-demo`方式创建项目

生成的项目如下：

![](http://i.imgur.com/tcIp3xs.png)

<pre>
├─.babelrc		// babel配置文件
├─.gitignore	
├─index.html		// 主页
├─package.json		// 项目配置文件
├─README.md  
├─webpack.config.js	// webpack配置文件
├─dist			// 发布目录
│   ├─.gitkeep       
├─src			// 开发目录	
│   ├─App.vue		// App.vue组件
│   ├─main.js		// 预编译入口
</pre>




