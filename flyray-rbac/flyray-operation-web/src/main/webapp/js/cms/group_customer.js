$(function () {
    $("#jqGrid").jqGrid({
        url: '../cms/group/list',
        datatype: "json",
        colModel: [			
        	{ label: '团队序号', name: 'groupId', index: "groupId", width: 45, key: true },
            { label: '团队名称', name: 'groupName', index:"groupName", width: 45},
            { label: '客户序号', name: 'customerId', index:"customerId", width: 45},
            { label: '客户编号', name: 'customerNo', index:"customerNo", width: 45},
            { label: '客户姓名', name: 'custName', index:"custName", width: 45},
            { label: '客户昵称', name: 'nickname', index:"nickname", width: 45},
            { label: '手机号码', name: 'phone', index:"phone", width: 45},
            { label: '客户性别', name: 'sex', index:"sex", width: 45},
            { label: '身份证号', name: 'identityCard', index:"identityCard", width: 45},
            { label: '客户地址', name: 'address', index:"address", width: 45},
            { label: '客户年龄', name: 'age', index:"age", width: 45},
            { label: '客户生日', name: 'birthday', index:"birthday", width: 45}
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

var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
            groupName: null
		},
		showList: true,
		title:null,
		group:{
			id:null,
            groupName:null,
            groupLogo:null,
            groupSlogan:null,
            groupIntro:null,
            groupCategoryId:null,
            groupAddress:null,
            custmerNo:null,
            createTime:null,
            orgId:null,
            merchantId:null,
            flag:null,
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
			
			vm.getGroup(id);
		},
		del: function () {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../cms/group/delete",
                    contentType: 'application/json;charset=utf-8',
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
			var url = vm.group.id == null ? "../cms/group/save" : "../cms/group/update";
			$.ajax({
				type: "POST",
			    url: url,
                contentType: 'application/json;charset=utf-8',
			    data: JSON.stringify(vm.group),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
        getGroup: function(id){
			$.get("../cms/group/info/"+id, function(r){
				vm.group = r.group;
			});
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                postData:{'groupName': vm.q.groupName},
                page:page
            }).trigger("reloadGrid");
		}
	}
});