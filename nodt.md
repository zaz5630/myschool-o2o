#1.dao层
1. 需要依赖comomon层
~~~xml
    <dependencies>
        <!--dao层依赖common层，所以需要加入common的依赖-->
        <dependency>
            <groupId>com.iweb</groupId>
            <artifactId>o2o-common</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
    </dependencies>

2. 需要使用MyBatis
2.1 引入MyBatis的核心配置文件 --其实是可以省略的

2.2 配置数据库连接  --- application.yml


3.在o2o-superadmin模块，使用SpringBootTest进行测试

4.快捷键：ctrl + i  重写方法【继承抽象类、接口】

