# springBoot系列（IDEA 创建springBoot项目）

## 简介

差不多一年前就已经接触了springBoot，由于现在公司一直都使用springMVC，所有也一直没有自己搭建springBoot的项目。相比较我们之前使用的spring集成项目，你会觉得没有xml的配置变得更加清晰和简单了。


## 项目参数

- IDEA 2017.1.1

- Maven 3.3.9

- springBoot

- mybatis

- mysql

- swagger

## 生成步骤

IDEA集成了快速配置的方法，如果需要配置一个maven的springboot项目，就不需要通过创建一个maven项目开始，而是可以直接通过`spring Initializr`的方式创建springboot项目。其实idea只是默认通过[https://start.spring.io/](https://start.spring.io/)地址生成项目，如果不通过idea生成，也可以直接通过网站生成。

1、`File -> New -> Project -> Spring Initializr` 
选择项目的JDK环境，我这边默认选择1.8（今年JDK9都出来了，没有必要抱着6和7不放）

![](http://i.imgur.com/mlUqiNw.png)

2、这边可以通过`type`来选择是Maven项目还是Gradle项目，我这边选择maven项目，其他的部分就跟创建maven项目一样。

![](http://i.imgur.com/6guJJHY.png)

3、此步至关重要，通过`spring Initializr`方式创建项目，唯一方便的地方就是他可以通过模板化的方式生成springboot项目，而此处就是选择项目中需要的模板，按照最开始的要求，此处我们选择下图中圈出来的几个模块。
![](http://i.imgur.com/KS3Lbam.png)

4、模板配置完毕之后`Finish`，如果你是第一次创建springboot项目，那么下载jar文件可能比较慢。
![](http://i.imgur.com/E20fJjM.png)

## 具体配置

按照以上方法创建完成之后，会呈现出一下结构的模板，但是距离能够运行还需要几步。

<pre>
|-spring-boot
|--|src
|--|--|main
|--|--|--|Java
|--|--|--|--|Application.java             启动文件，springboot是以main方法启动的。
|--|--|--|--|Swagger.java                 Swagger配置文件(非默认添加)
|--|--|--|resources
|--|--|--|--|META-INF
|--|--|--|--|static                       静态文件，通常放css、js等
|--|--|--|--|templates
|--|--|--|--|application.properties       配置文件，配置数据库连接等
|--|--|test
|--|--|--|Java
|--|pom.xml                               maven文件
|
</pre>

### 1、配置application.properties

本章想要实现通过mybatis对数据库做一次简单的操作，所以这边先配置数据库的连接。（后续会加入连接池之类）

<pre>
spring.datasource.url=jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&autoReconnect=true
spring.datasource.username=root
spring.datasource.password=123456
</pre>

自定义项目启动端口号、session的有效时间等
<pre>
server.port=8888         # 绑定的地址
server.address=
server.session-timeout=  #session有效时长
server.context-path=     #默认为/
</pre>

通过以上配置，就能够启动，并通过mybatis访问数据库。

### 2、配置swagger（推荐使用）

为了方便管理接口，此处引入swagger配置。

- 引入swagger架包


```

	<dependency>
		<groupId>io.springfox</groupId>
		<artifactId>springfox-swagger2</artifactId>
		<version>2.2.2</version>
	</dependency>
	
	<dependency>
		<groupId>io.springfox</groupId>
		<artifactId>springfox-swagger-ui</artifactId>
		<version>2.2.2</version>
	</dependency>

```

- 引入swagger的启动文件，文件跟application.java 同级目录。

<pre>
@Configuration
@EnableSwagger2
public class Swagger2 extends WebMvcConfigurationSupport {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * swagger-ui 头文件注释信息，可以添加说明、作者、版本号等基本信息
     * @return {@link ApiInfo}
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("更多Spring Boot相关文章请关注：http://blog.csdn.net/u012682683")
                .termsOfServiceUrl("https://github.com/pengcgithub")
                .contact("Tracy")
                .version("1.0")
                .build();
    }

    /**
     * 继承<code>WebMvcConfigurationSupport</code>类，重写<code>addResourceHandlers</code>方法，为了解决直接访问swagger出现404的问题
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations(
                "classpath:/META-INF/resources/");
        registry.addResourceHandler("/**").addResourceLocations(
                "classpath:/META-INF/resources/");
    }

}
</pre>

- 如何使用？

由于此篇博文不是swagger专题，所以此处就不单独提出来介绍了，具体的使用可以Google

<pre>
@ApiOperation(value="接口的名称", notes="添加接口说明")
@RequestMapping(value = "/sayHello/{id}", method = RequestMethod.GET)
public UserBean sayHello(@PathVariable String id) {
    return userService.findById(id);
}
</pre>

## 效果

![](http://i.imgur.com/HthRFJE.png)

启动项目，出现以上图片则说明启动成功。

项目启动成功，访问`http://localhost:8888/swagger-ui.html`路径，然后就可以进入到swagger页面测试接口。

![](http://i.imgur.com/wLC917j.png)

## 作者

[https://github.com/pengcgithub](https://github.com/pengcgithub)


