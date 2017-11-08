$(function () {
    $("#jqGrid").jqGrid({
        url: '../crm/customerRole/list',
        datatype: "json",
        colModel: [
            { label: '角色ID', name: 'id', index: "id", width: 45, key: true },
            { label: '角色号', name: 'roleNo', index: "role_no", width: 45, key: true },
            { label: '角色名称', name: 'roleName', index: "role_name", width: 75 },
            { label: '商铺', name: 'orgId', index: "org_id", width: 100 },
            { label: '组织', name: 'merchantId', index: "merchant_id", width: 80}
        ],
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList : [10,30,50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page",
            rows:"limit",
            order: "order"
        },
        gridComplete:function(){
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
        }
    });
});

var setting = {
    data: {
        simpleData: {
            enable: true,
            idKey: "menuId",
            pIdKey: "parentId",
            rootPId: -1
        },
        key: {
            url:"nourl"
        }
    },
    check:{
        enable:true,
        nocheckInherit:true
    }
};
var ztree;

var vm = new Vue({
    el:'#rrapp',
    data:{
        q:{
            roleName: null
        },
        showList: true,
        title:null,
        CustomerRole:{
            roleNo:null,
            roleName:null,
            orgId:null,
            merchantId:null,
        }

    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function(){
            vm.showList = false;
            vm.title = "新增";
        },
        update: function () {
            var id = getSelectedRow();
            if(id == null){
                return ;
            }

            vm.showList = false;
            vm.title = "修改";

            vm.getCustomerRole(id);

        },
        del: function () {
            var ids = getSelectedRows();
            if(ids == null){
                return ;
            }

            confirm('确定要删除选中的记录？', function(){
                $.ajax({
                    type: "POST",
                    url: "../crm/customerRole/delete",
                    data: JSON.stringify(ids),
                    success: function(r){
                        if(r.code == 0){
                            alert('操作成功', function(index){
                                vm.reload();
                            });
                        }else{
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        saveOrUpdate: function (event) {
            console.log(vm.CustomerRole.id);
            var url = vm.CustomerRole.id == null ? "../crm/customerRole/save" : "../crm/customerRole/update";
            $.ajax({
                type: "POST",
                url: url,
                data: JSON.stringify(vm.CustomerRole),
                success: function(r){
                    console.log(r.code())
                    if(r.code() === 0){
                        alert('操作成功', function(index){
                            vm.reload();
                        });
                    }else{
                        alert(r.msg);
                    }
                }
            });
        },
        getCustomerRole: function(id){
            console.log(id);
            $.get("../crm/customerRole/info/"+id, function(r){
                vm.CustomerRole = r.CustomerRole;
            });
        },
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            $("#jqGrid").jqGrid('setGridParam',{
                postData:{'roleName': vm.q.roleName},
                page:page
            }).trigger("reloadGrid");
        }
    }
});