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
    
    
 #2019-07-20
 1.补充：统计图部分
    本店某个分类下最贵的5件商品 --柱状图
    SELECT norm
    form prj
    WHERE prca_id = 11 ORDER BY DESC LIMIT 0,5  
    商品名称  价格
 
 2.Ajax加载分类/地区信息   *****
    注意：换选择的时候，要将之前的内容给清空掉
 
 3.注册用户--自己实现，身份：个人/店家
    tb_local_auth：添加一个字段，status  1：个人    2：店家
    因为：只有注册了用户信息，才能开店，店铺的owner应该从当前登录人的session中获取user_id
    
 4.商品信息管理模块    *****
    enable_status 0 删除  1 新增：自己店铺编辑但没有发布   2 上架：发布  3.下架
    新增、  修改、查看商品详情、删除、上架、下架
   
   在前端能够看到的应该 enable_status=2  ---前端展示系统中，显示商品时，sql中的查询字段
 
5.折线图 ---某个店铺2019年1-12月份，发布的商品数量折线图    *****
    难点：create_time 如何解析出年、月
    根据create_time 分组统计数量
     SELECT t.d,COUNT(*)
     FROM
     (
     SELECT product_id,product_name,create_time,DATE_FORMAT(create_time,'%d') d
     FROM `tb_product`
     WHERE DATE_FORMAT(create_time,'%y')=17
     ) t
     GROUP BY t.d
  
  
JQuery  内容
注意：在js中遍历json数组，我们常用的方法
1.each()
            $.each(data.areas,function () {
                //alert(this.priority + this.areaName)
                //向数组中添加数据
                xData.push(this.areaName)
                yData.push(this.priority)
            })
2.map()
        $.get("/shop/categories",function (data) {
            data.map(function (item) {
                alert(item.shopCategoryId + ":"+item.shopCategoryName)
            })
        })


3.在Jquery中，如何创建一个带内容的标签
$("<li id='fff'>aaaa<li>")

 如何在一个标签中添加子标签（包括子标签的属性和文本内容）
  $shopCategory.html($optionEle)
  如果只包括文本内容
  text()
  向标签中不断追加内容：append()

使用thymeleaf整合layui
注意：
1.我们从layui中copy的代码,
cols: [[
                         {type:
此时themeleaf会报解析错误，需要将两个[分行显示即可

2.表格数据要关注返回的json格式 --- 我们在后台拼接成如下url返回的格式即可
https://www.layui.com/test/table/demo1.json?page=1&limit=10  

3.解析json格式
cols#field 替换成自己的josn格式中的data里面的字段即可

