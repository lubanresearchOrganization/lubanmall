


var shopproductsearch = (function ($,urlutil,lajaxComponent,searchbar){

       var shopproductsearch = {};
　　　　shopproductsearch.init = function () {

           searchbar.init();
           var shopId = urlutil.getParameter("id");
           var key = urlutil.getParameter("key");
           var page = urlutil.getParameter("page");
                      var size = urlutil.getParameter("size");
                      if(!page){
                      page = 0;
                      }else{
                      page = page-1;
                      }
                      if(!size){
                      size = 12;
                      }



           var condition = {
           "type":"query",
           "page":page,
           "size":size
           };
           if(shopId){
            condition.shopId = shopId;
           }


            //初始化类目
                  lajaxComponent.getTextReturnJson(
                  config.baseUrl+"/v/0.1/products/",condition,function(result){

                  $("#rows").html($("#resultTemplate").tmpl(result.items));
                  if(result.pageCount>0){
                       var options = {
                           currentPage:result.pageIndex+1,
                           totalPages: result.pageCount,
                           bootstrapMajorVersion: 3,
                           itemContainerClass: function (type, page, current) {
                                     return (page === current) ? "page-item active" : "page-item";
                           },
                           itemContentClass:"page-link",
                                     pageUrl: function(type, page, current){

                                     return "./productlist.html?page="+page+"&size="+size;

                                     }
                       };

                       $('#pageBar').bootstrapPaginator(options);

                       }

                  });


　　　　};

　　　　return shopproductsearch;

　　})(jQuery,urlutil,lbajax,searchbar);

$(document).ready(function(){
  shopproductsearch.init();
});
