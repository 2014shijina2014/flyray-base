$(function () {
    $("#jqGrid").jqGrid({
        url: '../cms/activity/list',
        datatype: "json",
        colModel: [			
			{ label: 'ID', name: 'id', index: "id", width: 45, key: true },
            { label: '活动名称', name: 'activityName', index:"activity_name", width: 45},
            { label: '所属团队', name: 'interestGroupId', index:"interest_group_id", width: 45},
            { label: '活动Logo', name: 'activityLogo', index:"activity_logo", width: 45},
            { label: '活动简介', name: 'activityDes', index:"activity_des", width: 45},
            { label: '活动内容', name: 'activityContent', index:"activity_content", width: 45},
            { label: '活动开始时间', name: 'activityStartTime', index:"activity_start_time", width: 45},
            { label: '活动结束时间', name: 'activityEndTime', index:"activity_end_time", width: 45},
            { label: '活动地址', name: 'activityAddr', index:"activity_addr", width: 45},
            { label: '创建时间', name: 'createTime', index:"create_time", width: 45},
            { label: '创建人', name: 'createBy', index:"create_by", width: 45},
            { label: '标记', name: 'flag', index:"flag", width: 45},
            { label: '活动花絮', name: 'highlights', index:"highlights", width: 45}
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