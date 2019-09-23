$(document).ready(function() {

    //选择数据源按钮弹窗
    db_btns = $("#showDrivers_choosen").find("div")
        .find(".modal-body").find("button")
    $(db_btns[0]).click(function() {
        //CSV弹窗
        $("#showDrivers_choosen").modal("hide")
        $("#csv_import").modal("show")
        //初始化csv的Object
        init_csv_datas()
    })
    $(db_btns[1]).click(function() {
        //EXCEL弹窗
        $("#showDrivers_choosen").modal("hide")
        $("#excel_import").modal("show")
        init_excel_datas()
    })
    $(db_btns[2]).click(function() {
        //MYSQL弹窗
        $("#showDrivers_choosen").modal("hide")

    })
    $(db_btns[3]).click(function() {
        //REDIS弹窗
        $("#showDrivers_choosen").modal("hide")

    })

    //CSV操作
    csv_load("#csv_upload")

    //EXCEL操作
    excel_load("#excel_upload")

    //全部上传
    $("#w_submit").click(function() {
        csv_url("#csv_upload", "/csv/csvUpload")
        csv_datas.submit()
    })

    //全部预览
    $("#w_preview").click(function() {
        csv_url("#csv_upload", "/csv/previewCSV")
        csv_datas.submit()
    })

    //全部上传
    $("#e_submit").click(function() {
        excel_url("#excel_upload", "/excel/excelUpload")
        excel_datas.submit()
    })

    //全部预览
    $("#e_preview").click(function() {
        excel_url("#excel_upload", "/excel/previewExcel")
        excel_datas.submit()
    })

    //关闭全部预览时开启csv上传页面
    $("#csv_preview_close").click(function() {
        $("#csv_import").modal("show")
    })
});
var csv_datas = [] //多文件处理
var index = -1
//初始化CSV的Object
function init_csv_datas() {
    csv_datas = []
    index = -1
    $("#csv_datas").text("")
}

function csv_load(element_id) {
    var pre_data = []
    $(element_id).fileupload({
        url: '/csv/csvUpload',
        type: 'POST',
        dataType: 'json',
        autoUpload: false,
        acceptFileTypes: /(\.|\/)(csv)$/i,
        add: function(e, data) {
            if(index == -1)
                csv_datas = data
            index++
            //显示文件全名，作业显示改成bootstrap table
            filename = data.files[0].name
            datas = "<div>" + filename + "</div>"
            $("#csv_datas").html($("#csv_datas").html() + datas)
            pre_data = data
            csv_datas.files[index] = data.files[0]
        },
        done: function(e, data) {
            result = data.result
            if(result.code == 0) {
                if(result.hasOwnProperty("payload") &&
                    result.payload != null) {
                    $("#csv_import").modal("hide")
                    $("#csv_preview").modal("show")
                    //显示
                    create_csv_btngroup(result.payload)
                } else {
                    flag = confirm("上传成功！")
                    if(flag) {
                        init_csv_datas()
                    } else {
                        $("#csv_import").modal("hide")
                        //刷新数据源列表

                    }
                }
            } else if(result.code == -1) {
                alert("操作失败！")
            }
        }
    });
}

function csv_url(element_id, url) {
    $(element_id).bind('fileuploadsubmit', function(e, data) {
        var separator = " ";
        data.formData = {
            csv_interpret: separator
        };
    });
    $(element_id).fileupload(
        'option',
        'url',
        url
    );
}

var globle_csv_datas = []

function create_csv_btngroup(csv_datas) {
    globle_csv_datas = csv_datas
    btn_group = "<div class=\"btn-group\" role=\"group\">"
    for(i = 0; i < globle_csv_datas.length; i++) {
        data = globle_csv_datas[i]
        if(i == 0) {
            btn_group += "<button onclick=\"create_csv_table(this)\" type=\"button\" class=\"btn btn-primary\">" + data.file_name + "</button>"
        } else {
            btn_group += "<button onclick=\"create_csv_table(this)\" type=\"button\" class=\"btn btn-default\">" + data.file_name + "</button>"
        }
    }
    btn_group += "</div>"
    $("#csv_btngroup").html(btn_group)
    //默认表格
    if(globle_csv_datas != []) {
        init_csv_table(globle_csv_datas[0].file_name)
    }
}

function create_csv_table(btn) {
    btns = $(btn).siblings()
    for(i = 0; i < btns.length; i++) {
        $(btns[i]).attr("class", "btn btn-default")
    }
    $(btn).attr("class", "btn btn-primary")

    //表格
    filename = $(btn).text()
    init_csv_table(filename)
}

function init_csv_table(init_filename) {
    let data = []
    for(i = 0; i < globle_csv_datas.length; i++) {
        if(globle_csv_datas[i].file_name == init_filename) {
            data = globle_csv_datas[i].file_datas
            break
        }
    }

    //根据init_filename动态生成table,注意每个文件表头可能不同
    ths = []
    if(data.length > 0) {
        data0 = data[0]
        for(key in data0) {
            th = {
                field: key,
                title: key,
                visible: true
            }
            ths.push(th)
        }
    }

    $('#csv_table').bootstrapTable({
        striped: true, // 是否显示行间隔色
        cache: false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true, // 是否显示分页（*）
        sortable: false, // 是否启用排序
        sidePagination: "client", // 分页方式：client客户端分页，server服务端分页（*）
        pageNumber: 1, // 初始化加载第一页，默认第一页
        pageSize: 10, // 每页的记录行数（*）
        pageList: [10, 20, 30, 40], // 可供选择的每页的行数（*）
        search: true, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
        strictSearch: false,
        showColumns: true, // 是否显示所有的列
        showRefresh: true, // 是否显示刷新按钮
        minimumCountColumns: 2, // 最少允许的列数
        clickToSelect: true, // 是否启用点击选中行
        showToggle: false, // 是否显示详细视图和列表视图的切换按钮
        cardView: false, // 是否显示详细视图
        detailView: false,
        columns: ths
    });

    $('#csv_table').bootstrapTable("load", data)

}
var excel_datas = []
var excel_index = -1

function excel_load(element_id) {
    var excel_pre_data = []
    $(element_id).fileupload({
        url: '/excel/excelUpload',
        type: 'POST',
        dataType: 'json',
        autoUpload: false,
        acceptFileTypes: /(\.|\/)(xls|xlsx)$/i,
        add: function(e, data) {
            if(excel_index == -1)
                excel_datas = data
            excel_index++
            //显示文件全名，作业显示改成bootstrap table
            filename = data.files[0].name

            //显示成图3中的样子
            let row_data = {}
            row_data["excel_filename"] = filename
            excel_filter = "<div>是否过滤?</div>"
            excel_filter += "<div>"
            excel_filter += "<label class=\"radio-inline\"><input type='radio' value='yes' name='filter" + filename + "'>&nbsp;&nbsp;&nbsp;&nbsp;是</label>"
            excel_filter += "<label class=\"radio-inline\"><input type='radio' value='no' name='filter" + filename + "' checked>&nbsp;&nbsp;&nbsp;&nbsp;否</label>"
            excel_filter += "</div>"
            row_data["excel_filter"] = excel_filter
            row_data["open_config"] = "<button class=\"btn btn-default\" onclick=\"open_config('" + filename + "')\">打开配置</button>"
            $('#excel_table').bootstrapTable("append", row_data)
            //初始化默认过滤条件
            this_excel_interpret = { "filename": filename, "isfilter": false }
            excel_interpret.push(this_excel_interpret)
            //初始化过滤模态框
            let oper_string = $(".oper_string")
            for(i=1;i<oper_string.length;i++)
                $(oper_string[i]).remove()
            $("#excel_interpret form")[0].reset()

            excel_pre_data = data
            excel_datas.files[excel_index] = data.files[0]
        },
        done: function(e, data) {
            result = data.result
            if(result.code == 0) {
                if(result.hasOwnProperty("payload") &&
                    result.payload != null) {
                    //显示预览
                    preview_excel(result.payload)

                } else {
                    flag = confirm("上传成功！")
                    if(flag) {
                        //初始化
                        init_excel_datas()
                    } else {
                        $("#excel_import").modal("hide")
                        //刷新数据源列表

                    }
                }
            } else if(result.code == -1) {
                alert("操作失败！")
            }
        }
    });
}

var globle_excel_datas = []

function init_excel_datas() {
    globle_excel_datas = []
    excel_interpret = []
    excel_datas = []
    excel_index = -1
    $('#excel_table').bootstrapTable({
        striped: false, // 是否显示行间隔色
        cache: false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: false, // 是否显示分页（*）
        sortable: false, // 是否启用排序
        sidePagination: "client", // 分页方式：client客户端分页，server服务端分页（*）
        pageNumber: 0, // 初始化加载第一页，默认第一页
        pageSize: 10, // 每页的记录行数（*）
        pageList: [10, 20, 30, 40], // 可供选择的每页的行数（*）
        search: false, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
        strictSearch: false,
        showColumns: false, // 是否显示所有的列
        showRefresh: false, // 是否显示刷新按钮
        minimumCountColumns: 3, // 最少允许的列数
        clickToSelect: false, // 是否启用点击选中行
        showToggle: false, // 是否显示详细视图和列表视图的切换按钮
        cardView: false, // 是否显示详细视图
        detailView: false,
        columns: [{
            field: "excel_filename",
            visible: true
        }, {
            field: "excel_filter",
            visible: true
        }, {
            field: "open_config",
            visible: true
        }]
    });
    $('#excel_table').bootstrapTable("removeAll")
}
var excel_interpret = []

function open_config(filename) {
    $("#excel_import").modal("hide")
    $("#excel_interpret").modal("show")
    $("#ex_filename").val(filename)
}

function ex_inter_back() {
    $("#excel_import").modal("show")
    $("#excel_interpret").modal("hide")
}

function ex_interpret_submit() {
    $("#excel_import").modal("show")
    $("#excel_interpret").modal("hide")
    let filename = $("#ex_filename").val()
    let interpret_filter = {}
    let start_line = $("#start_line").val()
    let end_line = $("#end_line").val()
    let index_logic = $("#index_string")
        .find("input[name='index_logic']:checked").val()
    if(start_line != "")
        interpret_filter["start_line"] = start_line
    if(end_line != "")
        interpret_filter["end_line"] = end_line
    if(index_logic != undefined)
        interpret_filter["index_logic"] = index_logic
    let index_string = []
    let oper_string_div = $(".oper_string")
    for(i = 0; i < oper_string_div.length; i++) {
        let oper = oper_string_div[i]
        let oper_string = {}
        let start_string = $(oper).find("input:eq(0)").val()
        let end_string = $(oper).find("input:eq(1)").val()
        let content_string = $(oper).find("input:eq(2)").val()
        if(start_string != "" || end_string != "" ||
            content_string != "") {
            oper_string["start_string"] = start_string
            oper_string["end_string"] = end_string
            oper_string["content_string"] = content_string
            index_string.push(oper_string)
        }
    }
    if(index_string.length != 0)
        interpret_filter["index_string"] = index_string
    if(JSON.stringify(interpret_filter) != "{}") {
        for(i = 0; i < excel_interpret.length; i++) {
            if(excel_interpret[i]["filename"] == filename){
                excel_interpret[i]["isfilter"] = true
                excel_interpret[i]["interpret_filter"]
                    = interpret_filter
                break
            }
        }
    }
}

function create_inter_div() {
    $("#index_string").find("div:eq(0)").append($(".oper_string:eq(0)").prop("outerHTML"))
}

function excel_url(element_id, url) {
    $(element_id).bind('fileuploadsubmit', function(e, data) {
        data.formData = {
            excel_interpret: JSON.stringify(excel_interpret)
        };
    });
    $(element_id).fileupload(
        'option',
        'url',
        url
    );
}

function preview_excel(payload) {
    $("#excel_import").modal("hide")
    $("#excel_preview").modal("show")

    globle_excel_datas = payload
    btn_group = "<div class=\"btn-group\" role=\"group\">"
    for(i = 0; i < globle_excel_datas.length; i++) {
        data = globle_excel_datas[i]
        if(i == 0) {
            btn_group += "<button onclick=\"create_excel_select(this)\" type=\"button\" class=\"btn btn-primary\">" + data.file_name + "</button>"
        } else {
            btn_group += "<button onclick=\"create_excel_select(this)\" type=\"button\" class=\"btn btn-default\">" + data.file_name + "</button>"
        }
    }
    btn_group += "</div>"
    $("#excel_preview_btngroup").html(btn_group)

    if(globle_excel_datas != []) {

        filename = globle_excel_datas[0].file_name
        sheetname = globle_excel_datas[0].file_datas[0].sheet_name

        //默认菜单
        let sel = "<select id='" + filename + "' class='selectpicker' onchange='choose_excel_select(this)'>"
        for(i = 0; i < globle_excel_datas.length; i++) {
            let e_data = globle_excel_datas[i]
            if(filename == e_data.file_name) {
                let f_datas = e_data.file_datas
                for(x = 0; x < f_datas.length; x++) {
                    if(x == 0)
                        init_sheet = f_datas[x].sheet_name
                    sel += "<option value='" + f_datas[x].sheet_name + "'>" + f_datas[x].sheet_name + "</option>"
                }
                break
            }
        }
        sel += "</select>"
        $("#excel_preview_select").html(sel)
        //默认表格
        init_excel_table(filename, sheetname)
    }
}

function create_excel_select(btn) {
    btns = $(btn).siblings()
    for(i = 0; i < btns.length; i++) {
        $(btns[i]).attr("class", "btn btn-default")
    }
    $(btn).attr("class", "btn btn-primary")

    //表格
    filename = $(btn).text()
    let init_sheet = ""
    //下拉菜单
    let sel = "<select id='" + filename + "' class='selectpicker' onchange='choose_excel_select(this)'>"
    for(i = 0; i < globle_excel_datas.length; i++) {
        let e_data = globle_excel_datas[i]
        if(filename == e_data.file_name) {
            let f_datas = e_data.file_datas
            for(x = 0; x < f_datas.length; x++) {
                if(x == 0)
                    init_sheet = f_datas[x].sheet_name
                sel += "<option value='" + f_datas[x].sheet_name + "'>" + f_datas[x].sheet_name + "</option>"
            }
            break
        }
    }
    sel += "</select>"
    $("#excel_preview_select").html(sel)

    //初始化一次表格
    init_excel_table(filename, init_sheet)
}

function choose_excel_select(sel) {
    let sheetname = $(sel).val()
    let filename = $(sel).attr("id")
    init_excel_table(filename, sheetname)
}

function init_excel_table(filename, sheetname) {
    let datas = []
    let ths = []
    for(i = 0; i < globle_excel_datas.length; i++) {
        let e_data = globle_excel_datas[i]
        if(filename == e_data.file_name) { //找文件名
            let f_datas = e_data.file_datas
            for(x = 0; x < f_datas.length; x++) {
                if(sheetname == f_datas[x].sheet_name) { //找sheet
                    sheetdatas = f_datas[x].sheet_datas
                    //遍历key生成表头
                    for(key in sheetdatas[0]) {
                        let th = {
                            field: key,
                            title: key,
                            visible: true
                        }
                        ths.push(th)
                    }
                    datas = sheetdatas
                    break
                }
            }
        }
    }

    $('#excel_preview_table').bootstrapTable("destroy")
    $('#excel_preview_table').bootstrapTable({
        striped: true, // 是否显示行间隔色
        cache: false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true, // 是否显示分页（*）
        sortable: false, // 是否启用排序
        sidePagination: "client", // 分页方式：client客户端分页，server服务端分页（*）
        pageNumber: 1, // 初始化加载第一页，默认第一页
        pageSize: 10, // 每页的记录行数（*）
        pageList: [10, 20, 30, 40], // 可供选择的每页的行数（*）
        search: true, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
        strictSearch: false,
        showColumns: true, // 是否显示所有的列
        showRefresh: true, // 是否显示刷新按钮
        minimumCountColumns: 2, // 最少允许的列数
        clickToSelect: true, // 是否启用点击选中行
        showToggle: false, // 是否显示详细视图和列表视图的切换按钮
        cardView: false, // 是否显示详细视图
        detailView: false,
        columns: ths
    });
    $('#excel_preview_table').bootstrapTable("load", datas)
}