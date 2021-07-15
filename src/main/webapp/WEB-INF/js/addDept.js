$(function () {
    var $addBtn = $(".add_btn");
    var $deptName = $(".dept_name");
    var $deptMana = $(".dept_mana");
    var $deptCode = $(".dept_code");
    var $list = $(".inner_center_info_list");

    $.ajax({
        url: "/dept/queryAll",
        type: "get",
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        data: {
            pageNo: 1,
            pageNum: 9,
            search: null
        },
        success: function (result) {
            $list.html("")
            for (var dept of result.data) {
                var tmp = `<div class="dept_div list">
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

    $addBtn.on("click", function () {
        $.ajax({
            url: "/dept/add",
            type: "post",
            dataType: "json",
            contentType: "application/json;charset=utf-8",
            data: JSON.stringify({
                name: $deptName.val(),
                manaId: $deptMana.val(),
                code: $deptCode.val()
            }),
            success: function (result) {
                window.location.reload();
                // $list.html("")
                // for (var dept of result.data) {
                //     var tmp = `<div class="dept_div list">
                //                 <span class="name">${dept.name} 部</span>
                //                 <span class="toe">${dept.createTimeString}</span>
                //                 <span class="code">${dept.code}</span>
                //                 <span class="mana">${dept.manaName}</span>
                //                 <span class="count">${dept.count} 人</span>
                //             </div>`;
                //     $list.append(tmp);
                // }
            }
        })
    })

})