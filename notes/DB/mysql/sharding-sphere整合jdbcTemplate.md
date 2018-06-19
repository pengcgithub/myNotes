# sharding-sphere整合jdbcTemplate

sharding-sphere整合jdbcTemplate，其实跟JDBC以及mybatis连用都是一个道理，只要引入对应的jar文件，继承`sharding:data-source`即可。但是github上基本都是JDBC、mybatis、JPA等等的整合案例，没有完全针对于spring-jdbc的案例，所以这边整理了部分实践内容，仅供参考。
之所以采用sharding-sphere,主要为了解决单表增长速度过快的问题。利用sharding-sphere简单的特性，帮助项目实现分表的功能。

## 导入JAR

	<dependency>
		<groupId>io.shardingjdbc</groupId>
		<artifactId>sharding-jdbc-core-spring-namespace</artifactId>
		<version>${sharding-sphere.version}</version>
	</dependency>
	<dependency>
		<groupId>io.shardingjdbc</groupId>
		<artifactId>sharding-jdbc-core</artifactId>
		<version>${sharding-sphere.version}</version>
	</dependency>

## sharding-sphere整合spring-jdbc

整合配置过程中并不需要变动逻辑代码，只需要在ORM层做对应的整合配置，配置过程一共分为以下几步。

### 1、分表算法
ID的规则为`201711031423461CBD8C56D60A7D868D`，经分析截取ID的前八位，然后分配到不同的表中。具体实现规则如下图所示：

![](https://i.imgur.com/LMcvcYu.png)

### 2、配置替换规则
配置表的替换方式，例如根据`select * from t_order where order_id = ?`进行查询，那么在查询时系统会根据`order_id`的计算规则，然后替换`t_order`为`store_v1.t_order_0`或则`store_v1.t_order_1`表，进而实现分表的功能。

![](https://i.imgur.com/TlEmhbA.png)

**注意事项：**

- data-source-names中的值与DataSource的id值对应，如果DataSource为多个，则每个数据源之间用逗号隔开，并且DataSource的id值一定要跟数据库的名称相同。

### 3、配置spring-jdbc-template整合

如果仅仅与JDBC结合使用，那么只需要在`org.springframework.jdbc.datasource.DataSourceTransactionManager`中继承`sharding:data-source`配置项。如果需要与jdbcTemplate结合使用，那么不仅需要实现上面的操作，还需要在`org.springframework.jdbc.core.JdbcTemplate`中继承`sharding:data-source`。

![](https://i.imgur.com/3KQjfiR.png)

## 问题

- java.lang.IllegalArgumentException: Could not resolve placeholder '0..1' in string value "store_v1.t_order_${0..1}"

由于sharding-sphere中的${}会默认到properties文件中找数据，所以在spring导入properties文件时需要忽略这部分内容。将<context:property-placeholder>中`ignore-unresolvable`这个属性值设置为true即可。

	# 方式一
    <context:property-placeholder location="classpath:config.properties" ignore-unresolvable="true"/>
	
	# 方式二
	@PropertySource(value = "classpath:fastdfs.properties", ignoreResourceNotFound = true)
	
	# 方式三
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigure(){
		return new PropertySourcesPlaceholderConfigurer();
	}

## 参考资料

- [https://github.com/sharding-sphere/sharding-sphere-example](https://github.com/sharding-sphere/sharding-sphere-example)