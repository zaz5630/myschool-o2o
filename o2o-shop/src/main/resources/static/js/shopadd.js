$(function () {
    //获取分类的select
    var $shopCategory = $("#catetoryId")
    var $subshopCategory = $("#subcategoryId")

    //绑定事件  click/change?
    //获取一级分类信息
   // $shopCategory.on("click",function () {
        $shopCategory.html("");
        $shopCategory.append($("<option value='0'>请选择</option>"));
        //发送ajax请求
        $.get("/shop/categories",function (data) {
            data.map(function (item) {
                //向select标签中添加option
                //将$optionEle添加到$shopCategory
                $shopCategory.append($("<option value='"+item.shopCategoryId+"'>"+item.shopCategoryName+"</option>"))
               //alert(item.shopCategoryId + ":"+item.shopCategoryName)
            })
        })
   // })

    //获取二级分类
    $shopCategory.change(function () {
        //发送ajax请求
        //获取一级分类的value
        $subshopCategory.html("");
        var parentId = $shopCategory.val();
        $("option[value='"+parentId+"']").attr("selected","selected");
        //alert(parentId)
        $.get("/shop/categories",{"parentId":parentId},function (data) {
            data.map(function (item) {
                //向select标签中添加option
                //将$optionEle添加到$shopCategory
                $subshopCategory.append($("<option value='"+item.shopCategoryId+"'>"+item.shopCategoryName+"</option>"))
                //alert(item.shopCategoryId + ":"+item.shopCategoryName)
            })
        })
    })
})