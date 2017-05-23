
### 核心 ###

Vue



### loader ###

vue-html-loader

css-loader

vue-style-loader

vue-hot-reload-api


### babel ###

babel-loader

babel-core

babel-plugin-transform-run

babel-preset-es2015

babel-runtime


### 路由 ###

vue-router

bower info vue-router

npm install vue-router@0.7.13 --save

配合vue-loader使用

Vue.use(Router)

配置路由

var router = new VueRouter();
router.map({
路由规则
})

开启路由

router.start(App, "#app")



## 基本流程 ##
npm install vue-cli -g #安装Vue安装环境

vue init simple#1.0 vue-simple-demo 

webpack 可以使用（大型项目）
Eslint 检查代码规范(特有)
单元测试（特有）

webpack-simple  个人推荐使用，相比较webpack没有代码检查以及单元测试


