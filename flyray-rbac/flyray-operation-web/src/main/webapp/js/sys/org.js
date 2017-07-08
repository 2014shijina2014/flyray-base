var setting = {
    data: {
        simpleData: {
            enable: true,
            idKey: "orgId",
            pIdKey: "parentId",
            rootPId: -1
        },
        key: {
            url:"nourl"
        }
    }
};
var ztree;

var vm = new Vue({
    el:'#rrapp',
    data:{
        showList: true,
        title: null,
        org:{
            parentName:null,
            parentId:0,
            orgLevel:0
        }
    },
    methods: {
        getOrg: function(){
            //加载部门树
            $.get(baseURL + "sys/org/select", function(r){
                ztree = $.fn.zTree.init($("#orgTree"), setting, r.orgList);
                var node = ztree.getNodeByParam("orgId", vm.org.parentId);
                ztree.selectNode(node);

                vm.org.parentName = node.name;
            })
        },
        add: function(){
            vm.showList = false;
            vm.title = "新增";
            vm.org = {parentName:null,parentId:0,orgLevel:0};
            vm.getOrg();
        },
        update: function () {
            var orgId = getOrgId();
            if(orgId == null){
                return ;
            }

            $.get(baseURL + "sys/org/info/"+orgId, function(r){
                vm.showList = false;
                vm.title = "修改";
                vm.org = r.org;

                vm.getOrg();
            });
        },
        del: function () {
            var orgId = getOrgId();
            if(orgId == null){
                return ;
            }

            confirm('确定要删除选中的记录？', function(){
                $.ajax({
                    type: "POST",
                    url: baseURL + "sys/org/delete",
                    data: "orgId=" + orgId,
                    success: function(r){
                        if(r.code === 0){
                            alert('操作成功', function(){
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
            var url = vm.org.orgId == null ? "sys/org/save" : "sys/org/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.org),
                success: function(r){
                    if(r.code === 0){
                        alert('操作成功', function(){
                            vm.reload();
                        });
                    }else{
                        alert(r.msg);
                    }
                }
            });
        },
        orgTree: function(){
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择组织机构",
                area: ['300px', '450px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#orgLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                    var node = ztree.getSelectedNodes();
                    //选择上级部门
                    vm.org.parentId = node[0].orgId;
                    vm.org.parentName = node[0].name;

                    layer.close(index);
                }
            });
        },
        reload: function () {
            vm.showList = true;
            Org.table.refresh();
        }
    }
});


var Org = {
    id: "orgTable",
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Org.initColumn = function () {
    var columns = [
        {field: 'selectItem', radio: true},
        {title: '部门ID', field: 'orgId', visible: false, align: 'center', valign: 'middle', width: '80px'},
        {title: '部门名称', field: 'orgName', align: 'center', valign: 'middle', sortable: true, width: '180px'},
        {title: '上级部门', field: 'parentName', align: 'center', valign: 'middle', sortable: true, width: '100px'},
        {title: '排序号', field: 'orgLevel', align: 'center', valign: 'middle', sortable: true, width: '100px'}]
    return columns;
};


function getOrgId () {
    var selected = $('#orgTable').bootstrapTreeTable('getSelections');
    if (selected.length == 0) {
        alert("请选择一条记录");
        return false;
    } else {
        return selected[0].id;
    }
}


$(function () {
    var colunms = Org.initColumn();
    var table = new TreeTable(Org.id, baseURL + "sys/org/list", colunms);
    table.setExpandColumn(2);
    table.setIdField("orgId");
    table.setCodeField("orgId");
    table.setParentCodeField("parentId");
    table.setExpandAll(false);
    table.init();
    Org.table = table;
});
