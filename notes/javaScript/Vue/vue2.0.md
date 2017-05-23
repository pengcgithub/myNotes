#vue2.0#

到了2.0以后，有哪些变化

1、每个组件模板中，不支持片段代码

组件中的模板：

之前：
<pre>
<template>
  <h1>我是组件</h1>
  <strong>我是加粗<strong>
</template>
</pre>

现在： 必须有根元素，包裹住所有的代码
<pre>
<template>
<div>
  <h1>我是组件</h1>
  <strong>我是加粗<strong>
</div>
</template>
</pre>


之前组件：

<pre>
var aaa = Vue.extend('aaa', {
  template : '<h4>我是组件</h4>'
});
Vue.component('my-aaa', aaa);
</pre>

现在：
<pre>
Vue.component('aaa', {
  template : '<h4>我是组件</h4>'
});
</pre>

2、关于组件的定义

Vue.entend  这种方式，在2.0里面有，但是有一些改动，这种写法即使能用也不建议使用

Vue.component(组件名称, {
  data(){},
  methods:{},
  template:"#aaa"
});
还是可以使用的


vue2.0新推组件,建议定义:

<pre>
var Home = {
  template:"#aaa"
}
Vue.component(Home);
</pre>



3、生命周期

之前：

init  实例刚被创建

created

beforeCompile

compiled

ready  平时用的挺多 -> mounted

beforeDestroy

destroyed

现在:

beforeCreate 组件刚刚创建，属性都没有

created 实例已经创建了，属性已经绑定了(data)

beforeMount 模板编译之前

mounted 模板编译完成 代替之前的ready （重要）

beforeUpdate 组件更新之前

updated 组件更新完毕 （重要）

beforeDestroy 组件销毁前 this.$destroy();

destroyed 组件销毁之后 

3、循环

2.0里面默认可以添加重复数据

去掉了隐式变量

<pre>
<ul>
  <li v-for="(var, index) in list">
    {{var}}  {{list}}
  </li>
</ul>
</pre>

4、track-by="id"

变成

<li v-for="(val, index) in list" :key="index">

5、自定义键盘指令

之前：

Vue.directive('on').keyCodes.ctrl = 17;

现在：

Vue.config.keyCodes.ctrl = 17;

6、过滤器

之前：

系统自带很多过滤器

{{msg|json}}

{{msg|currency}}

到了2.0， 内置过滤器，全部删除。

lodash 工具库

自定义过滤器

Vue.filter('过滤器', function(n) {
 return n;
});

传参数方式

之前： {{msg | toDou '12' '5'}}

现在： {{msg | toDou('12', '5')}}