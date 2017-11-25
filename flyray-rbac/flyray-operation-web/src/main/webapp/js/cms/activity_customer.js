$(function () {
    $("#jqGrid").jqGrid({
        url: '../cms/activitycustomer/list',
        datatype: "json",
        colModel: [			
			{ label: '活动序号', name: 'activityId', index: "activityId", width: 45, key: true },
            { label: '活动名称', name: 'activityName', index:"activityName", width: 45},
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
            activityName: null
		},
		showList: true,
		title:null,
		activity:{
			id:null,
            activityName:null,
            interestGroupId:null,
            activityLogo:null,
            activityDes:null,
            activityContent:null,
            activityStartTime:null,
            activityEndTime:null,
            activityAddr:null,
            createTime:null,
            createBy:null,
            flag:null,
            highlights:null,
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
			
			vm.getActivity(id);
		},
		del: function () {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../cms/activity/delete",
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
			var url = vm.group.id == null ? "../cms/activity/save" : "../cms/activity/update";
			$.ajax({
				type: "POST",
			    url: url,
                contentType: 'application/json;charset=utf-8',
			    data: JSON.stringify(vm.activity),
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
        getActivity: function(id){
			$.get("../cms/activity/info/"+id, function(r){
				vm.activity = r.activity;
			});
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                postData:{'activityName': vm.q.activityName},
                page:page
            }).trigger("reloadGrid");
		}
	}
});