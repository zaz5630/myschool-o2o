#2019-07-18
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

5.遇到的问题


#2019-07-19
1.MyBatis的逆向工程

2.Echarts的使用
2.1 集成js文件
<script type="text/javascript" th:src="@{/js/echarts.min.js}"></script>

2.2 需要将静态数据替换成数据库查询出来的动态json数据，并在js中进行解析
  1 先用area的priority进行模拟，展示柱状图
  2 店铺某天/某段时间的销售额思路  --折线图
     1.where条件：某天/某几天 and shop_id = 自己当前的shop_id
     2.product_id * 数量  -- 某个商品  所有的 sum
  
  3 商品销售量的排行思路  ---柱状图 ，本店商品的热度
       count(product_num) group by  商品_id分组
    
  4 商品分类占比  ---饼图
  
2.3 注意点  
    1.后端返回的数据，存放到map结构中，在使用jquery的each遍历时的处理
        data.key就可以直接遍历
    2.如何向数组中添加数据
        xData.push(this.areaName)
    3.将x轴、y轴的数据替换成需要的即可
    
 3.今日任务
 1.店铺的权重top5 ---从shop表查询  ---最基本要求
    扩展：地区的shop分布  ---饼图，area+shop
    
 2.注册店铺  ---上传文件若吃力暂且搁置
    注册完之后，要跳转到哪个页面？ --- 店铺主页
    
    
    

