# "丝袜哥" 接口规范

## 简介

## 常用注解

- @Api()

用于类注释，标识这个类的swagger资源。

<pre>
@Api(value = "类模块说明", description = "类模块详细描述")
或则
@Api(tags = "类模块说明", description = "类模块详细描述")
</pre>

- @ApiOperation()

用于方法注释，表示一个http请求的操作

<pre>
@ApiOperation(
  value = "接口说明",
  notes = "接口详细描述",
  httpMethod = "请求方式（POST、GET、DELETE、PUT）",
  response = 返回对象类型（UserBean.class）,
  produces = MediaType.APPLICATION_JSON_VALUE)
</pre>

- @ApiParam()

对参数添加说明或则必填等

<pre>
@ApiParam(name = "参数名称（例如：id）", value = "参数注释", required = true)
</pre>

- @ApiImplicitParam()

隐式的请求参数，即请求方法中没有显示绑定参数名称。

<pre>
@ApiImplicitParam(name="id", value="隐形参数说明", dataType = "参数类型（例如：string）", paramType = "参数类型（例如：query）")
</pre>

- @ApiImplicitParams()

隐式的请求参数列表

<pre>
@ApiImplicitParams({
  @ApiImplicitParam(name="id", value="隐形参数说明", dataType = "参数类型（例如：string）", paramType = "参数类型（例如：query）")
})
</pre>

- @ApiModel()

用于类，表示对类进行说明。

<pre>
@ApiModel(value = "对象名", description = "对象描述", parent = BaseBean.class)
</pre>

- @ApiModelProperty()

用于字段，表示对model属性的说明。

<pre>
@ApiModelProperty(value = "字段说明", name = "重写属性名称", example="举例说明", required = true, hidden = false)
</pre>

- @ApiIgnore()

用于类或者方法上，可以不被swagger显示在页面上 

## 参考资料

- [ swagger2常用注解说明](http://blog.csdn.net/u014231523/article/details/76522486)

- [Springfox Reference Documentation](https://springfox.github.io/springfox/docs/current/#springfox-samples)

- [Swagger-Core Annotations](https://github.com/swagger-api/swagger-core/wiki/Annotations-1.5.X#api)




