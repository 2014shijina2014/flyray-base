$(function () {
    $("#jqGrid").jqGrid({
        url: '../cms/group/list',
        datatype: "json",
        colModel: [			
			{ label: 'ID', name: 'id', index: "id", width: 45, key: true },
            { label: '小组名称', name: 'groupName', index:"group_name", width: 45},
            { label: '小组Logo', name: 'groupLogo', index:"group_logo", width: 45},
            { label: '小组口号', name: 'groupSlogan', index:"group_slogan", width: 45},
            { label: '小组介绍', name: 'groupIntro', index:"group_intro", width: 45},
            { label: '小组所属类别', name: 'groupCategoryId', index:"group_category_id", width: 45},
            { label: '小组地址', name: 'groupAddress', index:"group_address", width: 45},
            { label: '创建人', name: 'custmerNo', index:"custmer_no", width: 45},
            { label: '创建时间', name: 'createTime', index:"create_time", width: 45},
            { label: '机构', name: 'orgId', index:"org_id", width: 45},
            { label: '商户', name: 'merchantId', index:"merchant_id", width: 45},
            { label: '标记', name: 'flag', index:"flag", width: 45}
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