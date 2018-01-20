# springboot-mybatis

DAO 层实现方式及配置（三选一）
	一：	使用类实现 DAO 接口（二选一）：
			1、在启动类中添加对 mapper 包扫描 @MapperScan(" 接口实现类所在的包")（推荐），例：//@MapperScan("com.example.demo.mapper.mapperImpl")
			2、在每个实现类上面添加注解 @Mapper
	二、使用 mapper.xml 文件映射 DAO 接口 （xml 文件中的 id 和 接口中的方法名要一致）：
			在mapper接口上添加 @Mapper 和 @Repository 注解，防止注入失败
			或者在启动类中添加 @MapperScan 扫描mapper接口，并在接口上添加 @Repository
			在 application.properties 文件中添加 mybatis.mapper-locations = "mapper.xml 文件所在的包 + *.xml"，
				例：mybatis.mapper-locations = classpath:mapper/*.xml
			xml 文件中 mapper 的 namespace = "包名 + 接口名"
				例：<mapper namespace="com.example.demo.mapper.UserMapper">
	三、在接口中使用注解方式实现增删改查：
		只需要在接口上添加注解 @Mapper
  
  使用 MyBatis 分页插件 PageHelper
  在 pom.xml 中添加依赖
  	<dependency>
        	<groupId>com.github.pagehelper</groupId>
        	<artifactId>pagehelper</artifactId>
        	<version>4.3.6</version>
 	 </dependency>
  在 mybatis-config.xml 中配置插件信息，或者在启动类中实现配置
