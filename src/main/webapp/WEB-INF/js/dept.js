$(function (){
    var $list = $(".inner_center_info_list");


    $.ajax({
        url:"/dept/queryAll",
        type:"get",
        dataType:"json",
        contentType: "application/json;charset=utf-8",
        data:{
            pageNo:1,
            pageNum:9,
            search:null
        },
        success:function (result){
            $list.html("")
            for (var dept of result.data) {
                var tmp = `<div class="inner_center_info_dept">
                                <span class="name">${dept.name} 部</span>
                                <span class="toe">${dept.createTimeString}</span>
                                <span class="code">${dept.code}</span>
                                <span class="mana">${dept.manaName}</span>
                                <span class="count">${dept.count} 人</span>
                            </div>`;
                $list.append(tmp);
            }
        }
    })

    $(document).keydown(function(e){
        if(13 === e.keyCode){
            var $searchVal = $(".search_input").val();
            $.ajax({
                url:"/dept/queryAll",
                type:"get",
                dataType:"json",
                contentType: "application/json;charset=utf-8",
                data:{
                    pageNo:1,
                    pageNum:9,
                    search:$searchVal
                },
                success:function (result){
                    $list.html("")
                    for (var dept of result.data) {
                        var tmp = `<div class="inner_center_info_dept">
                                <span class="name">${dept.name} 部</span>
                                <span class="toe">${dept.createTime}</span>
                                <span class="code">${dept.code}</span>
                                <span class="mana">${dept.manaName}</span>
                                <span class="count">${dept.count} 人</span>
                            </div>`;
                        $list.append(tmp);
                    }
                }
            })
        }
    });



})