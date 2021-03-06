
var shoplist = (function ($,urlutil,lajaxComponent,searchbar){

       var shoplist = {};
　　　　shoplist.init = function () {

           searchbar.init();
           var key = urlutil.getParameter("key");
           var page = urlutil.getParameter("page");
           var size = urlutil.getParameter("size");
           if(!page){
           page = 0;
           }else{
           page = page-1;
           }
           if(!size){
           size = 6;
           }
           console.log(key);

           var condition = {
               "page":page,
               "size":size
           };
           if(key){
               condition.key = key;
           }

           //初始化类目
                     lajaxComponent.getTextReturnJson(config.baseUrl+"/v/0.1/shops/",condition,function(result){

                     $("#rows").html($("#resultTemplate").tmpl(result.items));
                     if(result.pageCount>0){
                       var options = {
                       currentPage: result.pageIndex+1,
                       totalPages: result.pageCount,
                       bootstrapMajorVersion: 3,
                       itemContainerClass: function (type, page, current) {
                              return (page === current) ? "page-item active" : "page-item";
                        },
                       itemContentClass:"page-link",
                       pageUrl: function(type, page, current){

                                var params = {
                                     "page":page,
                                     "size":size
                                };
                                if(key){
                                    params.key = key;
                                }
                               return "./shoplist.html?"+urlutil.concatParam(params);

                       }
                     }

                   $('#pageBar').bootstrapPaginator(options);
                   }
                   });

　　　　};

　　　　return shoplist;

　　})(jQuery,urlutil,lbajax,searchbar);

$(document).ready(function(){
  shoplist.init();
});
