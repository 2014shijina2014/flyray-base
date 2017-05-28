$(function () {
    $("#jqGrid").jqGrid({
        url: '../sys/org/list',
        datatype: "json",
        colModel: [			
			{ label: '组织机构ID', name: 'orgId', index: "org_id", width: 45, key: true },
			{ label: '组织机构编号', name: 'orgNo', width: 75 },
			{ label: '机构部门名称', name: 'orgName', width: 90 },
			{ label: '所属机构部门', name: 'parentId', width: 100 },
			{ label: '创建人', name: 'createBy', width: 80 },
			{ label: '创建时间', name: 'createTime', width: 80},
			{ label: '最后修改人', name: 'lastUpdateBy', width: 80},
			{ label: '最后修改时间', name: 'lastUpdateTime', width: 80},
			{ label: '机构部门排序号', name: 'orgLevel', width: 80},
			
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
			orgName: null
		},
		showList: true,
		title:null,
		org:{
			orgName:null,
			parentId:0,
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
			var orgId = getSelectedRow();
			if(orgId == null){
				return ;
			}
			
			vm.showList = false;
            vm.title = "修改";
			
			vm.getOrg(orgId);
		},
		del: function () {
			var orgIds = getSelectedRows();
			if(orgIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../sys/org/delete",
				    data: JSON.stringify(orgIds),
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
			var url = vm.org.orgId == null ? "../sys/org/save" : "../sys/org/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.org),
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
		getOrg: function(orgId){
			$.get("../sys/org/info/"+orgId, function(r){
				vm.org = r.org;
			});
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                postData:{'orgName': vm.q.orgName},
                page:page
            }).trigger("reloadGrid");
		}
	}
});